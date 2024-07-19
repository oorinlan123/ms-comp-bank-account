package ec.nttdata.bankAccount.dto;

import java.io.Serializable;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.apache.logging.log4j.Level;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.extern.log4j.Log4j2;

@Data
@AllArgsConstructor
@NoArgsConstructor
@ToString
@Log4j2
public class Header implements Serializable{

	private static final long serialVersionUID = 1L;
	private String channel; 
	private String deviceId;
	private String so;
	private String app;
	private String user;
	private String token;

	public Header(HttpServletRequest request) {
		super();
		this.deviceId = request.getRemoteHost();
		this.channel = request.getHeader("channel");
		this.app = request.getHeader("app");
		this.user = request.getHeader("user");
		this.token = request.getHeader("token");
		String userAgent = request.getHeader("user-agent").toLowerCase();
		log.log(Level.INFO, () -> String.format("User-Agent: %s", userAgent));
		
		if (userAgent.contains("windows"))
		{
			this.so = "Windows";
		} else if(userAgent.contains("mac"))
		{
			this.so = "Mac";
		} else if(userAgent.contains("x11") )
		{
			this.so = "Unix";
		} else if(userAgent.contains("android"))
		{
			this.so = "Android";
		} else if(userAgent.contains("iphone"))
		{
			this.so = "IPhone";
		}else{
			this.so = "UnKnown";
		}
	}
	
	public Header(HttpServletRequest request, String channel, String user, String app, String token) {
		super();
		this.deviceId = request.getRemoteHost();
		this.channel = channel;
		this.app = app;
		this.user = user;
		this.token = token;
		String userAgent = request.getHeader("user-agent").toLowerCase();
		log.log(Level.INFO, () -> String.format("User-Agent: %s", userAgent));
		
		if (userAgent.contains("windows"))
		{
			this.so = "Windows";
		} else if(userAgent.contains("mac"))
		{
			this.so = "Mac";
		} else if(userAgent.contains("x11") )
		{
			this.so = "Unix";
		} else if(userAgent.contains("android"))
		{
			this.so = "Android";
		} else if(userAgent.contains("iphone"))
		{
			this.so = "IPhone";
		}else{
			this.so = "UnKnown";
		}
	}
	
	public Map<String, String> getHeaderMap(){
		return (Map.of("app", this.app,
				"channel", this.channel, 
				"deviceId", this.deviceId, 
				"user", this.user, 
				"so", this.so,
				"token", (this.token == null)?"":this.token));
	}
}
