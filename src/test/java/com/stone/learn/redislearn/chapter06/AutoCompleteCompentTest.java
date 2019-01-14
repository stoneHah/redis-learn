package com.stone.learn.redislearn.chapter06;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import static org.junit.Assert.*;

/**
 * ${DESCRIPTION}
 *
 * @author qun.zheng
 * @create 2019/1/14
 **/
@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoCompleteCompentTest {

    @Autowired
    private AutoCompleteCompent autoCompleteCompent;

    @Test
    public void upsertContact() throws Exception {
        autoCompleteCompent.upsertContact("123","zhengqun");
    }

}