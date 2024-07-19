package ec.nttdata.bankAccount.controller;

import java.util.UUID;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

import org.apache.logging.log4j.ThreadContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import ec.nttdata.bankAccount.dto.Header;
import ec.nttdata.bankAccount.dto.AccountCreateUpdateRequest;
import ec.nttdata.bankAccount.dto.AccountFindResponse;
import ec.nttdata.bankAccount.dto.AccountParamRequest;
import ec.nttdata.bankAccount.dto.Response;
import ec.nttdata.bankAccount.service.AccountServiceImpl;
import ec.nttdata.bankAccount.util.EncryptionId;

/**
 * Implementacion de la funcionalidad del web service de clients
 * 
 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
 * @version 1.0
 * @since 27/12/2022
 */

@RestController
@RequestMapping("/accounts")
@Validated
public class AccountApiController implements AccountApi{

	private static final String SID = "sid";
	private String threadID;
	
	@Autowired
	private AccountServiceImpl accountService;
	
	/**
     * API de creacion de cuentas
     * 
     * @author Israel Guacho <mailto:israel.guachog@gmail.com>
	 * @version 1.0
	 * @since 18/07/2024
     * @param HttpServletRequest header
     * @param @RequestHeader String channel
     * @param @RequestHeader String user
     * @param @RequestHeader String app
     * @param @RequestBody AccountCreateUpdateRequest request
     * @return Response
     */
	@PostMapping("/create")
	@CrossOrigin(origins = "*")
	@Override
	public ResponseEntity<Response> create(
			HttpServletRequest header,
			@RequestHeader String channel,
			@RequestHeader String user,
			@RequestHeader String app, 
			@Valid @RequestBody AccountCreateUpdateRequest request
	) {
		threadID=UUID.randomUUID().toString();
		ThreadContext.put(SID, threadID);
		Header headers = new Header(header);
		return new ResponseEntity<>(accountService.create(headers, request), HttpStatus.OK);
	}
	
	/**
     * API de actualización de cliente
     * 
     * @author Israel Jonathan Guacho Guaman <mailto:israel.guachog@gmail.com>
	 * @version 1.0
	 * @since 18/07/2024
     * @param HttpServletRequest header
     * @param @RequestHeader String channel
     * @param @RequestHeader String user
     * @param @RequestHeader String app
     * @param @RequestParam String userId
     * @param @RequestParam AccountParamRequest param
     * @param @RequestBody AccountCreateUpdateRequest request
     * @return Response
     */
	@PutMapping("/update")
	@CrossOrigin(origins = "*")
	@Override
	public ResponseEntity<Response> update(
			HttpServletRequest header,
			@RequestHeader String channel,
			@RequestHeader String user,
			@RequestHeader String app,
			@Valid @ModelAttribute AccountParamRequest param,
			@Valid @RequestBody AccountCreateUpdateRequest request
	) {
		threadID=UUID.randomUUID().toString();
		ThreadContext.put(SID, threadID);
		Header headers = new Header(header);
		return new ResponseEntity<>(accountService.update(headers, param, request), HttpStatus.OK);
	}
	
	/**
     * API de eliminación de cliente
     * 
     * @author Israel Jonathan Guacho Guaman <mailto:israel.guachog@gmail.com>
	 * @version 1.0
	 * @since 18/07/2024
     * @param HttpServletRequest header
     * @param @RequestHeader String channel
     * @param @RequestHeader String user
     * @param @RequestHeader String app
     * @param @RequestParam String userId
     * @param @RequestParam AccountParamRequest param
     * @return Response
     */
	@DeleteMapping("/delete")
	@CrossOrigin(origins = "*")
	@Override
	public ResponseEntity<Response> delete(
			HttpServletRequest header,
			String channel,
			String user,
			String app,
			@Valid @ModelAttribute AccountParamRequest param
	) {
		threadID=UUID.randomUUID().toString();
		ThreadContext.put(SID, threadID);
		Header headers = new Header(header);
		return new ResponseEntity<>(accountService.delete(headers, param), HttpStatus.OK);
	}

}
