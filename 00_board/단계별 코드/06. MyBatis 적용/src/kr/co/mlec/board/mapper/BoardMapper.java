package kr.co.mlec.board.mapper;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import common.db.MyAppSqlConfig;
import kr.co.mlec.board.vo.BoardVO;

/**
 * 게시물에 대한 데이터를 처리하는 DAO 클래스
 * @author Administrator
 */
public class BoardMapper {
	
	private static SqlSession sqlMapper = null;
	private static final String NAMESPACE = 
		"kr.co.mlec.board.mapper.BoardMapper";
	
	public BoardMapper() {
		sqlMapper = MyAppSqlConfig.getSqlSessionInstance();
	}

	public void insertBoard(BoardVO board) {
		sqlMapper.insert(NAMESPACE + ".insertBoard", board);
		sqlMapper.commit();
	}

	public boolean updateBoard(BoardVO board) {
		int cnt = sqlMapper.update(NAMESPACE + ".updateBoard", board);
		sqlMapper.commit();
		return cnt == 1 ? true : false;
	}

	public boolean deleteBoard(int no) {
		int cnt = sqlMapper.delete(NAMESPACE + ".deleteBoard", no);
		sqlMapper.commit();
		return cnt == 1 ? true : false;
	}

	public List<BoardVO> selectBoard() {
		return sqlMapper.selectList(NAMESPACE + ".selectBoard");
	}

	public BoardVO selectOneBoard(int findNo) {
		return sqlMapper.selectOne(NAMESPACE + ".selectBoardByNo", findNo);
	}
}









