package com.hushunjian.springcloud.client.user.pathTest;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class OutLineTest {

    private static final List<String> Options = Lists.newArrayList("0","1","2","3","4","5","6","7","8","9","A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z");

    private static final BigDecimal Options_Size = BigDecimal.valueOf(Options.size());

    public static void main(String[] args) {
        System.out.println("候选项个数:");
        System.out.println(Options.size());
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
    }

    public static Double outLineStrToDouble(String outLine) {
        char[] chars = outLine.toCharArray();
        double result = 0d;
        for (int i = 0; i < chars.length; i++) {
            result += (Options.indexOf(chars[chars.length - i - 1] + "")) * Math.pow(Options.size(), i);
        }
        return result;
    }

    public static String outLineDoubleToStr(Integer step, Double current) {
        BigDecimal next = BigDecimal.valueOf(current + step);
        List<Integer> positions = Lists.newLinkedList();
        while (next.compareTo(BigDecimal.ZERO) != 0) {
            BigDecimal[] nextResult = next.divideAndRemainder(Options_Size);
            next = nextResult[0];
            positions.add(nextResult[1].intValue());
        }
        StringBuilder str = new StringBuilder();
        for (int i = positions.size() - 1; i >= 0; i--) {
            str = str.append(Options.get(positions.get(i)));
        }
        return str.toString();
    }
}
