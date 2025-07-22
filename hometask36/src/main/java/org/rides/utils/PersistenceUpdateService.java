package org.rides.utils;

import jakarta.annotation.PostConstruct;
import lombok.Getter;
import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.reflections.Reflections;
import org.reflections.scanners.Scanners;
import org.springframework.stereotype.Service;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Service
public class PersistenceUpdateService {
    private final SessionFactory factory;
    private final Map<Class<?>, Map<Field, Method>> methodsCash = new HashMap();
    private final Map<Class<?>, Method> idInitMethodsCash = new HashMap<>();

    public PersistenceUpdateService(PersistenceService service) {
        factory = service.getFactory();
    }

    @PostConstruct
    public void initClassContext() {
        Reflections reflections = new Reflections("org.rides.entity", Scanners.TypesAnnotated);
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(jakarta.persistence.Entity.class);
        annotated.forEach(this::initClassContext);
    }

    @SneakyThrows
    public void update(Object entity, String field, Object value) {
        Class<?> keyClass = entity.getClass();

        if (!methodsCash.containsKey(keyClass)) {
            initClassContext(keyClass);
            getterIdCashInitializer(keyClass);
        }

        Map<Field, Method> reduced = methodsCash.get(keyClass);

        var necessaryEntryOptional = reduced.entrySet().stream()
                .filter(el -> el.getKey().getName().equals(field))
                .findFirst();

        if (necessaryEntryOptional.isEmpty()) {
            return;
        }

        Method necessaryMethod = necessaryEntryOptional.get().getValue();

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Object result = session.find(
                keyClass,
                idInitMethodsCash.get(keyClass).invoke(entity));

        necessaryMethod.invoke(result, value);

        transaction.commit();
    }

    @SneakyThrows
    public void multiUpdate(Object entity, List<String> fields) {
        Class<?> clazz = entity.getClass();

        if (!methodsCash.containsKey(clazz)) {
            initClassContext(clazz);
        }

        Map<Method, Object> valuesFromEntity = getValues(entity);
        Map<Field, Method> reduced = methodsCash.get(clazz);

        Map<Field, Method> sortedFieldDeclaration = reduced.entrySet().stream()
                .filter(entry -> fields.contains(entry.getKey().getName()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));

        Session session = factory.openSession();
        Transaction transaction = session.beginTransaction();

        Object mirror = session.getReference(
                clazz,
                idInitMethodsCash.get(clazz).invoke(entity));

        for (var valueEl : valuesFromEntity.entrySet()) {
            for (var declaredEl : sortedFieldDeclaration.entrySet()) {
                if (valueEl.getKey().getName().equals(declaredEl.getValue().getName())) {
                    valueEl.getKey().invoke(mirror, valueEl.getValue());
                    break;
                }
            }
        }

        transaction.commit();
        session.close();
    }

    @SneakyThrows
    private Map<Method, Object> getValues(Object obj) {
        Map<Method, Object> result = new HashMap<>();
        if (obj == null) {
            return result;
        }

        Class<?> clazz = obj.getClass();
        Field[] fields = clazz.getDeclaredFields();

        for (Field field : fields) {
            field.setAccessible(true);
            Object value = field.get(obj);
            if (value != null) {
                String setter = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
                result.put(clazz.getMethod(setter, field.getType()), value);
            }
        }

        return result;
    }

    private void initClassContext(Class<?> clazz) {
        methodsCashInitializer(clazz);
        getterIdCashInitializer(clazz);
    }

    @SneakyThrows
    private void methodsCashInitializer(Class<?> clazz) {
        Map<Field, Method> secondary = new HashMap<>();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            String setter = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            secondary.put(field, clazz.getMethod(setter, field.getType()));
        }
        methodsCash.put(clazz, secondary);
    }

    @SneakyThrows
    private void getterIdCashInitializer(Class<?> clazz) {
        Method getId = clazz.getDeclaredMethod("getId");
        idInitMethodsCash.put(clazz, getId);
    }
}

