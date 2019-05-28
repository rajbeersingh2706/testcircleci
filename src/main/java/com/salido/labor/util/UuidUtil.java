package com.salido.labor.util;

import java.util.UUID;

public class UuidUtil {
    private UuidUtil() {
    }

    public static String getUUID() {
        return UUID.randomUUID().toString();
    }
}
