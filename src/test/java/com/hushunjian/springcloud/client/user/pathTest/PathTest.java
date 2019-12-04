package com.hushunjian.springcloud.client.user.pathTest;

public class PathTest {

    public static void main(String[] args) {
        String path = "0001.0001.0020";
        String outLineNum = path.replaceAll("^(0+)", "");
        System.out.println(outLineNum);
        String[] split = path.split("\\.");
        StringBuilder sb = new StringBuilder();
        for (String s : split) {
            sb.append(Long.valueOf(s)).append(".");
        }
        System.out.println(sb.substring(0, sb.length() - 1));
    }
}
