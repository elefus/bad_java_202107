package com.bad_java.homework.hyperskill.decrypt_encrypt.part_6.encryptdecrypt;

import com.bad_java.homework.hyperskill.decrypt_encrypt.part_6.encryptdecrypt.encoder.EncryptorDescriptor;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Map;
import java.util.Scanner;

/**
 * @author Kirill Mololkin Kirill-mol 10.09.2021
 */
public class AppRunner {

	private PrintWriter out;

	public AppRunner(PrintStream out) {
		this.out = new PrintWriter(out, true);
	}

	public void run(Map<String, String> argumentsMap) throws IllegalArgumentException,
			FileNotFoundException, IOException {
		String data = initDataFromInput(argumentsMap);

		int key = argumentsMap.containsKey("-key") ?
				Integer.parseInt(argumentsMap.get("-key")) : 0;


		EncryptorDescriptor encDec = EncryptorDescriptor.create(argumentsMap.get("-alg"), key);

		String result = encDecByArgument(argumentsMap, encDec, data);

		out.print(result);
		out.flush();
		out.close();
	}

	private String encDecByArgument(Map<String, String> argumentsMap,
	                                EncryptorDescriptor encDec,
	                                String data) throws IllegalArgumentException {
		if (!argumentsMap.containsKey("-mode")) {
			return encDec.encrypt(data);
		} else {
			String mode = argumentsMap.get("-mode");
			if ("enc".equals(mode)) {
				return encDec.encrypt(data);
			} else if ("dec".equals(mode)) {
				return encDec.decrypt(data);
			} else {
				throw new IllegalArgumentException("No such mode: " + mode);
			}
		}
	}

	private String initDataFromInput(Map<String, String> argumentsMap)
			throws IOException {
		if (argumentsMap.containsKey("-data")) {
			return argumentsMap.get("-data");
		} else if (argumentsMap.containsKey("-in")) {
			return readFile(argumentsMap.get("-in"));
		} else {
			return "";
		}
	}

	private String readFile(String filePath) throws FileNotFoundException {
		Scanner fileScanner = new Scanner(new File(filePath));
		StringBuilder fileContent = new StringBuilder();

		while (fileScanner.hasNextLine()) {
			fileContent.append(fileScanner.nextLine());
		}

		fileScanner.close();

		return fileContent.toString();
	}

	private void writeFile(String pathToFile, String data) throws IOException {
		File file = new File(pathToFile);
		file.createNewFile();

		FileWriter fileWriter = new FileWriter(file);

		fileWriter.write(data);
		fileWriter.flush();
		fileWriter.close();
	}
}
