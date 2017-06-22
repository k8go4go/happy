package day13.quiz;

public class Quiz06VO implements Comparable<Quiz06VO>{
	private String name;
	private int score1;
	private int score2;
	private int score3;
	
	public Quiz06VO() {
	}
	
	public Quiz06VO(String name, int score1, int score2, int score3) {
		this.name = name;
		this.score1 = score1;
		this.score2 = score2;
		this.score3 = score3;
	}

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getScore1() {
		return score1;
	}
	public void setScore1(int score1) {
		this.score1 = score1;
	}
	public int getScore2() {
		return score2;
	}
	public void setScore2(int score2) {
		this.score2 = score2;
	}
	public int getScore3() {
		return score3;
	}
	public void setScore3(int score3) {
		this.score3 = score3;
	}
	public int getSum() {
		return score1 + score2 + score3;
	}
	@Override
	public int compareTo(Quiz06VO o) {
		if (this.getSum() == o.getSum()) return 0;
		return this.getSum() > o.getSum() ? -1 : 1;
	}
}











