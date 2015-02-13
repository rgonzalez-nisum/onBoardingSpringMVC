package com.nisum.onboarding.exception;

public class ParticipantException extends Exception {

	private static final long serialVersionUID = 1L;

	public ParticipantException(String message) {
		super(message);
	}

	public ParticipantException(String message, Throwable cause) {
		super(message, cause);
	}

}
