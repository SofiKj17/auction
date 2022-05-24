package by.grsu.edu.auction.delegators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import by.grsu.edu.auction.api.BetApiDelegate;
import by.grsu.edu.auction.model.BetDto;
import by.grsu.edu.auction.model.MakeABetDto;
import by.grsu.edu.auction.service.BetService;

@Service
public class BetApiDelegateImpl implements BetApiDelegate
{
	private final BetService betService;

	@Autowired
	public BetApiDelegateImpl(BetService betService) {this.betService = betService;}

	@Override
	public ResponseEntity<BetDto> makeABet(String customAuthToken, MakeABetDto makeABetDto)
	{
		return ResponseEntity.ok(betService.makeABet(customAuthToken, makeABetDto));
	}
}
