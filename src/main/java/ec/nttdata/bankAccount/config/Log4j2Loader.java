package ec.nttdata.bankAccount.config;

import java.io.File;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.logging.log4j.core.LoggerContext;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class Log4j2Loader {
	
	@Value("${path.log4j}")
	private String log4j2DirectoryFile;
	
	static final Logger logger = LogManager.getLogger(Log4j2Loader.class.getName());

	@Bean
	public String init(){	
		String loggerConfig = log4j2DirectoryFile;
		LoggerContext context = LoggerContext.getContext(false);
		File file = new File(loggerConfig);
		logger.info("Loading configuration log4j2..");
		context.setConfigLocation(file.toURI());
		logger.info("Loaded configuration log4j2 succesfully");
		return "OK";
	}
}
