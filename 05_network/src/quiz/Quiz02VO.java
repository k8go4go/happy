package quiz;

class QuizResult02 {
	private String translatedText;
	public String getTranslatedText() {
		return translatedText;
	}
	public void setTranslatedText(String translatedText) {
		this.translatedText = translatedText;
	}
}

class QuizMessage02 {
	private QuizResult02 result;
	public QuizResult02 getResult() {
		return result;
	}
	public void setResult(QuizResult02 result) {
		this.result = result;
	}
}

public class Quiz02VO {
	private QuizMessage02 message;

	public QuizMessage02 getMessage() {
		return message;
	}

	public void setMessage(QuizMessage02 message) {
		this.message = message;
	}
}
