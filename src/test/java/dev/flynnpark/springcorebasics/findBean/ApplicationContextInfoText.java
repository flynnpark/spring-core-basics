package dev.flynnpark.springcorebasics.findBean;

import dev.flynnpark.springcorebasics.AppConfig;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class ApplicationContextInfoText {
    AnnotationConfigApplicationContext ac = new AnnotationConfigApplicationContext(AppConfig.class);

    @Test
    @DisplayName("모든 빈 출력하기")
    void findAllBean() {
        String[] allBeanNames = ac.getBeanDefinitionNames();
        for (String beanName : allBeanNames) {
            Object bean = bean = ac.getBean(beanName);
            System.out.println("name = " + beanName + " object = " + bean);
        }
    }

    @Test
    @DisplayName("애플리케이션 빈 출력하기")
    void findApplicationBean() {
        String[] allBeanNames = ac.getBeanDefinitionNames();
        for (String beanName : allBeanNames) {
            BeanDefinition beanDefinition = ac.getBeanDefinition(beanName);

            if (beanDefinition.getRole() == BeanDefinition.ROLE_APPLICATION) {
                Object bean = ac.getBean(beanName);
                System.out.println("name = " + beanName + " object = " + bean);
            }
        }
    }
}
