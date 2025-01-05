package fun.spmc.tcg.api;

import fun.spmc.tcg.entity.Player;
import fun.spmc.tcg.repo.PlayerRepository;
import fun.spmc.tcg.service.PlayerService;
import fun.spmc.tcg.util.CookieEncryption;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class PlayerController {
    @Autowired
    private PlayerRepository repository;
    private final PlayerService service;

    public PlayerController(PlayerService service) {
        this.service = service;
    }

    @PostMapping("/acc/register/{username}?{password}")
    public String register(@PathVariable(value = "username") String username, @PathVariable(value = "password") String password) {
        return service.register(username, password);
    }

    @PostMapping("/acc/login/{id}")
    public boolean login(@PathVariable(value = "id") String id) {
        try {
            String username = CookieEncryption.decrypt(id);
            for (Player player: repository.findAll()) {
                if (username.equals(player.getName())) return true;
            }
        } catch (Exception ignored) {}
        return false;
    }

    @PostMapping("/acc/resetpassword")
    public boolean resetPassword() {
        return false;
    }
}
