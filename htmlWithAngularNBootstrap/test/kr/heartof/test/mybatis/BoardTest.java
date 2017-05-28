package kr.heartof.test.mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.heartof.constant.Code;
import kr.heartof.service.mapper.QnaMapper;
import kr.heartof.vo.foruser.BoardVO;
import kr.heartof.vo.foruser.PageVO;

public class BoardTest {
	public static void main(String[] args) throws IOException {
		String resource = "common/config/sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
		SqlSession session = sqlSessionFactory.openSession();
		
		QnaMapper mapper = session.getMapper(QnaMapper.class);
		delete(mapper);
		session.commit();
		session.close();
	}
	
	public static void list(QnaMapper mapper) {
		PageVO vo = new PageVO();
		vo.setSTART(1);
		vo.setEND(10);
		List<BoardVO> list = mapper.list(vo);
		
		for(BoardVO v : list) {
			System.out.println(v.getMEMB_ID() + " " + v.getTOT());
		}
	}
	
	public static void searChList(QnaMapper mapper) {
		PageVO vo = new PageVO();
		vo.setSTART(1);
		vo.setEND(10);
		vo.setCD(Code.SEARCH_TITLE_CD.getKey());
		vo.setSearchWord("김");
		List<BoardVO> list = mapper.searchList(vo);
		System.out.println(mapper.searchListTot(vo));
		for(BoardVO v : list) {
			System.out.println(v.getMEMB_ID() + " " + v.getTOT());
		}
	}
	
	public static void detail(QnaMapper mapper) {
		BoardVO list = mapper.detail(300);
		System.out.println(list.toString());
	}
	
	public static void insert(QnaMapper mapper) {
		BoardVO vo = new BoardVO();
		vo.setTITLE("잘좀해보자");
		vo.setCONT("좀 닥치고 공부하자");
		vo.setWRITER_NM("정의홍");
		vo.setMEMB_NUM(2);
		vo.setHIGH_BOARD_NUM(1117);
		
		int result = mapper.insert(vo);
		System.out.println(result);
	}
	
	public static void update(QnaMapper mapper) {
		BoardVO vo = new BoardVO();
		vo.setTITLE("잘좀해보자 개");
		vo.setCONT("좀 닥치고 공부하자 개");
		vo.setBOARD_NUM(1118);
		
		int result = mapper.update(vo);
		System.out.println(result);
	}
	
	public static void updateHitCount(QnaMapper mapper) {
		int result = mapper.updateHitCount(1118);
		System.out.println(result);
	}
	
	public static void updateQuesCD(QnaMapper mapper) {
		BoardVO vo = new BoardVO();
		vo.setTITLE("잘좀해보자 개");
		vo.setCONT("좀 닥치고 공부하자 개");
		vo.setBOARD_NUM(1118);
		vo.setQUES_CD(Code.QNA_ING_CD.getKey());
		
		int result = mapper.updateQuesCD(vo);
		System.out.println(result);
	}
	
	public static void delete(QnaMapper mapper) {
		int result = mapper.delete(1118);
		System.out.println(result);
	}
}
