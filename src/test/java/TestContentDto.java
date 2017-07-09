import com.web.dao.ContentDao;
import com.web.dao.PersonDao;
import com.web.dto.ContentDto;
import com.web.entity.Content;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.sql.SQLException;

/**
 * Created by Mew on 2017/7/6.
 */
public class TestContentDto {
    public static void main(String[] args) throws SQLException {
        ContentDto contentDto = new ContentDto();
        Content content = contentDto.getContent(32);
        content.setTitle("aaa");
        contentDto.updateContent(content);
        content = contentDto.getContent(32);
        System.out.println(content.getTitle());
    }
}
