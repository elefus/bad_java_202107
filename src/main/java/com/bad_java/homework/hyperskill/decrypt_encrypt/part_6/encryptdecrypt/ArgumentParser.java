package com.bad_java.homework.hyperskill.decrypt_encrypt.part_6.encryptdecrypt;

import java.util.HashMap;
import java.util.Map;

/**
 * @author Kirill Mololkin Kirill-mol 09.09.2021
 */
public class ArgumentParser {

	public static Map<String, String> parseArguments(String[] args)
			throws IllegalArgumentException {
		Map<String, String> argsMap = new HashMap<>();

		for (int i = 0; i < args.length - 1; i++) {
			if (args[i].startsWith("-")) {
				if (args[i + 1].startsWith("-")) {
					throw new IllegalArgumentException("After key mast be argument, " +
							"not again key");
				}
				argsMap.put(args[i], args[i + 1]);
			}
		}

		return argsMap;
	}
}
