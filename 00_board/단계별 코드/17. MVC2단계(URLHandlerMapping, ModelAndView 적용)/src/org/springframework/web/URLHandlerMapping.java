package org.springframework.web;

import java.util.HashMap;
import java.util.Map;

import kr.co.mlec.board.controller.CommentDeleteController;
import kr.co.mlec.board.controller.CommentRegistController;
import kr.co.mlec.board.controller.CommentUpdateController;
import kr.co.mlec.board.controller.DeleteController;
import kr.co.mlec.board.controller.DetailController;
import kr.co.mlec.board.controller.ListController;
import kr.co.mlec.board.controller.UpdateController;
import kr.co.mlec.board.controller.UpdateFormController;
import kr.co.mlec.board.controller.WriteController;
import kr.co.mlec.board.controller.WriteFormController;
import kr.co.mlec.login.controller.LoginController;
import kr.co.mlec.login.controller.LoginFormController;
import kr.co.mlec.login.controller.LogoutController;
import kr.co.mlec.main.controller.MainController;

public class URLHandlerMapping {
	// url 과 연결된 Controller 클래스 정보 관리
	private Map<String, Controller> mappings;
	
	public URLHandlerMapping() {
		mappings = new HashMap<>();
		mappings.put("/board/list.do", new ListController());
		mappings.put("/board/detail.do", new DetailController());
		mappings.put("/board/update.do", new UpdateController());
		mappings.put("/board/updateForm.do", new UpdateFormController());
		mappings.put("/board/delete.do", new DeleteController());
		mappings.put("/board/writeForm.do", new WriteFormController());
		mappings.put("/board/write.do", new WriteController());
		mappings.put("/board/commentDelete.do", new CommentDeleteController());
		mappings.put("/board/commentUpdate.do", new CommentUpdateController());
		mappings.put("/board/commentRegist.do", new CommentRegistController());
		mappings.put("/main/Main.do", new MainController());
		mappings.put("/login/LoginForm.do", new LoginFormController());
		mappings.put("/login/Login.do", new LoginController());
		mappings.put("/login/Logout.do", new LogoutController());
	}
	
	public Controller getController(String uri) {
		return mappings.get(uri);
	}
}







