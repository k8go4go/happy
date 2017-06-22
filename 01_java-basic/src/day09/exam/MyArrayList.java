package day09.exam;

public class MyArrayList {
	String[] elements = new String[4];
	int pos = 0;
	public void add(String data) {
		if (pos == elements.length) {
			String[] temp = new String[pos * 2];
			System.arraycopy(elements, 0, temp, 0, pos);
			elements = temp;
		}
		// 배열명[방번호] = 값;
		elements[pos++] = data;
	}
	public String get(int index){
		return elements[index];
	}
	public int size() {
		return pos;
	}
	public void remove(int index) {
		System.arraycopy(elements, index + 1, elements, index, pos - (index + 1));
		elements[--pos] = null;
	}
	void clear() {
		for (int i = 0; i < pos; i++) {
			elements[i] = null;
		}
		pos = 0;
	}
	
	public String toString() {
		String result = "MyArrayList[";
		result += elements[0];
		for (int i = 1; i < pos; i++) {
			result += ", " + elements[i];
		}
		result += "]";
		
		return result;
	}
}













