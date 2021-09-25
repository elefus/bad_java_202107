package com.bad_java.homework.hyperskill.decrypt_encrypt.part_6.encryptdecrypt.encoder;

/**
 * @author Kirill Mololkin Kirill-mol 09.09.2021
 */
public class UnicodeEncryptorDescriptor implements EncryptorDescriptor {

	private int shift;

	public UnicodeEncryptorDescriptor(int shift) {
		this.shift = shift;
	}

	@Override
	public String encrypt(String strToEncrypt) {
		StringBuilder stringBuilder = new StringBuilder();

		for (char ch : strToEncrypt.toCharArray()) {
			stringBuilder.append(encryptChar(ch));
		}

		return stringBuilder.toString();
	}

	@Override
	public String decrypt(String strToDecrypt) {
		StringBuilder stringBuilder = new StringBuilder();

		for (char ch : strToDecrypt.toCharArray()) {
			stringBuilder.append(decryptChar(ch));
		}

		return stringBuilder.toString();
	}

	public char decryptChar(char ch) {
		return (char) (ch - shift);
	}

	public char encryptChar(char ch) {
		return (char) (ch + shift);
	}
}
