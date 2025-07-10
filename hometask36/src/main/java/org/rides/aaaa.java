package org.rides;

import org.rides.config.ContextConfig;
import org.rides.entity.HorseEntity;
import org.rides.service.horse.interfaces.HorsePersistenceService;
import org.rides.service.player.interfaces.PlayerCredentialsService;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class aaaa {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ContextConfig.class);
        PlayerCredentialsService bean = context.getBean(PlayerCredentialsService.class);
//        bean.register(new PlayerEntity("123","fsd",23));
        PlayerPersistenceService bean1 = context.getBean(PlayerPersistenceService.class);
        HorsePersistenceService bean2 = context.getBean(HorsePersistenceService.class);
        bean2.create(new HorseEntity(412.0, "alexa"));
        System.out.println();
    }
}
