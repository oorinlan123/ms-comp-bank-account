package ec.nttdata.bankAccount.util;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;
import java.util.UUID;

public class UUIDValidator implements ConstraintValidator<Uuid, String> {

    private String message;

    @Override
    public void initialize(Uuid constraintAnnotation) {
        message = constraintAnnotation.message();
    }

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        if (value == null) {
            return false;
        }

        try {
            // Convierte el valor de String a UUID
            UUID uuid = UUID.fromString(value);

            // Aquí puedes agregar lógica adicional de validación de UUID si es necesario

            return true;
        } catch (IllegalArgumentException e) {
            return false;
        }
    }
}
