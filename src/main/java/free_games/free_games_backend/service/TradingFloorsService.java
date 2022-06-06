package free_games.free_games_backend.service;

import free_games.free_games_backend.converter.TradingFloorsConverter;
import free_games.free_games_backend.dto.TradingFloorsDto;
import free_games.free_games_backend.exception.TradingFloorExistsException;
import free_games.free_games_backend.exception.TradingFloorNotExistsException;
import free_games.free_games_backend.repository.TradingFloorsRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Service
public class TradingFloorsService {
    private final TradingFloorsRepository tradingFloorsRepository;
    private final TradingFloorsConverter converter;

    @Autowired
    public TradingFloorsService(TradingFloorsRepository tradingFloorsRepository,
                                TradingFloorsConverter converter) {
        this.tradingFloorsRepository = tradingFloorsRepository;
        this.converter = converter;
    }

    @Transactional
    public TradingFloorsDto save(TradingFloorsDto tradingFloorsDto) {
        if (tradingFloorsRepository.findById(tradingFloorsDto.getName()).isPresent()) {
            throw new TradingFloorExistsException("Торговая площадка уже существует");
        }
        return converter.toDto(tradingFloorsRepository.save(converter.toEntity(tradingFloorsDto)));
    }

    @Transactional(readOnly = true)
    public List<TradingFloorsDto> getAll() {
        return StreamSupport
                .stream(tradingFloorsRepository.findAll().spliterator(), false)
                .map(converter::toDto)
                .collect(Collectors.toList());
    }

    @Transactional
    public String changeImage(TradingFloorsDto tradingFloorsDto) {
        var entity = tradingFloorsRepository.findById(tradingFloorsDto.getName())
                .orElseThrow(() -> new TradingFloorNotExistsException("Торговой площадки не существует"));
        entity.setImg(tradingFloorsDto.getImg());
        return "success";
    }
}
