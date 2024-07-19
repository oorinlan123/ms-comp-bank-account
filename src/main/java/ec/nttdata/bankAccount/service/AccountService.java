package ec.nttdata.bankAccount.service;

import ec.nttdata.bankAccount.dto.Header;
import ec.nttdata.bankAccount.dto.AccountCreateUpdateRequest;
import ec.nttdata.bankAccount.dto.AccountFindResponse;
import ec.nttdata.bankAccount.dto.AccountParamRequest;
import ec.nttdata.bankAccount.dto.Response;

/**
 * Definicion de la interfaz del servicio de ubicaciones
 * 
 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
 * @version 1.0
 * @since 27/12/2022
 * 
 */
public interface AccountService {
	
	public Response create(Header header, AccountCreateUpdateRequest request);
	
	public Response update(Header header, AccountParamRequest param, AccountCreateUpdateRequest request);
	
	public Response delete(Header header, AccountParamRequest param);
	
}
 