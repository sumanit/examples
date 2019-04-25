package org.sumanit.springboot.condition.simplecondition;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;

public class OnSimpleCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println(metadata.isAnnotated(Bean.class.getName()));
        System.out.println(metadata.isAnnotated("suman"));
        System.out.println(metadata.getAnnotationAttributes(ConditionalOnClass.class.getName()).toString());
        System.out.println(metadata.getAnnotationAttributes(ConditionalOnClass.class.getName(),true));
        System.out.println(metadata.getAllAnnotationAttributes(ConditionalOnClass.class.getName()).toString());
        return false;
    }
}
