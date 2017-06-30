import com.web.dao.PersonDao;
import com.web.entity.Person;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestMybatisUser {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("application-spring-mybatis.xml");
		PersonDao dao = context.getBean(PersonDao.class);
		Person person = dao.getContent(1);
		System.out.println(person.getUserName()+" "+person.getUserPassword());
		((ConfigurableApplicationContext) context).close();
	}

}
