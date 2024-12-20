package fun.spmc.tcg.api;

import fun.spmc.tcg.backend.database.BackendDatabase;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;

@RestController
public class AccountController {

    public static BackendDatabase database;

    static {
        try {
            database = new BackendDatabase();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
