package cn.hxzy.util;

import java.io.IOException;
import java.util.Scanner;

public class StringUtil {
    /**
     * 驼峰转下划线
     *
     * @param camelCaseName 驼峰字符串
     * @return 下划线字符串
     */
    public static String underscoreName(String camelCaseName) {
        StringBuffer result = new StringBuffer();
        if (camelCaseName != null && camelCaseName.length() > 0) {
            result.append(camelCaseName.substring(0, 1).toLowerCase());
            //拿到第一字母，直接转小写
            for (int i = 1; i < camelCaseName.length(); i++) {
                char ch = camelCaseName.charAt(i);
                //取第i个位置的字符
                if (Character.isUpperCase(ch)) {//判断该字符是不是大写字母
                    result.append("_");//如果是大写，则拼接下划线
                    result.append(Character.toLowerCase(ch));
                    //将自己转为小写加入result
                } else {
                    result.append(ch);
                }
            }
        }
        return result.toString();
    }

    public static void main(String[] args) throws IOException {
        System.out.println("请输入一个自然数");
        Scanner sc = new Scanner(System.in);
        int a = sc.nextInt();
        for (int i = 0; ; i++) {
            if (a % 2 == 0) {
                //引用为奇数时的函数
                a = ou(a);
            } else {
                //引用为偶数时的函数
                a = ji(a);
            }
            if (a == 1) {
                System.out.println("经过" + i + "次计算后");
                break;
            }
        }
        System.out.println("得到" + a);
    }

    public static int ji(int a) {
        int b = a * 3 + 1;
        return b;
    }

    public static int ou(int a) {
        int b = a / 2;
        return b;
    }

    /**
     * 下划线转驼峰
     *
     * @param underscoreName 下划线字符串
     * @return 驼峰字符串
     */
    public static String camelCaseName(String underscoreName) {
        StringBuffer result = new StringBuffer();
        if (underscoreName != null && underscoreName.length() > 0) {
            boolean flag = false;
            for (int i = 0; i < underscoreName.length(); i++) {
                char ch = underscoreName.charAt(i);
                if ("_".charAt(0) == ch) {
                    flag = true;
                } else {
                    if (flag) {
                        result.append(Character.toUpperCase(ch));
                        flag = false;
                    } else {
                        result.append(ch);
                    }
                }
            }
        }
        return result.toString();
    }
}
