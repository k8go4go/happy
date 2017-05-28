package kr.heartof.service.mapper;

import java.util.List;

import kr.heartof.vo.product.ProdCateVO;

public interface ProductMapper{
	/**
	 * 카테고리를 가져온다. 카테고리에 해당하는 목록을 가져온다. 
	 * 만약 널값으로 조회하면 전체 카테고리를 가져오고 거기서 
	 * 선택된 부모 HIGH_PROD_CATE_NUM으로 하위 조회를 하면 하위 내용을
	 * 찾아 볼수 있다.
	 * 상품카테고리로 URL를 만들어 조회 하위에 등록된 또는 이미 낙찰된 경매 상품을
	 * 조회 하도록 한다.
	 * @param HIGH_PROD_CATE_NUM
	 * @return 조회된 상품 카테고리
	 */
	public List<ProdCateVO> getProdCates(String HIGH_PROD_CATE_NUM);
	/**
	 * 새로운 카테고리를 삽입한다.
	 * @param vo 새로운 카테고리 삽입
	 * @return
	 */
	public int insertProdCate(ProdCateVO vo);
	
	/**
	 * 카테고리 이름과 카테고리 내용을 수정한다.
	 * @param vo
	 * @return
	 */
	public int updateProdCate(ProdCateVO vo);
	
	/**
	 * 카테고리의 사용 유무를 변경 시킨다. 
	 * @see kr.heartof.auction.constant.Code.PROD_CATE_Y_CD 
	 * @see kr.heartof.auction.constant.Code.PROD_CATE_N_CD
	 * @param vo
	 * @return
	 */
	public int changeCDProdCate(ProdCateVO vo);
}
