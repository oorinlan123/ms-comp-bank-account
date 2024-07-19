package ec.nttdata.bankAccount.dto;

import java.io.Serializable;
import java.util.List;

import ec.nttdata.bankAccount.util.ResultStatus;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper=false)
public class ErrorResponse extends Response implements Serializable{

	private static final long serialVersionUID = 1L;
    private List<String> errors;
    
    public ErrorResponse(Response response) {
        super(response);
    }
    
    public ErrorResponse(ResultStatus result) {
        super(result);
    }
    
    public ErrorResponse(ErrorResponse errors) {
        super(errors);
    }

}
