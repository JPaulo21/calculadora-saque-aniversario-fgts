package com.jp.calculadora_saque_aniversario_fgts;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;
import org.springframework.data.web.config.EnableSpringDataWebSupport;

import java.net.InetAddress;
import java.net.UnknownHostException;

import static org.springframework.data.web.config.EnableSpringDataWebSupport.PageSerializationMode.VIA_DTO;

@SpringBootApplication
@EnableSpringDataWebSupport(pageSerializationMode = VIA_DTO)
public class CalculadoraSaqueAniversarioFgtsApplication {

	private static final Logger log = LoggerFactory.getLogger(CalculadoraSaqueAniversarioFgtsApplication.class);

	public static void main(String[] args) throws UnknownHostException {
		SpringApplication app = new SpringApplication(CalculadoraSaqueAniversarioFgtsApplication.class);
		Environment env = app.run(args).getEnvironment();

		String info = """
				\n-----------------------------------------------------------------------------------------------------------------------------------------------
				Application {} is running!
				-----------------------------------------------------------------------------------------------------------------------------------------------
					Access URLs:
						Local: \thttp://localhost:{}/{}/api/swagger-ui/index.html#/
						API: \thttp://{}:{}/{}/api
						Docs: \thttp://{}:{}/{}/api/swagger-ui/index.html#/
				-----------------------------------------------------------------------------------------------------------------------------------------------
				""";
		String port = env.getProperty("server.port");
		String appName = env.getProperty("spring.application.name");
		String host = InetAddress.getLocalHost().getHostAddress();
		log.info(info, appName,
				port, appName,
				host, port, appName,
				host, port, appName);
	}

}
