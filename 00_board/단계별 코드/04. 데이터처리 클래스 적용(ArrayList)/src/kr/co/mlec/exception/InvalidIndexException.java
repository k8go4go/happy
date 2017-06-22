package kr.co.mlec.exception;

public class InvalidIndexException extends RuntimeException {
	public InvalidIndexException() {}
	public InvalidIndexException(String msg) {
		super(msg);
	}
}
