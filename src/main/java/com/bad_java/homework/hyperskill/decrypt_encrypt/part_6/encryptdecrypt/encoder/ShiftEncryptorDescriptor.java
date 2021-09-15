package com.bad_java.homework.hyperskill.decrypt_encrypt.part_6.encryptdecrypt.encoder;

/**
 * @author Kirill Mololkin Kirill-mol 09.09.2021
 */
public class ShiftEncryptorDescriptor implements EncryptorDescriptor {

	private int shift;

	public ShiftEncryptorDescriptor(int shift) {
		this.shift = shift;
	}

	@Override
	public String encrypt(String strToEncrypt) {
		StringBuilder stringBuilder = new StringBuilder();

		for (char ch : strToEncrypt.toCharArray()) {
			if (ch >= 'a' && ch <= 'z') {
				stringBuilder.append(encryptLowerChar(ch));
			} else if (ch >= 'A' && ch <= 'Z') {
				stringBuilder.append(encryptUpperChar(ch));
			}
			else {
				stringBuilder.append(ch);
			}
		}

		return stringBuilder.toString();
	}

	@Override
	public String decrypt(String strToDecrypt) {
		StringBuilder stringBuilder = new StringBuilder();

		for (char ch : strToDecrypt.toCharArray()) {
			if (ch >= 'a' && ch <= 'z') {
				stringBuilder.append(decryptLowerChar(ch));
			} else if (ch >= 'A' && ch <= 'Z') {
				stringBuilder.append(decryptUpperChar(ch));
			}
			else {
				stringBuilder.append(ch);
			}
		}
		return stringBuilder.toString();
	}

	public char encryptLowerChar(char ch) {
		if (ch + shift > 'z') {
			return (char) ('a' + (ch + shift) % 'z' - 1);
		} else {
			return (char) (ch + shift);
		}
	}

	public char encryptUpperChar(char ch) {
		if (ch + shift > 'Z') {
			return (char) ('A' + (ch + shift) % 'Z' - 1);
		} else {
			return (char) (ch + shift);
		}
	}

	public char decryptLowerChar(char ch) {
		if (ch - shift < 'a') {
			return (char) ('z' - (shift % ('z' - 'a') - (ch - 'a') - 1));
		} else {
			return (char) (ch - shift);
		}
	}

	public char decryptUpperChar(char ch) {
		if (ch - shift < 'A') {
			return (char) ('Z' - (shift % ('Z' - 'A') - (ch - 'A') - 1));
		} else {
			return (char) (ch - shift);
		}
	}
}
