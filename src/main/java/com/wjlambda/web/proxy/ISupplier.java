package com.wjlambda.web.proxy;

@FunctionalInterface
public interface ISupplier<T> {
    T get();
}

