package com.stone.learn.redislearn.chapter06;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
import org.springframework.data.redis.core.*;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2019/1/14
 **/
@Component
public class AutoCompleteCompent {

    @Autowired
    private RedisTemplate redisTemplate;

    public void upsertContact(String userId,String contact){
        String recentList = "recent";
//        String recentList = "recent:" + userId;
        redisTemplate.execute(new SessionCallback() {
            @Nullable
            @Override
            public Object execute(RedisOperations redisOperations) throws DataAccessException {
                redisOperations.multi();
                BoundListOperations listOperations = redisOperations.boundListOps(recentList);
                listOperations.remove(1, contact);
                listOperations.leftPush(contact);
                listOperations.trim(0, 99);
                redisOperations.exec();
                return null;
            }
        });
    }

}
