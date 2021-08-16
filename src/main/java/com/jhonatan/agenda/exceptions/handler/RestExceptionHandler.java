package com.jhonatan.agenda.exceptions.handler;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.jhonatan.agenda.exceptions.details.ExceptionDetails;
import com.jhonatan.agenda.exceptions.details.ResourceNotFoundDetails;
import com.jhonatan.agenda.exceptions.details.ValidationExceptionDetails;
import com.jhonatan.agenda.exceptions.exception.DataIntegrityException;
import com.jhonatan.agenda.exceptions.exception.ResourceNotFoundExeption;

@ControllerAdvice
public class RestExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleExceptionInternal(Exception ex, Object body, HttpHeaders headers,
			HttpStatus status, WebRequest request) {

		ExceptionDetails errorDetails = ExceptionDetails.newErrorDetailBuilder().withTimestamp(new Date().getTime())
				.withStatus(status.value()).withTitle("Internal Exeption.").withDetails(ex.getMessage())
				.withDeveloperMessage(ex.getClass().getName()).build();

		return new ResponseEntity<>(errorDetails, headers, status);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException manvException,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<FieldError> fieldErrors = manvException.getBindingResult().getFieldErrors();

		Map<String, List<String>> fieldsAndMessages = new HashMap<>();

		fieldErrors.forEach(
				f -> fieldsAndMessages.put(f.getField(), new ArrayList<>(Arrays.asList(f.getDefaultMessage()))));

		ValidationExceptionDetails validationDetail = ValidationExceptionDetails
				.newValidationErrorDetailsBuilderBuilder().withTimestamp(new Date().getTime())
				.withStatus(HttpStatus.BAD_REQUEST.value()).withTitle("Erro de validação.")
				.withDetails("Verifique os dados enviados.").withDeveloperMessage(manvException.getClass().getName())
				.withFieldsAndMessages(fieldsAndMessages).build();

		return new ResponseEntity<>(validationDetail, HttpStatus.BAD_REQUEST);
	}

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		ExceptionDetails errorDetails = ExceptionDetails.newErrorDetailBuilder().withTimestamp(new Date().getTime())
				.withStatus(status.value()).withTitle("Request invalido").withDetails(ex.getMessage())
				.withDeveloperMessage(ex.getClass().getName()).build();
		return new ResponseEntity<>(errorDetails, headers, status);
	}

	@ExceptionHandler(ResourceNotFoundExeption.class)
	public ResponseEntity<?> handleResourceNotFoundException(ResourceNotFoundExeption rnfException) {

		ResourceNotFoundDetails resourceNotFoundDetails = ResourceNotFoundDetails.newResourceNotFoundBuilder()
				.withTimestamp(new Date().getTime()).withStatus(HttpStatus.NOT_FOUND.value())
				.withTitle("Recurso não encontrado.")
				.withDetails("O recurso " + rnfException.getResource().getSimpleName() + " com id "
						+ rnfException.getResourceId() + " não foi encontrado.")
				.withDeveloperMessage(rnfException.getClass().getName())
				.withResource(rnfException.getResource().getName()).build();
		return new ResponseEntity<>(resourceNotFoundDetails, HttpStatus.NOT_FOUND);
	}

	@ExceptionHandler(DataIntegrityException.class)
	public ResponseEntity<?> handleDataIntegrityException(DataIntegrityException dtiException) {

		ExceptionDetails resourceNotFoundDetails = ExceptionDetails.newErrorDetailBuilder()
				.withTimestamp(new Date().getTime()).withStatus(HttpStatus.BAD_REQUEST.value())
				.withTitle("Erro ao deletar.").withDetails(dtiException.getMessage())
				.withDeveloperMessage(dtiException.getClass().getName()).build();
		return new ResponseEntity<>(resourceNotFoundDetails, HttpStatus.BAD_REQUEST);
	}
}
