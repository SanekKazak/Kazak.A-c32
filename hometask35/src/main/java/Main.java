import org.alex.Service;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("client-service.xml");

        var bean = context.getBean(Service.class);

        bean.work();
    }
}
