package kr.heartof.auction.test.mybatis;

import java.io.IOException;
import java.util.List;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import kr.heartof.auction.service.mapper.QnaMapper;
import kr.heartof.auction.vo.foruser.BoardVO;
import kr.heartof.auction.vo.foruser.PageVO;

public class BoardTest {
	public static void main(String[] args) throws IOException {
		String resource = "common/config/sqlMapConfig.xml";
		SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(Resources.getResourceAsStream(resource));
		SqlSession session = sqlSessionFactory.openSession();
		
		QnaMapper mapper = session.getMapper(QnaMapper.class);
		list(mapper);
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
}
