package annotation.quiz;

public class BoardController {
	@RequestMapping("/board/write.do")
	public void write() {
		System.out.println("등록 처리됨");
	}
	
	@RequestMapping("/board/list.do")
	public void list() {
		System.out.println("목록 처리됨");
	}
	
	@RequestMapping("/board/writeForm.do")
	public void writeForm() {
		System.out.println("등록폼 처리됨");
	}
}
