package free_games.free_games_backend.converter;

import free_games.free_games_backend.dto.TradingFloorsDto;
import free_games.free_games_backend.dto.UserDto;
import free_games.free_games_backend.entity.TradingFloorsEntity;
import free_games.free_games_backend.entity.UserEntity;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Objects;

@Component
public class TradingFloorsConverter {

    private ModelMapper mapper;

    @Autowired
    public TradingFloorsConverter(ModelMapper mapper) {
        this.mapper = mapper;
    }

    @PostConstruct
    public void setupMapper() {
        mapper.createTypeMap(TradingFloorsDto.class, TradingFloorsEntity.class);
    }

    public TradingFloorsEntity toEntity(TradingFloorsDto tradingFloorsDto) {
        return Objects.isNull(tradingFloorsDto) ? null : mapper.map(tradingFloorsDto, TradingFloorsEntity.class);
    }

    public TradingFloorsDto toDto(TradingFloorsEntity entity) {
        return Objects.isNull(entity) ? null : mapper.map(entity, TradingFloorsDto.class);
    }

}
