package com.hushunjian.springcloud.client.user.util;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;

import java.util.List;
import java.util.Map;

public class CalUtils {

    public static void main(String[] args) {
        String str = "1+2-3*4/5+6*2+1-2*2";
        cal(str);
    }

    public static void cal(String str) {
        String strReplace = str.replaceAll("[+-/*]", "'$0'");
        System.out.println(strReplace);
/*         String[] split = str.split("[+-/*]");
         for (String s : split) {
             System.out.println(s);
         }*/
        String[] split = strReplace.split("'");
        Map<Integer, Double> indexValueMap = Maps.newHashMap();
        List<Double> nums = Lists.newArrayList();
        List<String> operators = Lists.newArrayList();
        for (int i = 1; i <= split.length - 1; ) {
            if (StringUtils.equalsAny(split[i], "*", "/")) {
                Double num1 = indexValueMap.get(i - 1);
                if (num1 == null) {
                    num1 = Double.parseDouble(split[i - 1]);
                }
                Double value = cal(num1, Double.parseDouble(split[i + 1]), split[i]);
                indexValueMap.put(i + 1, value);
                nums.set(nums.size() - 1, value);
            } else {
                operators.add(split[i]);
                nums.add(Double.parseDouble(split[i + 1]));
            }
            i+=2;
        }
        Double result = Double.parseDouble(split[0]);
        for (int i = 0; i < operators.size(); i++) {
            result = cal(result, nums.get(i), operators.get(i));
        }
        System.out.println(result);
    }

    private static Double cal(Double num1, Double num2, String operator) {
        switch (operator) {
            case "+":
                return num1 + num2;
            case "-":
                return num1 - num2;
            case "*":
                return num1 * num2;
            default:
                return num1 / num2;
        }
    }
}
