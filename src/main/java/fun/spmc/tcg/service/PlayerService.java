package fun.spmc.tcg.service;

import fun.spmc.tcg.entity.Player;

import java.util.List;

public interface PlayerService {
    String register(String playerName, String password);
    Player findById(int id);
    List<Player> findAll();
}
