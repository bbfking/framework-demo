package com.pfxiong.framework.core.Helper;

import com.pfxiong.framework.core.util.ReflectionUtil;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * bean 助手类
 * Created by pfxiong on 2015/11/22 23:43.
 */
public class BeanHelper {
    private static final Map<Class<?>,Object> BEAN_MAP = new HashMap<>();

    static {
        Set<Class<?>> beanSet = ClassHelper.getBeanSet();
        beanSet.parallelStream().collect(Collectors.toMap(c->c, b->ReflectionUtil.newInstance(b)));
    }

    /**
     * 获取bean映射
     * @return
     */
    public static Map<Class<?>, Object> getBeanMap(){
        return BEAN_MAP;
    }

    @SuppressWarnings("unchecked")
    public static <T> T getBean(Class<T> cls){
        if(!BEAN_MAP.containsKey(cls)){
          throw new RuntimeException("can not get bean by class: " + cls);
        }
        return (T)BEAN_MAP.get(cls);
    }
}
