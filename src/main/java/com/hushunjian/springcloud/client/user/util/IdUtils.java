package com.hushunjian.springcloud.client.user.util;

import java.util.UUID;

public class IdUtils {

    public static String generateId(){
        return UUID.randomUUID().toString().replace("-", "");
    }
}
