package com.pfxiong.framework.core.annotation;

import java.lang.annotation.*;

/**
 * 切面注解
 * Created by pfxiong on 2015/11/30 22:22.
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
public @interface Aspect {
    /**
     * 注解
     * @return
     */
    Class<? extends Annotation> value();
}
