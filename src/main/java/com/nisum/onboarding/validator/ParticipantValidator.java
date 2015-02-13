package com.nisum.onboarding.validator;

import org.springframework.validation.Errors;
import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;
import org.springframework.validation.Validator;

import com.nisum.onboarding.model.Participant;

public class ParticipantValidator implements Validator {

	@Override
	public boolean supports(Class<?> clazz) {
		return Participant.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		rejectIfEmptyOrWhitespace(errors, "name", "participant.required.name", "Field required");
		rejectIfEmptyOrWhitespace(errors, "lastname", "participant.required.lastname", "Field required");
		rejectIfEmptyOrWhitespace(errors, "position", "participant.required.position", "Field required");
		rejectIfEmptyOrWhitespace(errors, "email", "participant.required.email", "Field required");
	}

}
