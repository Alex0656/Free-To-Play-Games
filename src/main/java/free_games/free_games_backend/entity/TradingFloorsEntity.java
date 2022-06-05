package free_games.free_games_backend.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.BitSet;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
@Table(name = "trading_floors")
public class TradingFloorsEntity {

    @Id
    @Column
    private String name;

    @Column
    private BitSet img;
}



