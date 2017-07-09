package com.web.dto;

import com.web.dao.ContentDao;
import com.web.entity.Content;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by Mew on 2017/7/6.
 */
public class ContentDto {
    ApplicationContext context = new ClassPathXmlApplicationContext("application-spring-mybatis.xml");
    ContentDao dao = context.getBean(ContentDao.class);

    public Content getAndInsertContent(int price, String title, String pic, String summary, String detail) {
        Content content = new Content();
        content.setPrice(price);
        content.setTitle(title);
        content.setPic(pic);
        content.setSummary(summary);
        content.setDetail(detail);
        dao.insertPublic(content);
        content.setId(dao.getContentId(price, title, pic, summary, detail));
        return content;
    }

    public void updateContent(Content content){dao.updateContent(content);}

    public Content getContent(int id) {
        return dao.getContent(id);
    }
}
