package com.favorite.project;

import com.favorite.project.config.CheckBeans;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
public class CheckBeansTest {
    @Autowired
    private CheckBeans checkBeans;

    @Autowired
    private ApplicationContext applicationContext;

    @Test
    public void testPrintAllBeans() {
        assertNotNull(checkBeans);
        checkBeans.printAllBeans();
    }

}
