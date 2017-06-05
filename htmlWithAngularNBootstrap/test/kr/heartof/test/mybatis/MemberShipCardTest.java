package kr.heartof.test.mybatis;

import kr.heartof.util.MemberShipCardGenerator;

public class MemberShipCardTest {
	public static void main(String[] args) {
		System.out.println(MemberShipCardGenerator.generate(16, 1));
	}
}
