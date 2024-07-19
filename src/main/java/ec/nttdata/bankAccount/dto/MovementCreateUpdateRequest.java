package ec.nttdata.bankAccount.dto;

import java.io.Serializable;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.ToString;
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(callSuper=false)
@ToString
public class MovementCreateUpdateRequest extends Movement implements Serializable{

	private static final long serialVersionUID = 1L;
	
	@NotNull(message = "El campo 'movementId' es requerido")
	private String movementId;
	
	private String accountId;
	
}
