package fun.spmc.tcg;

import org.h2.tools.Server;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.sql.SQLException;

@SpringBootApplication
public class BackendApplication {

	public static Server server;
	public static void main(String[] args) throws SQLException {
		SpringApplication.run(BackendApplication.class, args);
		server = Server.createTcpServer(args).start();
	}

}
