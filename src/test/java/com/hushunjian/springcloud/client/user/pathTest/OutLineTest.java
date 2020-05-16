package com.hushunjian.springcloud.client.user.pathTest;

import com.google.common.collect.Lists;

import java.math.BigDecimal;
import java.util.List;

public class OutLineTest {

    private static final List<Character> OPTIONS = Lists.newArrayList('0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z');

    private static final BigDecimal Options_Size = BigDecimal.valueOf(OPTIONS.size());

    private static final int OPTIONS_SIZE = OPTIONS.size();

    public static void main(String[] args) {
        System.out.println("候选项个数:");
        System.out.println(OPTIONS.size());
        String outLine = "B";
        char[] chars = outLine.toCharArray();
        for (char option : chars) {
            System.out.println(option + "");
        }
        System.out.println(outLineStrToDouble(outLine));
        System.out.println("==========1==========");
        System.out.println(Math.pow(2, 2));
        System.out.println("==========2==========");
        System.out.println(outLineDoubleToStr(1, 9d));
        System.out.println("==========3==========");
        String path = "00100Z002003007";
        int step = 70;
        System.out.println(next(path, step));
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            next(path, step);
        }
        System.out.println("t1 -> " + (System.currentTimeMillis() - time1));
        System.out.println("==========4==========");
        System.out.println(next1(path, step));
        long time2 = System.currentTimeMillis();
        for (int i = 0; i<1000000; i++) {
            next1(path, step);
        }
        System.out.println("t2 -> " + (System.currentTimeMillis() - time2));
        System.out.println("==========5==========");
        System.out.println(next1(path, step));
        long time3 = System.currentTimeMillis();
        for (int i = 0; i<1000000; i++) {
            next2(path, step);
        }
        System.out.println("t3 -> " + (System.currentTimeMillis() - time3));

    }

    private static Double outLineStrToDouble(String outLine) {
        char[] chars = outLine.toCharArray();
        double result = 0d;
        for (int i = 0; i < chars.length; i++) {
            result += (OPTIONS.indexOf(chars[chars.length - i - 1])) * Math.pow(OPTIONS.size(), i);
        }
        return result;
    }

    private static String outLineDoubleToStr(Integer step, Double current) {
        BigDecimal next = BigDecimal.valueOf(current + step);
        List<Integer> positions = Lists.newLinkedList();
        while (next.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal[] nextResult = next.divideAndRemainder(Options_Size);
            next = nextResult[0];
            positions.add(nextResult[1].intValue());
        }
        StringBuilder str = new StringBuilder();
        for (int i = positions.size() - 1; i >= 0; i--) {
            str.append(OPTIONS.get(positions.get(i)));
        }
        return str.toString();
    }

    private static String next(String path, int step) {
        char[] chars = path.toCharArray();
        char[] result = new char[chars.length];
        for (int i = chars.length - 1; i >= 0; i--) {
            if (step > 0) {
                int index = OPTIONS.indexOf(chars[i]);
                int nextCharIndex = (step + index) % OPTIONS_SIZE;
                result[i] = OPTIONS.get(nextCharIndex);
                step = (step + index) / OPTIONS_SIZE;
            } else {
                result[i] = chars[i];
            }
        }
        if (step != 0) {
            System.out.println("有问题");
        }
        return String.valueOf(result);
    }

    private static String next1(String path, int step) {
        char[] result = new char[path.length()];
        for (int i = path.length() - 1; i >= 0; i--) {
            if (step > 0) {
                int index = OPTIONS.indexOf(path.charAt(i));
                int sum = index + step;
                int nextCharIndex = sum % OPTIONS_SIZE;
                result[i] = OPTIONS.get(nextCharIndex);
                step = sum / OPTIONS_SIZE;
            } else {
                result[i] = path.charAt(i);
            }
        }
        if (step != 0) {
            System.out.println("有问题");
        }
        return String.valueOf(result);
    }

    private static String next2(String path, int step) {
        char[] chars = path.toCharArray();
        for (int i = chars.length - 1; i >= 0; i--) {
            if (step > 0) {
                int index = OPTIONS.indexOf(path.charAt(i));
                int sum = index + step;
                int nextCharIndex = sum % OPTIONS_SIZE;
                chars[i] = OPTIONS.get(nextCharIndex);
                step = sum / OPTIONS_SIZE;
            } else {
                break;
            }
        }
        if (step != 0) {
            System.out.println("有问题");
        }
        return String.valueOf(chars);
    }


}
