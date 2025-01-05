package fun.spmc.tcg.service.impl;

import fun.spmc.tcg.entity.Player;
import fun.spmc.tcg.repo.PlayerRepository;
import fun.spmc.tcg.service.PlayerService;
import fun.spmc.tcg.util.CookieEncryption;

import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
public class PlayerServiceImpl implements PlayerService {

    private final PlayerRepository playerRepo;
    private final PasswordEncoder passwordEncoder;

    public PlayerServiceImpl(PlayerRepository playerRepo, PasswordEncoder passwordEncoder) {
        this.playerRepo = playerRepo;
        this.passwordEncoder = passwordEncoder;
    }

    @Override
    public String register(String playerName, String password) {
        for (Player player : playerRepo.findAll()) {
            if (Objects.equals(player.getName(), playerName)) return "";
        }

        try {
            Player player = new Player();
            player.setName(playerName);
            player.setPassword(passwordEncoder.encode(password));
            playerRepo.save(player);
            return CookieEncryption.encrypt(playerName);
        }
        catch (Exception e) {
             return "";
        }
    }

    @Override
    public Player findById(int id) {
        return playerRepo.findById(id);
    }

    @Override
    public List<Player> findAll() {
        return playerRepo.findAll();
    }
}
