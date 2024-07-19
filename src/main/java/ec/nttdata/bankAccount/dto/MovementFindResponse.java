package ec.nttdata.bankAccount.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

import ec.nttdata.bankAccount.util.ResultStatus;
import ec.nttdata.core.db.entity.Movements;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class MovementFindResponse extends Response {

	private static final long serialVersionUID = 1L;
	private List<Movements> movementList;
	
	/**
	 * @param response
	 */
	public MovementFindResponse(Response response) {
		super(response);
	}

	/**
	 * @param result
	 */
	public MovementFindResponse(ResultStatus result) {
		super(result);
	}
	
}
