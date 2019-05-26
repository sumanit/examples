package org.sumanit.springboot.condition.annotation;


import org.springframework.context.annotation.Conditional;
import org.sumanit.springboot.condition.simplecondition.OnSimpleCondition;

import java.lang.annotation.*;

@Target({ ElementType.TYPE, ElementType.METHOD })
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Conditional(OnSimpleCondition.class)
public @interface ConditionalOnSimples {
    ConditionalOnSimple[] value();
}
