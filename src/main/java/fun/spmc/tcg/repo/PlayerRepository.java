package fun.spmc.tcg.repo;

import fun.spmc.tcg.entity.Player;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PlayerRepository extends CrudRepository<Player, Integer> {

    Player findById(int id);
    List<Player> findAll();
    void deleteById(int id);
}