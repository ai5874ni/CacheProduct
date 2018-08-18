package com.roncoo.eshop.cache.spring;

import org.springframework.context.ApplicationContext;

/**
 * @program: cache
 * @description: ${description}
 * @author: Li YangLin
 * @create: 2018-08-09 23:02
 */
public class SpringContext {
    private static ApplicationContext applicationContext;

    public static ApplicationContext getApplicationContext() {
        return applicationContext;
    }

    public static void setApplicationContext(ApplicationContext applicationContext) {
        SpringContext.applicationContext = applicationContext;
    }
}
