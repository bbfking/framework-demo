package com.pfxiong.framework.core;


import com.pfxiong.framework.core.Helper.BeanHelper;
import com.pfxiong.framework.core.Helper.ClassHelper;
import com.pfxiong.framework.core.Helper.ControllerHelper;
import com.pfxiong.framework.core.Helper.IocHelper;
import com.pfxiong.framework.core.util.ClassUtil;

/**
 * 加载相应的 Helper 类
 *
 * @author  pfxiong
 * @since 1.0.0
 */
public final class HelperLoader {

    public static void init() {
        Class<?>[] classList = {
            ClassHelper.class,
            BeanHelper.class,
            IocHelper.class,
            ControllerHelper.class
        };
        for (Class<?> cls : classList) {
            ClassUtil.loadClass(cls.getName(),true);
        }
    }
}