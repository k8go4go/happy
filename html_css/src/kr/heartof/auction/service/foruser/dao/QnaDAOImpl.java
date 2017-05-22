package kr.heartof.auction.service.foruser.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Random;

import kr.heartof.auction.vo.foruser.AttacFileVO;
import kr.heartof.auction.vo.foruser.BoardVO;

public class QnaDAOImpl implements QnaDAO {

	@Override
	public List<BoardVO> getBoardList(int currentPage, int viewCount) {
		List<BoardVO> list = new ArrayList<BoardVO>();
		
		for(int i=0; i < 116 ; i++) {
			BoardVO vo = new BoardVO();
			vo.setBOARD_NUM(i);
			vo.setINDENT(new Random().nextInt(2));
			vo.setCONT("forEach는 다음과 같은 속성을 가진다.<br>"+
					   "items : forEach가 순회할 Collection 개체를 지정한다. <br>"+
					   "begin : 반복문의 시작값을 설정한다.<br>" + 
					   "end : 반복문의 종료값을 설정한다.<br>" +
					   "step : 반복문의 증가값을 설정한다.<br>" +
					   "var : 반복문의 순회시 해당하는 값을 담을 변수를 설정한다.<br>" +
					   "varStatus : 변수의 상태를 담을 변수를 설정한다.<br>"+
					   "<br>"+
					   "기본적으로 forEach는 begin 과 end 속성만 설정해주면 동작하며 그 외 속성은 추가적인 옵션이다. 물론 이 두 부분만 설정됬을때는 세부적인 제어가 불가능 하고 step은 기본값으로 1이 작용한다");
			AttacFileVO fileVO = new AttacFileVO();
			fileVO.setREAL_NM("1.png");
			fileVO.setREAL_PATH("resource/img");
			fileVO.setFILE_NM("");
			fileVO.setFILE_PATH("");
			fileVO.setFILE_SIZE(92089);
			fileVO.setBOARD_NUM(i);
			vo.setAttacFileVO(fileVO);
			vo.setREVIEW_CNT(100);
			vo.setTITLE("[ JSTL ] 반복과 관련된 태그 (forEach, forToken )");
			vo.setMEMB_NUM(1);
			vo.setWRITE_DATE(new Date());
			list.add(vo);
		}
		
		List<BoardVO> sendList = null;
		int totalPage = getBoardTotal() / viewCount + (getBoardTotal() % viewCount > 0 ? 1 : 0);
		if(currentPage != totalPage) {
			sendList = arraycopy(list, (currentPage - 1) * viewCount, viewCount);
		} else { 
			sendList = arraycopy(list, (currentPage - 1) * viewCount, getBoardTotal() % viewCount);
		}
		
		return sendList;
	}
	
	private List<BoardVO> arraycopy(List<BoardVO> source, int startIndex, int count) {
		List<BoardVO> sendList = new ArrayList<BoardVO>();
		for(int i = startIndex; i < source.size() ; i++) {
			if(count-- > 0) {
				sendList.add(source.get(i));
			} else {
				break;
			}
		}
		return sendList;
	}
	
	
	@Override
	public boolean insertBoard(BoardVO vo) {
		
		return false;
	}

	@Override
	public boolean deleteBoard(int no) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean updateBoard(BoardVO vo) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public int getBoardTotal() {
		return 116;
	}

}
