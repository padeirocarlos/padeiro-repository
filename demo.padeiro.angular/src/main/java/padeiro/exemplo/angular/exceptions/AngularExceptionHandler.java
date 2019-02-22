package padeiro.exemplo.angular.exceptions;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import javax.inject.Inject;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class AngularExceptionHandler extends ResponseEntityExceptionHandler {

	@Inject
	private MessageSource messageSource;

	@Override
	protected ResponseEntity<Object> handleHttpMessageNotReadable(HttpMessageNotReadableException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		String userMessage = messageSource.getMessage("message.invality", null, LocaleContextHolder.getLocale());

		String developerMessage = ex.getCause() != null ? ex.getCause().toString() : ex.toString();

		return handleExceptionInternal(ex, new ErroBodyContent(userMessage, developerMessage), headers,
				HttpStatus.BAD_REQUEST, request);
	}

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {

		List<ErroBodyContent> erros = createListError(ex.getBindingResult());

		return handleExceptionInternal(ex, erros, headers, HttpStatus.BAD_REQUEST, request);
	}

	@ExceptionHandler({ EmptyResultDataAccessException.class })
	protected ResponseEntity<Object> handleEmptyResultDataAccessException(EmptyResultDataAccessException ex,
			WebRequest request) {

		String userMessage = messageSource.getMessage("resource.not-found", null, LocaleContextHolder.getLocale());
		String developerMessage = ex.toString();

		List<ErroBodyContent> erros = Arrays.asList(new ErroBodyContent(userMessage, developerMessage));

		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.NOT_FOUND, request);
	}

	@ExceptionHandler({ DataIntegrityViolationException.class })
	protected ResponseEntity<Object> exceptionHandle(DataIntegrityViolationException ex, WebRequest request) {

		String mensagemUsuario = messageSource.getMessage("dataaccess.exception", null,
				LocaleContextHolder.getLocale());

		String mensagemDesenvolvedor = ExceptionUtils.getRootCauseMessage(ex) == null ? ex.toString()
				: ExceptionUtils.getRootCauseMessage(ex);

		List<ErroBodyContent> erros = Arrays.asList(new ErroBodyContent(mensagemUsuario, mensagemDesenvolvedor));

		return handleExceptionInternal(ex, erros, new HttpHeaders(), HttpStatus.BAD_REQUEST, request);
	}

	private List<ErroBodyContent> createListError(BindingResult bindingResult) {

		List<ErroBodyContent> errors = new ArrayList<>();

		for (FieldError fieldError : bindingResult.getFieldErrors()) {

			String userErrorMessage = messageSource.getMessage(fieldError, LocaleContextHolder.getLocale());

			String deveErrorloperMessage = fieldError.toString();

			errors.add(new ErroBodyContent(userErrorMessage, deveErrorloperMessage));
		}

		return errors;
	}

	public static class ErroBodyContent {

		private String userErrorMessage;
		private String deveErrorloperMessage;

		public ErroBodyContent(String userErrorMessage, String developerErrorMessage) {
			this.userErrorMessage = userErrorMessage;
			this.deveErrorloperMessage = developerErrorMessage;
		}

		public String getUserMessage() {
			return userErrorMessage;
		}

		public String getDeveloperMessage() {
			return deveErrorloperMessage;
		}
	}
}
