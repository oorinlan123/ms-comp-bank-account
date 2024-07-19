package ec.nttdata.bankAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Null;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;
import javax.validation.constraints.Max;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Account implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @NotNull(message = "El campo 'accountNumber' es requerido")
    @Size(min = 2, max = 50, message = "El campo 'accountNumber' debe tener entre 2 o más caracteres")
    private String accountNumber;
    
    @NotNull(message = "El campo 'accountType' es requerido")
    @Size(min = 2, message = "El campo 'accountType' debe tener entre 3 o más caracteres")
    private String accountType;
    
    @NotNull(message = "El campo 'initialBalance' es requerido")
    @Min(value = 5, message = "El valor mínimo para el campo 'initialBalance' debe ser mayor o igual a 5")
    private Double initialBalance;

}
