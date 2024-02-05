package com.favorite.project.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

@Component
public class CheckBeans {
    private ApplicationContext applicationContext;

    @Autowired
    public void BeanListPrinter(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
    }

    public CheckBeans(ApplicationContext applicationContext) {
        this.applicationContext = applicationContext;
//        printAllBeans();
    }

    public void printAllBeans() {
        String[] allBeanNames = applicationContext.getBeanDefinitionNames();

        System.out.println("Registered Beans:");
        for (String beanName : allBeanNames) {
            System.out.println(beanName);
        }
    }
}
