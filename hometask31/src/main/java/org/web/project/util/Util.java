package org.web.project.util;

public class Util {
    public static boolean notNull(Object obj) {
        return obj != null;
    }
    public static boolean notNull(String str) {
        return (str != null) && (str.isBlank());
    }
}