package ec.nttdata.bankAccount.service;

import ec.nttdata.bankAccount.dto.Header;
import ec.nttdata.bankAccount.dto.MovementCreateUpdateRequest;
import ec.nttdata.bankAccount.dto.MovementParamRequest;
import ec.nttdata.bankAccount.dto.Response;

/**
 * Definicion de la interfaz del servicio de ubicaciones
 * 
 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
 * @version 1.0
 * @since 27/12/2022
 * 
 */
public interface MovementService {
	
	public Response create(Header header, MovementCreateUpdateRequest request);
	
	public Response update(Header header, MovementParamRequest param, MovementCreateUpdateRequest request);
	
	public Response delete(Header header, MovementParamRequest param);
	
}
 