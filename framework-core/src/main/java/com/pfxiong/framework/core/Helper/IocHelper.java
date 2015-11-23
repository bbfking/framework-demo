package com.pfxiong.framework.core.Helper;

import com.pfxiong.framework.core.annotation.Inject;
import com.pfxiong.framework.core.util.ArrayUtil;
import com.pfxiong.framework.core.util.CollectionUtil;
import com.pfxiong.framework.core.util.ReflectionUtil;

import java.lang.reflect.Field;
import java.util.Map;

/**
 * ioc初始化类
 * Created by pfxiong on 2015/11/23 21:44.
 */
public class IocHelper {
    static {
        Map<Class<?>, Object> beanMap = BeanHelper.getBeanMap();
        if (CollectionUtil.isNotEmpty(beanMap)) {
            for (Map.Entry<Class<?>, Object> beanEntry : beanMap.entrySet()) {
                Class<?> beanClass = beanEntry.getKey();
                Object beanInstance = beanEntry.getValue();
                Field[] beanFields = beanClass.getDeclaredFields();
                if (ArrayUtil.isNotEmpty(beanFields)) {
                    for (Field beanField : beanFields) {
                        if (beanField.isAnnotationPresent(Inject.class)) {
                            Class<?> beanFieldClass = beanField.getType();
                            Object beanFieldInstance = beanMap.get(beanFieldClass);
                            if (beanFieldInstance != null) {
                                ReflectionUtil.setField(beanInstance, beanField, beanFieldInstance);
                            }
                        }
                    }
                }
            }
        }
    }
}
