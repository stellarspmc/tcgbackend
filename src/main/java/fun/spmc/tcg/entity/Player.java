package fun.spmc.tcg.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data
@Entity
public class Player {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public int id;
    public String name;
    public int level;
    public float xp;
    public String password;
    public long created;
    public boolean flagged;

    public static void levelUp(Player player) {
        if (player.xp >= 1) {
            player.xp -= 1;
            player.level++;
        }
    }
}
