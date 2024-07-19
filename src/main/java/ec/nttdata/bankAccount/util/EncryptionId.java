package ec.nttdata.bankAccount.util;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.*;

@Target({ElementType.FIELD, ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Constraint(validatedBy = EncryptionValidator.class)
public @interface EncryptionId {
    String message() default "Invalid encrypted value";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};
}
