package xyz.frt.string.util;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class StringUtils {

	public static final String CHARACTERS = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
	
	public static final String[] KEYWORDS = {"abstract", "true", "false", "null"};

	/**
	 * 打印出字符串中每个字母的出现次数 (大小写敏感)
	 * 
	 * @param res 要统计的字符串
	 * @return map 结果集
	 */
	public static Map<Character, Integer> printStringNum(String res) {

		if (res == null || res.length() == 0) {
			System.err.println("字符串为空！");
			return null;
		}
		res = res.replace(" ", "");// 去掉空格
		char[] resArr = res.toCharArray();
		Map<Character, Integer> map = new HashMap<>();

		for (char c : resArr) {
			map.put(c, map.containsKey(c) ? map.get(c) + 1 : 1);
		}

		return map;
	}

	/**
	 * Same as above
	 * 
	 * @param charaters char array
	 * @return result
	 */
	public static Map<Character, Integer> printStringNum(char[] charaters) {
		if (charaters == null || charaters.length == 0) {
			System.err.println("数据为空！");
		}
		String res = new String(charaters);
		return printStringNum(res);
	}

	
	
	public static List<Character> printRandomStr(int num) {

		char[] charArr = CHARACTERS.toCharArray();
		Random random = new Random();
		List<Character> list = new ArrayList<>();
		for (int i = 0; i < num; i++) {
			int idx = random.nextInt(27);
			list.add(charArr[idx]);
		}
		return list;
	}
	
	public static boolean isAllowedStr(String str) {
		for (String s: KEYWORDS) {
			if (s.equals(str)) {
				return false;
			}
		}
		Pattern pattern = Pattern.compile("^[A-Za-z_$]{1}[0-9A-Za-z_$\\\\d]+$");
		Matcher matcher = pattern.matcher(str);
		return matcher.matches();
	}
	
	
	public static boolean isTelephone(String phone) {
		
		if (phone == null || phone.length() == 0) {
			return false;
		}
		String reg = "[0-9]{11}";
		Pattern pattern = Pattern.compile(reg);
		
		return pattern.matcher(phone).matches();
	}

}
