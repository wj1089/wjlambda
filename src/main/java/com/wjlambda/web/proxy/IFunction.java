package com.wjlambda.web.proxy;

import java.util.HashMap;

@FunctionalInterface
public interface IFunction<T,R> {
    public R apply(T t);

}

