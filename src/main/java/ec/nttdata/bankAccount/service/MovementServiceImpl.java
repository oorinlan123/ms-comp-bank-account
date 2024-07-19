package ec.nttdata.bankAccount.service;

import java.util.Date;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ec.nttdata.core.db.entity.Accounts;
import ec.nttdata.core.db.entity.Clients;
import ec.nttdata.core.db.entity.Movements;
import ec.nttdata.core.db.repository.AccountsRepository;
import ec.nttdata.core.db.repository.ClientsRepository;
import ec.nttdata.core.db.repository.MovementsRepository;
import ec.nttdata.bankAccount.dto.Header;
import ec.nttdata.bankAccount.dto.MovementCreateUpdateRequest;
import ec.nttdata.bankAccount.dto.MovementParamRequest;
import ec.nttdata.bankAccount.dto.Response;
import ec.nttdata.bankAccount.util.ResultStatus;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que provee metodos de CRUD de las ubicaciones
 * 
 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
 * @version 1.0
 * @since 27/12/2022
 *
 */
@Service
@Transactional
@Log4j2
public class MovementServiceImpl implements MovementService {

	private static final String METHOD = "Method : {}.";
	private static final String REQUEST = "Request : {}.";
	private static final String MESSAGEPROCESS = "Solicitud procesada en : {}  milisegundos.";
	private static final String MESSAGEERROR = "Lo sentimos, inténtelo nuevamente.";
	private static final String INTERNALMESSAGEERROR = "Lo sentimos, inténtelo nuevamente.";
	private static final String ACTIVE = "ACTIVO";
	private static final String INACTIVE = "INACTIVO";
	
	@Autowired
	private AccountsRepository accountsRepository;
	
	@Autowired
	private ClientsRepository clientsRepository;
	
	@Autowired
	private MovementsRepository movementsRepository;
	
	/**
	 * Creación de cuenta
	 * 
	 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
	 * @version 1.0
	 * @since 30/05/2022
	 *
	 * @param Header                               header
	 * @param AccountCreateUpdateRequest request
	 * @return Response
	 */
	@Override
	public Response create(Header header, MovementCreateUpdateRequest request) {

		Long startTime = System.currentTimeMillis();
		Date now = new Date();
		Response response = null;

		try {
			
			

			Accounts account = accountsRepository.findByCodeAndStatus(request.getAccountId(), ACTIVE);
			
			response = new Response(ResultStatus.NOT_UPDATED);
			response.setDescription("No existe la cuenta o se encuentra inactivo");
			if (account != null) {
				
				String movementType = "DEBITO";
				
				if (request.getAmount() >= 0) movementType = "CREDITO";
				
				Movements movement = new Movements();
				
				movement.setCode(UUID.randomUUID().toString());
				movement.setStatus(ACTIVE);
				movement.setCreateDate(now);
				movement.setModifyDate(now);
				movement.setCreateUser(header.getUser());
				movement.setModifyUser(header.getUser());
				movement.setMovementType(movementType);
				movement.setAmount(request.getAmount());
				movement.setAccountId(account);
				
				accountsRepository.saveAndFlush(account);

				response = new Response(ResultStatus.CREATED);
				response.setDescription("Cuenta creado con éxito");	
				
			}
			
			

		} catch (Exception e) {
			log.log(Level.ERROR, e);
			log.log(Level.ERROR, e + " -Line: " + e.getStackTrace()[0].toString());
			response = new Response(ResultStatus.INTERNAL_SERVER_ERROR);
			response.setDescription(INTERNALMESSAGEERROR);
		}
		Long endTime = System.currentTimeMillis();
		log.log(Level.INFO, MESSAGEPROCESS, (endTime - startTime));
		return response;
	}
	
	/**
	 * Actualización de cuenta
	 * 
	 * @author Israel Jonathan Guacho Guaman <mailto:israel.guachog@gmail.com>
	 * @version 1.0
	 * @since 18/07/2024
	 *
	 * @param Header header
	 * @param String userId
	 * @param String locationCode
	 * @param LocationExceptionUpdateRequest request
	 * @return Response
	 */
	@Override
	public Response update(Header header, MovementParamRequest param, MovementCreateUpdateRequest request) {

		Long startTime = System.currentTimeMillis();
		Date now = new Date();
		Response response = null;

		try {
			
			Accounts account = accountsRepository.findByCodeAndStatus(param.getCode(), ACTIVE);
			response = new Response(ResultStatus.NOT_UPDATED);
			response.setDescription("No existe la cuenta a actualizar o se encuentra inactivo");
			if (account != null) {				
						
				account.setStatus(ACTIVE);
				account.setModifyDate(now);
				account.setModifyUser(header.getUser());
				account.setAccountType(request.getAccountType());
				
				accountsRepository.saveAndFlush(account);
				
				response = new Response(ResultStatus.UPDATED);
				response.setDescription("Cuenta actualizada con éxito");
			}

		} catch (Exception e) {
			log.log(Level.ERROR, e);
			log.log(Level.ERROR, e + " -Line: " + e.getStackTrace()[0].toString());
			response = new Response(ResultStatus.INTERNAL_SERVER_ERROR);
			response.setDescription(INTERNALMESSAGEERROR);
		}
		Long endTime = System.currentTimeMillis();
		log.log(Level.INFO, MESSAGEPROCESS, (endTime - startTime));
		return response;
	}
	
	/**
	 * Eliminación de cuenta
	 * 
	 * @author Israel Jonathan Guacho Guaman <mailto:israel.guachog@gmail.com>
	 * @version 1.0
	 * @since 18/07/2024
	 *
	 * @param Header header
	 * @param String userId
	 * @param String locationCode
	 * @return Response
	 */
	public Response delete(Header header, MovementParamRequest param) {
		log.log(Level.INFO, METHOD, "exceptionCreate");
		log.log(Level.INFO, "LocationExceptionParamRequest: ", param);
		
		Long startTime = System.currentTimeMillis();
		Date now = new Date();
		
		Response response = null;
		try {
			Accounts account = accountsRepository.findByCodeAndStatus(param.getCode(), ACTIVE);
			response = new Response(ResultStatus.NOT_DELETED);
			response.setDescription("No existe cuenta a eliminar o se encuentra inactivo");
			if (account != null) {
				
				account.setStatus(INACTIVE);
				account.setModifyDate(now);
				account.setModifyUser(header.getUser());
				
				accountsRepository.saveAndFlush(account);
				response = new Response(ResultStatus.DELETED);
				response.setDescription("Cuenta eliminada con éxito");
			}
		} catch (Exception e) {
			log.log(Level.ERROR, e);
			log.log(Level.ERROR, e + " -Line: " + e.getStackTrace()[0].toString());
			response = new Response(ResultStatus.INTERNAL_SERVER_ERROR);
			response.setDescription(INTERNALMESSAGEERROR);
		}
		
		Long endTime = System.currentTimeMillis();
		log.log(Level.INFO, MESSAGEPROCESS, (endTime - startTime));
		return response;
	}

}
