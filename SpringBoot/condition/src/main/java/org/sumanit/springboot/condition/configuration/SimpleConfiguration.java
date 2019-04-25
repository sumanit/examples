package org.sumanit.springboot.condition.configuration;

import org.springframework.boot.autoconfigure.condition.ConditionalOnBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.sumanit.springboot.condition.annotation.ConditionalOnSimple;
import org.sumanit.springboot.condition.model.Student;
import org.sumanit.springboot.condition.model.Teacher;

@Configuration
public class SimpleConfiguration {

    @Bean(name = "teacher",destroyMethod = "destory",initMethod = "init")
    @ConditionalOnSimple("simple1")
    @ConditionalOnSimple("simple2")
    @ConditionalOnClass(Student.class)
    @ConditionalOnBean(Teacher.class)
    protected Teacher teacher(){
        Teacher teacher = new Teacher();
        teacher.setName("苏曼");
        return teacher;
    }

}
