package com.dhc.java.ai.langchain4j;

import com.dhc.java.ai.langchain4j.bean.ChatMessages;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;

@SpringBootTest
public class MongoCrudTest {

    @Autowired
    private MongoTemplate mongoTemplate;

    /*
    插入文档
    */
    /*@Test
    public void testInsert(){
        mongoTemplate.insert(new ChatMessages("1", "聊天记录"));
    }*/

    @Test
    public void testInsert2(){
        ChatMessages chatMessages = new ChatMessages();
        chatMessages.setContent("聊天记录列表");
        mongoTemplate.insert(chatMessages);
    }

    /*
    * 根据id查询文档
    * */
    @Test
    public void testFindById(){
        System.out.println(mongoTemplate.findById("69db87732386694b5608e85e", ChatMessages.class));
    }

    /*
    * 修改文档
    * */
    @Test
    public void testUpdate(){
        Criteria criteria = Criteria.where("_id").is("69db87732386694b5608e85e");
        Query query = new Query(criteria);
        Update update = new Update();
        update.set("content", "修改后的内容");

        //修改或新增，若修改的时候没有就会新增
        mongoTemplate.upsert(query, update, ChatMessages.class);
    }

    /*
    * 删除文档
    * */
    @Test
    public void testDelete(){
        Criteria criteria = Criteria.where("_id").is("69db87732386694b5608e85e");
        Query query = new Query(criteria);
        mongoTemplate.remove(query, ChatMessages.class);
    }
}
