package com.wrh.util;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * @Author：wojiushimogui
 * @Description:
 * @Date:Created by 下午4:55 on 2017/6/5.
 */
public class SpringUtil {
    private static ApplicationContext ctx = new ClassPathXmlApplicationContext("applicationContext.xml");
    public static Object getBean(String beanName){
        return ctx.getBean(beanName);
    }

}
