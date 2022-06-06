package free_games.free_games_backend.controller;


import free_games.free_games_backend.dto.TradingFloorsDto;
import free_games.free_games_backend.service.TradingFloorsService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.NotBlank;
import java.util.List;

@RestController
@RequestMapping("/trading_floors")
@RequiredArgsConstructor
public class TradingFloorsController {

    private final TradingFloorsService tradingFloorsService;

    @PreAuthorize("hasRole('SUPER_ADMIN')")
    @PostMapping
    public TradingFloorsDto save(@Valid @RequestBody TradingFloorsDto tradingFloorsDto) {
        return tradingFloorsService.save(tradingFloorsDto);
    }

    @GetMapping
    public List<TradingFloorsDto> getAll() {
        return tradingFloorsService.getAll();
    }

    @PatchMapping
    public String changeImage(@RequestBody TradingFloorsDto tradingFloorsDto) {
        return tradingFloorsService.changeImage(tradingFloorsDto);
    }
    /*
    @PatchMapping("/{name}")
    public String changeImage(@PathVariable(name = "name") String tradingFloorName,
                              @NotBlank @RequestBody String newImage) {
        return tradingFloorsService.changeImage(tradingFloorName, newImage);
    }

 */
}
