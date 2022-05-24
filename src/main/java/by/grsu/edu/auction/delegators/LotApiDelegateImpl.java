package by.grsu.edu.auction.delegators;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.RequestEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import by.grsu.edu.auction.api.LotApiDelegate;
import by.grsu.edu.auction.model.LotDto;
import by.grsu.edu.auction.model.UpdateLotDto;
import by.grsu.edu.auction.service.LotService;

@Service
public class LotApiDelegateImpl implements LotApiDelegate
{
	private final LotService lotService;

	@Autowired
	public LotApiDelegateImpl(LotService lotService)
	{
		this.lotService = lotService;
	}

	@Override
	public ResponseEntity<LotDto> createLot(String customAuthToken, LotDto lotDto)
	{
		return ResponseEntity.ok(lotService.createLot(customAuthToken, lotDto));
	}

	@Override
	public ResponseEntity<List<LotDto>> findAllLots()
	{
		return ResponseEntity.ok(lotService.findAllLots());
	}

	@Override
	public ResponseEntity<LotDto> updateLot(String customAuthToken, UpdateLotDto updateLotDto)
	{
		return ResponseEntity.ok(lotService.updateLot(customAuthToken, updateLotDto));
	}

	@Override
	public ResponseEntity<String> deleteLotById(String customAuthToken, Long lotId)
	{
		lotService.deleteById(customAuthToken, lotId);
		return ResponseEntity.ok().build();
	}

	@Override
	public ResponseEntity<List<LotDto>> findLotsByUserIdAndHimMaxBet(Long userId)
	{
		return ResponseEntity.ok(lotService.findLotsByUserIdAndHimMaxBet(userId));
	}
}
