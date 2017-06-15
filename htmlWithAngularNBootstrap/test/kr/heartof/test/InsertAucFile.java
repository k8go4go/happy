package kr.heartof.test;


import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.heartof.service.mapper.AuctionMapper;
import kr.heartof.util.BringSqlSession;
import kr.heartof.vo.auction.RegAucFileVO;
import kr.heartof.vo.auction.RegAucVO;

public class InsertAucFile {
	public static void main(String[] args) throws IOException {
		SqlSession session = BringSqlSession.getSqlSessionInstance();
		AuctionMapper mapper = session.getMapper(AuctionMapper.class);
		List<RegAucVO> list = mapper.allProgressing();
		String base = "C:/java94/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/work/Catalina/localhost/htmlWithAngularNBootstrap/image";
		String copiedBase = "C:/java94/workspace/.metadata/.plugins/org.eclipse.wst.server.core/tmp1/work/Catalina/localhost/htmlWithAngularNBootstrap/";
		
		SimpleDateFormat format = new SimpleDateFormat("yyyy/MM/dd");

		
		for(int i=0; i < list.size(); i++) {
			String destDir = format.format(list.get(i).getREG_DTIME());
			String prodDirectory = String.valueOf(list.get(i).getPROD_CATE_NUM());
			
			File[] sourceFiles = new File(base + File.separator + prodDirectory).listFiles();
			String destnation = copiedBase + destDir;
			
			RegAucFileVO fv1 = new RegAucFileVO();
			fv1.setAUC_REG_NUM(list.get(i).getAUC_REG_NUM());
			fv1.setFILE_NM(sourceFiles[0].getName());
			fv1.setREAL_NM(sourceFiles[0].getName());
			fv1.setFILE_SIZE(moveTo(sourceFiles[0], destnation + File.separator + sourceFiles[0].getName()));
			fv1.setFILE_PATH(destnation);
			
			RegAucFileVO fv2 = new RegAucFileVO();
			fv2.setAUC_REG_NUM(list.get(i).getAUC_REG_NUM());
			fv2.setFILE_NM(sourceFiles[1].getName());
			fv2.setREAL_NM(sourceFiles[1].getName());
			fv2.setFILE_SIZE(moveTo(sourceFiles[1], destnation + File.separator + sourceFiles[1].getName()));
			fv2.setFILE_PATH(destnation);
			
			destDir = format.format(list.get(++i).getREG_DTIME());
			prodDirectory = String.valueOf(list.get(i).getPROD_CATE_NUM());
			
			RegAucFileVO fv3 = new RegAucFileVO();
			fv3.setAUC_REG_NUM(list.get(i).getAUC_REG_NUM());
			fv3.setFILE_NM(sourceFiles[2].getName());
			fv3.setREAL_NM(sourceFiles[2].getName());
			fv3.setFILE_SIZE(moveTo(sourceFiles[2], destnation + File.separator + sourceFiles[2].getName()));
			fv3.setFILE_PATH(destnation);
			
			RegAucFileVO fv4 = new RegAucFileVO();
			fv4.setAUC_REG_NUM(list.get(i).getAUC_REG_NUM());
			fv4.setFILE_NM(sourceFiles[3].getName());
			fv4.setREAL_NM(sourceFiles[3].getName());
			fv4.setFILE_SIZE(moveTo(sourceFiles[3], destnation + File.separator + sourceFiles[3].getName()));
			fv4.setFILE_PATH(destnation);
			
			destDir = format.format(list.get(++i).getREG_DTIME());
			prodDirectory = String.valueOf(list.get(i).getPROD_CATE_NUM());
			
			RegAucFileVO fv5 = new RegAucFileVO();
			fv5.setAUC_REG_NUM(list.get(i).getAUC_REG_NUM());
			fv5.setFILE_NM(sourceFiles[4].getName());
			fv5.setREAL_NM(sourceFiles[4].getName());
			fv5.setFILE_SIZE(moveTo(sourceFiles[4], destnation + File.separator + sourceFiles[4].getName()));
			fv5.setFILE_PATH(destnation);
			
			RegAucFileVO fv6 = new RegAucFileVO();
			fv6.setAUC_REG_NUM(list.get(i).getAUC_REG_NUM());
			fv6.setFILE_NM(sourceFiles[5].getName());
			fv6.setREAL_NM(sourceFiles[5].getName());
			fv6.setFILE_SIZE(moveTo(sourceFiles[5], destnation + File.separator + sourceFiles[5].getName()));
			fv6.setFILE_PATH(destnation);
			
			mapper.regAuctionFile(fv1);
			mapper.regAuctionFile(fv2);
			mapper.regAuctionFile(fv3);
			mapper.regAuctionFile(fv4);
			mapper.regAuctionFile(fv5);
			mapper.regAuctionFile(fv6);
		}
		session.commit();
		session.close();
	}
	
	public static int moveTo (File source, String dest) throws IOException {
		BufferedInputStream bi = new BufferedInputStream(new FileInputStream(source));
		BufferedOutputStream bo = new BufferedOutputStream(new FileOutputStream(dest));
		ByteArrayOutputStream bao = new ByteArrayOutputStream();
		int ch = -1;
		while((ch = bi.read()) != -1) {
			bo.write(ch);
			bao.write(ch);
		}
		
		bo.flush();
		bo.close();
		bi.close();
		
		return bao.toByteArray().length;
	}
}
