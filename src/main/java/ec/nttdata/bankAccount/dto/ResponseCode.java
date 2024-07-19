package ec.nttdata.bankAccount.dto;

import ec.nttdata.bankAccount.util.ResultStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class ResponseCode extends Response{

	private static final long serialVersionUID = 1L;
	private String tenderCode;

	/**
	 * @param response
	 */
	public ResponseCode(Response response) {
		super(response);
	}

	/**
	 * @param result
	 */
	public ResponseCode(ResultStatus result) {
		super(result);
	}

}
