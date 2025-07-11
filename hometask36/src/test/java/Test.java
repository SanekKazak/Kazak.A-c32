import org.rides.config.ContextConfig;
import org.rides.utils.PersistenceUpdateService;
import org.rides.entity.PlayerEntity;
import org.rides.service.player.interfaces.PlayerPersistenceService;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.UUID;

public class Test {
    public static void main(String[] args) {
        var context = new AnnotationConfigApplicationContext(ContextConfig.class);
        PlayerPersistenceService bean1 = context.getBean(PlayerPersistenceService.class);
//        HorsePersistenceService bean2 = context.getBean(HorsePersistenceService.class);
//        bean2.create(new HorseEntity(412.0, "alexa"));
//        System.out.println();
//        var entity = new PlayerEntity();
//        entity.setId(UUID.fromString("463c26bd-ffc5-40e8-a286-4d3930ded5df"));
//        entity.setBalance(42);
//        entity.setLogin("123");
//        bean1.update(entity);
//        var entity = bean1.read(UUID.fromString("b74244a7-694b-44f9-857a-2b93d2d33dd7"));
//        bean1.update(entity, "token", UUID.randomUUID().toString());
//        var entity1 = new HorseEntity(234.0, "alexa");
//        bean2.create(entity1);
//        var etnity = new PlayerEntity("gjsdf2", "123hi");
//        bean1.create(etnity);
        PersistenceUpdateService bean = context.getBean(PersistenceUpdateService.class);
//        var e = new PlayerEntity();
//        e.setId(UUID.fromString("804ca61b-0220-4a7a-b854-96f5dbdb58c1"));
//        bean.update(e, "token", null);
//        e.setId(UUID.fromString(""));
//        e.setLogin("gjsdf2");
//        bean.initClassContext(PlayerEntity.class);
//        bean.update(e, "login", "fjiwwfi");
        System.out.println();
    }

}
