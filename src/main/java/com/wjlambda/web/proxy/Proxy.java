package com.wjlambda.web.proxy;

import org.springframework.cglib.core.internal.Function;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import java.util.function.BiFunction;
import java.util.function.BiPredicate;
import java.util.function.Consumer;

@Component("pxy") @Lazy
public class Proxy {
    public String string(Object o){
        Function<Object, String> f = String::valueOf;
        return f.apply(o);
    }
    public Integer integer(String s){
        Function<String,Integer> f = Integer::parseInt;
        return f.apply(s);
    }
    public Boolean equals(String t, String u){
        BiPredicate<String,String> f= String::equals;
        return f.test(t,u);
    }
    public void print(String t){
        Consumer<String> c = System.out::println;
        c.accept(t);
    }
}
