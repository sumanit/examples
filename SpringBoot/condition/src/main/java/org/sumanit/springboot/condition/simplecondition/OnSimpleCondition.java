package org.sumanit.springboot.condition.simplecondition;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.core.type.AnnotatedTypeMetadata;
import org.sumanit.springboot.condition.annotation.ConditionalOnSimple;
import org.sumanit.springboot.condition.annotation.ConditionalOnSimples;

public class OnSimpleCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        System.out.println(metadata.isAnnotated(Bean.class.getName()));
        System.out.println(metadata.isAnnotated("suman"));
        System.out.println(metadata.getAnnotationAttributes(ConditionalOnSimples.class.getName()).toString());
        System.out.println(metadata.getAnnotationAttributes(ConditionalOnSimples.class.getName(),true));
        System.out.println(metadata.getAllAnnotationAttributes(ConditionalOnSimple.class.getName()).toString());
        return false;
    }
}
