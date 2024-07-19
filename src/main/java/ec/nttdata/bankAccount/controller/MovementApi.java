package ec.nttdata.bankAccount.controller;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestBody;

import ec.nttdata.bankAccount.dto.MovementCreateUpdateRequest;
import ec.nttdata.bankAccount.dto.MovementParamRequest;
import ec.nttdata.bankAccount.dto.Response;

/**
 * Definicion de la interfaz del API de Movimientos
 * 
 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
 * @version 1.0
 * @since 18/07/2024
 */
public interface MovementApi {
	
	
	public ResponseEntity<Response> create(
			HttpServletRequest header,
			String channel,
			String user,
			String app,
			@Valid @RequestBody MovementCreateUpdateRequest request
	);
	
	public ResponseEntity<Response> update(
			HttpServletRequest header,String channel,
			String user,
			String app,
			@Valid @ModelAttribute MovementParamRequest param,
			@Valid @RequestBody MovementCreateUpdateRequest request
	);
	
	public ResponseEntity<Response> delete(
			HttpServletRequest header,
			String channel,
			String user,
			String app,
			@Valid @ModelAttribute MovementParamRequest param
	);

}
