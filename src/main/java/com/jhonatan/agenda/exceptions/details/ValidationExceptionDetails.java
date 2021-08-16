package com.jhonatan.agenda.exceptions.details;

import java.util.List;
import java.util.Map;

public class ValidationExceptionDetails extends ExceptionDetails {

	private Map<String, List<String>> fieldsAndMessages;

	private ValidationExceptionDetails(ValidationErrorDetailsBuilder builder) {
		this.setTitle(builder.title);
		this.setStatus(builder.status);
		this.setDetails(builder.details);
		this.setTimestamp(builder.timestamp);
		this.setDeveloperMessage(builder.developerMessage);
		this.fieldsAndMessages = builder.fieldsAndMessages;
	}

	public Map<String, List<String>> getFieldsAndMessages() {
		return fieldsAndMessages;
	}

	public void setFieldsAndMessages(Map<String, List<String>> fieldsAndMessages) {
		this.fieldsAndMessages = fieldsAndMessages;
	}

	public static ValidationErrorDetailsBuilder newValidationErrorDetailsBuilderBuilder() {
		return new ValidationErrorDetailsBuilder();
	}

	public static final class ValidationErrorDetailsBuilder {
		private String title;
		private String details;
		private long timestamp;
		private String developerMessage;
		private Map<String, List<String>> fieldsAndMessages;
		private int status;

		private ValidationErrorDetailsBuilder() {
		}

		public ValidationErrorDetailsBuilder withTitle(String title) {
			this.title = title;
			return this;
		}

		public ValidationErrorDetailsBuilder withStatus(int status) {
			this.status = status;
			return this;
		}

		public ValidationErrorDetailsBuilder withTimestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public ValidationErrorDetailsBuilder withDeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ValidationErrorDetailsBuilder withFieldsAndMessages(Map<String, List<String>> fieldsAndMessages) {
			this.fieldsAndMessages = fieldsAndMessages;
			return this;
		}

		public ValidationErrorDetailsBuilder withDetails(String details) {
			this.details = details;
			return this;
		}

		public ValidationExceptionDetails build() {
			return new ValidationExceptionDetails(this);
		}

	}

}
