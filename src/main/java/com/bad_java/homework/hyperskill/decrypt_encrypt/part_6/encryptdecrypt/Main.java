package com.bad_java.homework.hyperskill.decrypt_encrypt.part_6.encryptdecrypt;

import java.io.IOException;
import java.io.PrintStream;
import java.util.Map;

public class Main {

	public static void main(String[] args) {
		try {
			Map<String, String> argsMap = ArgumentParser.parseArguments(args);

			PrintStream out;

			if (argsMap.containsKey("-out")) {
				out = new PrintStream(argsMap.get("-out"));
			} else {
				out = System.out;
			}

			AppRunner appRunner = new AppRunner(out);

			appRunner.run(argsMap);
		} catch (IOException ex) {
			System.out.println("Error with out or input file");
		} catch (IllegalArgumentException ex) {
			System.out.println(ex.getMessage());
		}
	}
}
