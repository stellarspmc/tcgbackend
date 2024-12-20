package fun.spmc.tcg.backend.entity;

import lombok.Builder;
import lombok.Data;

@Data
@Builder
public class Account {
    private String id;
    private String name;
    private String password;

}
