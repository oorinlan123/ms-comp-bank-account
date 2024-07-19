package ec.nttdata.bankAccount.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.io.Serializable;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.validation.constraints.Min;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class Movement implements Serializable {

    private static final long serialVersionUID = 1L;
    
    @NotNull(message = "El campo 'date' es requerido")
    @Size(min = 2, max = 50, message = "El campo 'date' debe tener entre 2 o más caracteres")
    private String date;
    
    @NotNull(message = "El campo 'amount' es requerido")
    private Double amount;

}
