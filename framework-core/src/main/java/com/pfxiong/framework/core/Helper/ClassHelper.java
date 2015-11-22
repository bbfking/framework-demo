package com.pfxiong.framework.core.Helper;

import com.pfxiong.framework.core.annotation.Controller;
import com.pfxiong.framework.core.annotation.Service;
import com.pfxiong.framework.core.util.ClassUtil;

import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * 类操作助手类
 * Created by pfxiong on 2015/11/22 22:58.
 */
public class ClassHelper {
    private static final Set<Class<?>> CLASS_SET;

    static {
        String basePackage = ConfigHelper.getAppBasePackage();
        CLASS_SET = ClassUtil.getClassSet(basePackage);
    }

    /**
     * 获取所有的类
     * @return
     */
    public static Set<Class<?>> getClassSet(){
        return CLASS_SET;
    }

    /**
     * 获取包下所有的controller类
     * @return
     */
    public static Set<Class<?>> getControllerSet(){
        return CLASS_SET.parallelStream()
                .filter(c->c.isAnnotationPresent(Controller.class))
                .collect(Collectors.toSet());
    }
    /**
     * 获取包下所有的service类
     * @return
     */
    public static Set<Class<?>> getServiceSet(){
        return CLASS_SET.parallelStream()
                .filter(c->c.isAnnotationPresent(Service.class))
                .collect(Collectors.toSet());
    }

    /**
     * 获取所有的bean类，包括service controller
     * @return
     */
    public static Set<Class<?>> getBeanSet(){
        Set<Class<?>> beanSet = new HashSet<>();
        beanSet.addAll(getControllerSet());
        beanSet.addAll(getServiceSet());
        return beanSet;
    }

}
