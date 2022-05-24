package by.grsu.edu.auction.service;

import java.util.List;

import by.grsu.edu.auction.model.LotDto;
import by.grsu.edu.auction.model.UpdateLotDto;

public interface LotService
{
	LotDto createLot(String token, LotDto dto);

	List<LotDto> findAllLots();

	LotDto updateLot(String token, UpdateLotDto dto);

	void deleteById(String token, Long lotId);

	List<LotDto> findLotsByUserIdAndHimMaxBet(Long userId);
}
