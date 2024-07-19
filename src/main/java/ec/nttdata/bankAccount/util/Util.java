package ec.nttdata.bankAccount.util;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.apache.commons.io.FilenameUtils;
import org.apache.logging.log4j.Level;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpMethod;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonArray;
import com.google.gson.JsonObject;

import ec.nttdata.bankAccount.dto.Header;
import ec.nttdata.bankAccount.dto.Response;
import ec.nttdata.core.db.entity.Accounts;
import ec.nttdata.core.db.repository.AccountsRepository;
import ec.nttdata.core.db.entity.Movements;
import ec.nttdata.core.db.repository.MovementsRepository;
import ec.nttdata.bankAccount.dto.TransactionDto;
import lombok.extern.log4j.Log4j2;

/**
 * Clase que provee metodos de Util
 * 
 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
 * @version 1.0
 * @since 16/12/2020
 *
 */

@Service
@Transactional
@Log4j2
public class Util {

private static final String METHOD = "Method : {}.";
private static final String REQUEST = "Request : {}.";
private static final String MESSAGEPROCESS = "Solicitud procesada en : {}  milisegundos.";
private static final String ACTIVE = "ACTIVO";
private static final String TOPICNOTIFICATION = "KT_KAFKA_TOPIC_NOTIFICACION";
private static final String DESCRIPTION = "description";
private static final String LINE = " -Line: ";

@Autowired
private CallRest callRest;

@Autowired
private AccountsRepository accountsRepository;

@Autowired
private MovementsRepository movementsRepository;

/**
 * Validación para obtener el ultimo saldo del movimiento
 * 
 * @author Israel Jonathan Guacho Guaman <mailto:iguacho@telconet.ec>
 * @version 1.0
 * @since 18/07/2024
 *
 * @param Header header
 * @param String identificationNumber
 * @return Response response
 */
	public TransactionDto getMovementBalance(String accountId, Double amount) {
		
		TransactionDto transaction = new TransactionDto();
		transaction.setInitialBalance(0);
		transaction.setMovement(amount);
		transaction.setAvailableBalance(0);
		
		try {
			
			
		} catch (Exception e) {
			log.log(Level.ERROR, e);
			log.log(Level.ERROR, e + LINE + e.getStackTrace()[0].toString());;
		}
		return transaction;
	}


}
