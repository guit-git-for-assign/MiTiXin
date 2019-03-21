package com.wjy.c3;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Test
{
    public static void main(String []args)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入一个字符串");
        String str = scanner.nextLine();

        if (verify(str)) System.out.println(num(str).toString());

    }

    public static Map<Character,Integer> num(String str)
    {
        char[] charArray = str.toCharArray();
        Map<Character,Integer> map = new HashMap<>();
        for (int i=0; i < charArray.length; i++)
        {
            if (!map.containsKey(charArray[i]))
            {
                map.put(charArray[i],1);
            }
            else
            {
                int count = map.get(charArray[i]) + 1;
                map.put(charArray[i],count);
            }
        }
        return map;
    }

    public static boolean  verify(String str)
    {
        //定义正则，字符只能输入小写字母a到z
        String regex = "[a-z]+";
        boolean stamp = false;
        if (str != null && str.length()>=0 && str.matches(regex))
        {
            stamp = true;
        }
        else
        {
            System.out.println("含有非法字符或字符长度为0");
        }
        return stamp;
    }
}
