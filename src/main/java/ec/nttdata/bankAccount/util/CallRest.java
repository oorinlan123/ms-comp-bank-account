package ec.nttdata.bankAccount.util;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Map;

import org.apache.logging.log4j.Level;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpStatusCodeException;
import org.springframework.web.client.RestTemplate;
import com.google.gson.Gson;
import com.google.gson.JsonObject;

import lombok.extern.log4j.Log4j2;

/**
 * Clase que provee metodos de CallRest
 * 
 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
 * @version 1.0
 * @since 22/12/2020
 *
 */
@Service
@Log4j2
public class CallRest {
	
	private static final String METHOD = "Method : {}.";
	private static final String REQUEST = "Request : {}.";
	private static final String MESSAGEPROCESS = "Solicitud procesada en : {}  milisegundos.";
	private Gson gson = new Gson();
	
	/**
	 * metodo asincrono
	 * 
	 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
	 * @version 1.0
	 * @since 08/01/2021
	 *
	 * @param String url,
	 * @param HttpMethod method
 	 * @param JsonObject request
 	 * @param Header headerMethod
	 * @param String name
	 */
	@Async
	public void callAsync (String url, HttpMethod method, JsonObject request, String name, Map<String, String> headeMap) {
		log.log(Level.INFO, METHOD, name);
		log.log(Level.INFO, REQUEST, method);
		Long startTime;
		Long endTime;
		startTime = System.currentTimeMillis();
		try {
			HttpHeaders header = new HttpHeaders();
			header.setContentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8));
			header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			header.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8));
			if(headeMap != null) {
				headeMap.forEach((t,u) -> 
					header.set(t, u)
				);
			}
			
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<String> entity = null;
			if(request != null) {
				entity = new HttpEntity<>(request.toString(), header);
			}else {
				entity = new HttpEntity<>(header);
			}
			
			String result = restTemplate.exchange(url, method, entity, String.class).getBody();
			log.log(Level.INFO, result);

		} catch (HttpStatusCodeException e) {
			log.log(Level.ERROR, e);
		}
		endTime = System.currentTimeMillis();
		log.log(Level.INFO, MESSAGEPROCESS,(endTime - startTime));
	}
	
	/**
	 * metodo sincrono
	 * 
	 * @author Israel Guacho <mailto:israel.guachog@gmail.com>
	 * @version 1.0
	 * @since 08/01/2021
	 *
	 * @param String url,
	 * @param HttpMethod method
 	 * @param JsonObject request
 	 * @param Header headerMethod
	 * @param String name
	 */
	public JsonObject callSync (String url, HttpMethod method, JsonObject request, String name, Map<String, String> headeMap) {
		log.log(Level.INFO, METHOD, name);
		log.log(Level.INFO, REQUEST, method);
		JsonObject response = null;
		Long startTime;
		Long endTime;
		startTime = System.currentTimeMillis();
		try {
			HttpHeaders header = new HttpHeaders();
			
			header.setContentType(new MediaType(MediaType.APPLICATION_JSON, StandardCharsets.UTF_8));
			header.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
			header.setAcceptCharset(Arrays.asList(StandardCharsets.UTF_8));
			if(headeMap != null) {
				headeMap.forEach((t,u) -> 
					header.set(t, u)
				);
			}
			RestTemplate restTemplate = new RestTemplate();
			HttpEntity<String> entity = null;
			if(request != null) {
				entity = new HttpEntity<>(request.toString(), header);
			}else {
				entity = new HttpEntity<>(header);
			}
			String result = restTemplate.exchange(url, method, entity, String.class).getBody();
			response = gson.fromJson(result, JsonObject.class);
		} catch (HttpStatusCodeException e) {
			log.log(Level.ERROR, e);
			response = gson.fromJson(e.getResponseBodyAsString(), JsonObject.class);
		}
		endTime = System.currentTimeMillis();
		log.log(Level.INFO, MESSAGEPROCESS,(endTime - startTime));
		return response;
	}
}
