package com.bad_java.homework.hyperskill.tic_tac_toe_with_ai.part_3;

import java.io.InputStream;
import java.io.PrintStream;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 * @author Kirill Mololkin Kirill-mol 18.08.2021
 */
public class Terminal {

	private final Scanner in;
	private final PrintWriter out;

	public Terminal(InputStream in, PrintStream out) {
		this.in = new Scanner(in);
		this.out = new PrintWriter(out, true);
	}

	public void println(Object obj) {
		out.println(obj);
	}

	public void println() {
		out.println();
	}

	public void print(Object obj) {
		out.print(obj);
		out.flush();
	}

	public String nextLine() {
		return in.nextLine();
	}

	public void printf(String s, Object... objs) {
		out.printf(s, objs);
	}
}
