package com.syne.util;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/*
 * @author subhajit
 */
public class Util {

	public static List<Integer> convertStringToListOfIntegers(String intputString) {
		return Arrays.stream(intputString.split(",")).map(s -> Integer.valueOf(s)).collect(Collectors.toList());

	}
}
