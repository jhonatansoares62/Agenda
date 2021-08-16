package com.jhonatan.agenda.exceptions.details;

public class ExceptionDetails {

	private String title;
	private int status;
	private long timestamp;
	private String developerMessage;
	private String details;

	public ExceptionDetails() {

	}

	private ExceptionDetails(ExceptionDetailsBuilder builder) {
		this.title = builder.title;
		this.status = builder.status;
		this.details = builder.details;
		this.timestamp = builder.timestamp;
		this.developerMessage = builder.developerMessage;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public long getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(long timestamp) {
		this.timestamp = timestamp;
	}

	public String getDeveloperMessage() {
		return developerMessage;
	}

	public void setDeveloperMessage(String developerMessage) {
		this.developerMessage = developerMessage;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public static ExceptionDetailsBuilder newErrorDetailBuilder() {
		return new ExceptionDetailsBuilder();
	}

	public static final class ExceptionDetailsBuilder {
		private String title;
		private int status;
		private String details;
		private long timestamp;
		private String developerMessage;

		private ExceptionDetailsBuilder() {
		}

		public ExceptionDetailsBuilder withTitle(String title) {
			this.title = title;
			return this;
		}

		public ExceptionDetailsBuilder withStatus(int status) {
			this.status = status;
			return this;
		}

		public ExceptionDetailsBuilder withDetails(String details) {
			this.details = details;
			return this;
		}

		public ExceptionDetailsBuilder withTimestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public ExceptionDetailsBuilder withDeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ExceptionDetails build() {
			return new ExceptionDetails(this);
		}
	}

}
