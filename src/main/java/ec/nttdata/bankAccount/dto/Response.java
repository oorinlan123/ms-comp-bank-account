package ec.nttdata.bankAccount.dto;

import java.io.Serializable;

import ec.nttdata.bankAccount.util.ResultStatus;
import lombok.Data;

@Data
public class Response implements Serializable{

	private static final long serialVersionUID = 1L;
	private Integer code;
	private String message;
	private String description;
	public Response(Response response) {
		super();
		this.code = response.getCode();
		this.message = response.getMessage();
	}
	
	public Response(ResultStatus result) {
		super();
		this.code = result.getValue();
		this.message = result.getMessage();
	}
}
