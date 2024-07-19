package ec.nttdata.bankAccount.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import ec.nttdata.bankAccount.dto.AccountCreateUpdateRequest;
import ec.nttdata.bankAccount.dto.AccountFindResponse;
import ec.nttdata.bankAccount.dto.AccountParamRequest;
import ec.nttdata.bankAccount.dto.Response;
import ec.nttdata.bankAccount.util.EncryptionId;

/**
 * Definicion de la interfaz del API de ubicaciones
 * 
 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
 * @version 1.0
 * @since 18/07/2024
 */
public interface AccountApi {
	
	
	public ResponseEntity<Response> create(
			HttpServletRequest header,
			String channel,
			String user,
			String app,
			@Valid @RequestBody AccountCreateUpdateRequest request
	);
	
	public ResponseEntity<Response> update(
			HttpServletRequest header,String channel,
			String user,
			String app,
			@Valid @ModelAttribute AccountParamRequest param,
			@Valid @RequestBody AccountCreateUpdateRequest request
	);
	
	public ResponseEntity<Response> delete(
			HttpServletRequest header,
			String channel,
			String user,
			String app,
			@Valid @ModelAttribute AccountParamRequest param
	);

}
