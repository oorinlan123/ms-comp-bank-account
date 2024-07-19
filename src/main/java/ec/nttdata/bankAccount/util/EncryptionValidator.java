package ec.nttdata.bankAccount.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;

import ec.nttdata.bankAccount.service.AccountServiceImpl;
import lombok.extern.log4j.Log4j2;

@Log4j2
public class EncryptionValidator implements ConstraintValidator<EncryptionId, String> {

    private String message;

    @Override
    public void initialize(EncryptionId constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
    	boolean valid = false;
    	try {
    		if (value != null) {
    			// Aquí puedes implementar la lógica de desencriptación y validar el valor

                // Ejemplo: utilizando la clase Encryptation para desencriptar
                // String decryptedValue = encryptation.decode(value);

                // Ejemplo: validando si el valor desencriptado cumple ciertas condiciones
                // Aquí puedes agregar tu lógica de validación personalizada
                // boolean isValid = decryptedValue != null && decryptedValue.length() > 0;
                boolean isValid = true;

                if (!isValid) {
                    context.disableDefaultConstraintViolation();
                    context.buildConstraintViolationWithTemplate(message)
                            .addConstraintViolation();
                }

                valid = isValid;
    		}
		} catch (Exception e) {
			log.log(Level.ERROR, e);
			log.log(Level.ERROR, e + " -Line: " + e.getStackTrace()[0].toString());
		}
    	return valid;
    }
}
