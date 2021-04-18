package com.hushunjian.springcloud.client.user.system;

public class HttpThreadLocal {

    private final static ThreadLocal<HttpUser> HTTP_USER = new ThreadLocal<>();

    public static void set(HttpUser user) {
        HTTP_USER.set(user);
    }

    public static String getUserId() {
        return HTTP_USER.get().getUserId();
    }

    public static void remove() {
        HTTP_USER.remove();
    }
}
