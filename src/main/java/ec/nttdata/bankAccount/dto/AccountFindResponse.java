package ec.nttdata.bankAccount.dto;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.ToString;

import java.util.List;

import ec.nttdata.bankAccount.util.ResultStatus;

@Data
@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
public class AccountFindResponse extends Response {

	private static final long serialVersionUID = 1L;
	private List<Account> accountList;
	
	/**
	 * @param response
	 */
	public AccountFindResponse(Response response) {
		super(response);
	}

	/**
	 * @param result
	 */
	public AccountFindResponse(ResultStatus result) {
		super(result);
	}
	
}
