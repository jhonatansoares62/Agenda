package com.jhonatan.agenda.exceptions.details;

public class ResourceNotFoundDetails extends ExceptionDetails {

	private String resource;

	protected ResourceNotFoundDetails() {

	}

	private ResourceNotFoundDetails(ResourceNotFoundDetailsBuilder builder) {
		this.setTitle(builder.title);
		this.setStatus(builder.status);
		this.setDetails(builder.details);
		this.setTimestamp(builder.timestamp);
		this.setDeveloperMessage(builder.developerMessage);
		this.setResource(builder.resource);
	}

	public String getResource() {
		return resource;
	}

	public void setResource(String resource) {
		this.resource = resource;
	}

	public static ResourceNotFoundDetailsBuilder newResourceNotFoundBuilder() {
		return new ResourceNotFoundDetailsBuilder();
	}

	public static final class ResourceNotFoundDetailsBuilder {
		private String title;
		private int status;
		private String details;
		private long timestamp;
		private String developerMessage;
		private String resource;

		private ResourceNotFoundDetailsBuilder() {
		}

		public ResourceNotFoundDetailsBuilder withTitle(String title) {
			this.title = title;
			return this;
		}

		public ResourceNotFoundDetailsBuilder withStatus(int status) {
			this.status = status;
			return this;
		}

		public ResourceNotFoundDetailsBuilder withDetails(String details) {
			this.details = details;
			return this;
		}

		public ResourceNotFoundDetailsBuilder withTimestamp(long timestamp) {
			this.timestamp = timestamp;
			return this;
		}

		public ResourceNotFoundDetailsBuilder withDeveloperMessage(String developerMessage) {
			this.developerMessage = developerMessage;
			return this;
		}

		public ResourceNotFoundDetailsBuilder withResource(String resource) {
			this.resource = resource;
			return this;
		}

		public ResourceNotFoundDetails build() {
			return new ResourceNotFoundDetails(this);
		}
	}

}
