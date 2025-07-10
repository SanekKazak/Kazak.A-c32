package org.rides;

import org.rides.config.ContextConfig;
import org.rides.entity.HorseEntity;
import org.rides.entity.PlayerEntity;
import org.rides.service.horse.interfaces.HorsePersistenceService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.lang.reflect.Field;
import java.util.UUID;

public class aaaa {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ContextConfig.class);
//        PlayerCredentialsProcessService bean = context.getBean(PlayerCredentialsProcessService.class);
//            bean.register(new PlayerEntity("123","fsd",23));
        PlayerPersistenceService bean1 = context.getBean(PlayerPersistenceService.class);
        HorsePersistenceService bean2 = context.getBean(HorsePersistenceService.class);
//        bean2.create(new HorseEntity(412.0, "alexa"));
        var value = new PlayerEntity();
        Object a = "qrw";
        var c =  value.getClass();
        try {
            Field field1 = c.getDeclaredField("login");
            Class<?> type = field1.getType();
            value.setLogin(type.cast(a));
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println();
//        var entity = new PlayerEntity();
//        entity.setId(UUID.fromString("463c26bd-ffc5-40e8-a286-4d3930ded5df"));
//        entity.setBalance(42);
//        entity.setLogin("123");
//        bean1.update(entity);
        var entity = bean1.read(UUID.fromString("b74244a7-694b-44f9-857a-2b93d2d33dd7"));
        bean1.update(entity, "token", UUID.randomUUID().toString());
        var entity1 = new HorseEntity(234.0, "alexa");
        bean2.create(entity1);
        var etnity = new PlayerEntity("gjsdf2", "123hi");
        bean1.create(etnity);
    }
}
