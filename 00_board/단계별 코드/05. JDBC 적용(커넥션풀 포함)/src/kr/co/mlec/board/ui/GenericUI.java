package kr.co.mlec.board.ui;

import java.util.Scanner;

public abstract class GenericUI {
	protected Scanner sc = new Scanner(System.in);
	public abstract void service();
}
