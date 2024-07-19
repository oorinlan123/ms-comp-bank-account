package ec.nttdata.bankAccount.handler;

import org.springframework.core.annotation.Order;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import ec.nttdata.bankAccount.dto.ErrorResponse;
import ec.nttdata.bankAccount.dto.Response;
import ec.nttdata.bankAccount.util.ResultStatus;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
@Order(1)
public class ValidationExceptionHandler {

    @SuppressWarnings("null")
	@ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleValidationException(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        for (FieldError error : ex.getBindingResult().getFieldErrors()) {
            String errorMessage = error.getDefaultMessage();
            errors.add(errorMessage);
        }
        for (ObjectError error : ex.getBindingResult().getGlobalErrors()) {
            String errorMessage = error.getObjectName() + ": " + error.getDefaultMessage();
            errors.add(errorMessage);
        }
        ErrorResponse response = new ErrorResponse(new Response(ResultStatus.BAD_REQUEST));
        response.setMessage("Validation Failed");
        response.setDescription("La petición realizada presenta errores, por favor revisalos y vuelve a intentarlo");
        response.setErrors(errors);
        return response;
    }
}

