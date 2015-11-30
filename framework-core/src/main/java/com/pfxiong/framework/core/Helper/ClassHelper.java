package com.pfxiong.framework.core.Helper;

import com.pfxiong.framework.core.annotation.Controller;
import com.pfxiong.framework.core.annotation.Service;
import com.pfxiong.framework.core.util.ClassUtil;

import java.lang.annotation.Annotation;
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
    /**
     * 获取应用包名下某父类（或接口）的所有子类（或实现类）
     */
    public static Set<Class<?>> getClassSetBySuper(Class<?> superClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (superClass.isAssignableFrom(cls) && !superClass.equals(cls)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }

    /**
     * 获取应用包名下带有某注解的所有类
     */
    public static Set<Class<?>> getClassSetByAnnotation(Class<? extends Annotation> annotationClass) {
        Set<Class<?>> classSet = new HashSet<Class<?>>();
        for (Class<?> cls : CLASS_SET) {
            if (cls.isAnnotationPresent(annotationClass)) {
                classSet.add(cls);
            }
        }
        return classSet;
    }
}
