package day13.quiz;

public class Data implements Comparable<Data> {
	private int num;

	public Data(int num) {
		this.num = num;
	}

	public int getNum() {
		return num;
	}
	// 추가됨..
	public String toString() {
		return String.valueOf(num);
	}

	/*
	 * 리턴되는 결과에 따라서 위치가 바뀐다.
	 * 0을 리턴하면 자리바꿈 없다.
	 * 음수값이면 비교대상보다 앞으로 이동
	 * 양수값이면 비교대상보다 뒤로 이동
	 */
	@Override
	public int compareTo(Data o) {
		if (num == o.getNum()) return 0;
		return num > o.getNum() ? -1 : 1;
	}
}










