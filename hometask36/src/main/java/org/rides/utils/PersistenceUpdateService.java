package org.rides.utils;

import lombok.SneakyThrows;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.reflections.Reflections;
import org.springframework.stereotype.Service;



import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.Instant;
import java.time.LocalDate;
import java.time.format.DateTimeParseException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import org.reflections.scanners.Scanners;


@Service
public class PersistenceUpdateService {
    private final SessionFactory factory;
    private final Map<Class<?>, Map<Field, Method>> methodsCash = new HashMap();
    private final Map<Class<?>, Method> idInitMethodsCash = new HashMap<>();

    public PersistenceUpdateService(PersistenceService service) {
        factory = service.getFactory();
    }

    @PostConstruct
    public void initClassContext(){
        Reflections reflections = new Reflections("org.rides.entity", Scanners.TypesAnnotated);
        Set<Class<?>> annotated = reflections.getTypesAnnotatedWith(jakarta.persistence.Entity.class);
        annotated.forEach(this::initClassContext);
    }

    public void initClassContext(Class<?> clazz) {
        methodsCashInititializer(clazz);
        getterIdCashInititializer(clazz);
    }

    public void update(Object entity, String field, Object value) {
        Class<?> keyClass = entity.getClass();

        if (!methodsCash.containsKey(keyClass)) {
            initClassContext(keyClass);
            getterIdCashInititializer(keyClass);
        }

        Map<Field, Method> reduced = methodsCash.get(keyClass);

        var necessaryEntryOptional = reduced.entrySet().stream()
                .filter(el -> el.getKey().getName().equals(field))
                .findFirst();

        if (necessaryEntryOptional.isEmpty()) {
            return;
        }

        Method necessaryMethod = necessaryEntryOptional.get().getValue();

        try (Session session = factory.openSession()) {
            Transaction transaction = session.beginTransaction();

            Object result = session.find(
                    keyClass,
                    idInitMethodsCash.get(keyClass).invoke(entity));

            necessaryMethod.invoke(result, value);

            transaction.commit();
        } catch (IllegalAccessException | IllegalArgumentException | DateTimeParseException |
                 InvocationTargetException e) {
            throw new RuntimeException("Ошибка нахождения метода ", e);
        }
    }

    @SneakyThrows
    private void methodsCashInititializer(Class<?> clazz){
        Map<Field, Method> secondary = new HashMap<>();
        Field[] declaredFields = clazz.getDeclaredFields();
        for (Field field : declaredFields) {
            String setter = "set" + field.getName().substring(0, 1).toUpperCase() + field.getName().substring(1);
            secondary.put(field, clazz.getMethod(setter, field.getType()));
        }
        methodsCash.put(clazz, secondary);
    }

    @SneakyThrows
    private void getterIdCashInititializer(Class<?> clazz){
        Method getId = idInitMethodsCash.put(clazz, clazz.getDeclaredMethod("getId"));
        idInitMethodsCash.put(clazz, getId);
    }
}
