package com.nexuz.bug;

public class Utils {
    public static String normalize(String num) {
        if (num == null) return "";
        num = num.trim();
        if (num.startsWith("0")) return "62" + num.substring(1);
        if (num.startsWith("+")) return num.substring(1);
        return num;
    }
}
