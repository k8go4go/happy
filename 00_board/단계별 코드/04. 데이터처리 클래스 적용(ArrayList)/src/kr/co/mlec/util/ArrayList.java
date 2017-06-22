// 배열 관리 클래스
package kr.co.mlec.util;

import kr.co.mlec.board.vo.BoardVO;
import kr.co.mlec.exception.InvalidIndexException;

public class ArrayList {
	
	public static void main(String[] args) {
		ArrayList al = new ArrayList();
		al.add(new BoardVO());
		al.add(new BoardVO());
		al.add(new BoardVO());
		
		System.out.println(al.size());
		
		BoardVO board = (BoardVO)al.get(0);
		board = (BoardVO)al.get(1);
		board = (BoardVO)al.get(2);
		
		for (int i = 0; i < al.size(); i++) {
			BoardVO b = (BoardVO)al.get(i);
		}
		
		al.remove(0);
		al.remove(1);
	}
	
	final int INIT_SIZE = 3;
	// 입력된 정보를 저장하기 위한 배열 선언
	private Object[] list = new Object[INIT_SIZE];
	// 입력될 위치 기억, 실제 저장된 데이터의 크기
	private int pos = 0;
	
	public void add(Object element) {
		// 데이터가 꽉 찼다면 배열의 크기를 증가
		if (pos == list.length) {
			Object[] temp = new Object[pos * 2];
			System.arraycopy(list, 0, temp, 0, pos);
			list = temp;
		}
		list[pos++] = element;
	}
	
	public Object get(int index) 
			throws InvalidIndexException {
		if (index < 0 || index >= pos) {
			throw new InvalidIndexException(
					index + "번은 존재하지 않습니다.");
		}
		
		return list[index];
	}
	
	public void remove(int index)
			throws InvalidIndexException {
		if (index < 0 || index >= pos) {
			throw new InvalidIndexException(
					index + "번은 존재하지 않습니다.");
		}
		
		// 삭제할 글번호가 존재할 경우
		int moveCnt = pos - index - 1;
		if (moveCnt > 0) {
			System.arraycopy(
					list, index + 1, list, index, moveCnt);
		}
		list[--pos] = null;		
	}
	
	public int size() {
		return pos;
	}
}







