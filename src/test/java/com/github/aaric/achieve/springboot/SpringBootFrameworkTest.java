package com.github.aaric.achieve.springboot;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * SpringBootActuatorTest
 *
 * @author Aaric, created on 2017-10-23T19:00.
 * @since 0.0.0-SNAPSHOT
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringBootFrameworkTest {

    @Test
    public void testPrint() {
        System.out.println("hello");
    }
}
