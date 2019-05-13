package org.sumanit.springboot.condition.simplecondition;

import org.springframework.context.annotation.Condition;
import org.springframework.context.annotation.ConditionContext;
import org.springframework.context.annotation.Conditional;
import org.springframework.core.type.AnnotatedTypeMetadata;

import java.util.Map;

public class OnSimpleCondition implements Condition {

    @Override
    public boolean matches(ConditionContext context, AnnotatedTypeMetadata metadata) {
        Map<String, Object> annotationAttributes = metadata.getAnnotationAttributes(Conditional.class.getName());
        annotationAttributes.forEach((key,value)->{
            System.out.println(key);
            System.out.println(value);
        });
        return false;
    }
}
