package com.test;

import com.entity.UserInfo;
import com.service.UserInfoService;
import config.AppConfig;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import java.util.List;

public class TestUser {
    @Test
    public void test_getAll(){
        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
        UserInfoService service = context.getBean(UserInfoService.class);
        List<UserInfo> userInfos = service.getAll(1, 3);
        for (UserInfo userInfo : userInfos) {
            System.out.println(userInfo.toString());
        }
    }
//    @Test
//    public void test_deleteAndinsert(){
//        ApplicationContext context = new AnnotationConfigApplicationContext(AppConfig.class);
//        UserInfoService service = context.getBean(UserInfoService.class);
//        service.deleteAndinsert(3,"窝窝头");
//    }
}
