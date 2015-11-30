package com.pfxiong.framework.core.proxy;

/**
 * Created by pfxiong on 2015/11/30 22:35.
 */
public interface Proxy {
    Object doProxy(ProxyChain proxyChain) throws Throwable;
}
