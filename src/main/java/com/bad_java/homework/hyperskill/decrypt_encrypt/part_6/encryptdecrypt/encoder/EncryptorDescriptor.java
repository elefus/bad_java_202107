package com.bad_java.homework.hyperskill.decrypt_encrypt.part_6.encryptdecrypt.encoder;

public interface EncryptorDescriptor {

	String encrypt(String strToEncrypt);

	String decrypt(String strToDecrypt);

	static EncryptorDescriptor create(String algoName, int shift) {
		if (algoName == null) {
			return new ShiftEncryptorDescriptor(shift);
		}

		switch (algoName) {
			case "unicode":
				return new UnicodeEncryptorDescriptor(shift);
			default:
				return new ShiftEncryptorDescriptor(shift);
		}
	}
}
