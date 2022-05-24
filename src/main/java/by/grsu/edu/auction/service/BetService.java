package by.grsu.edu.auction.service;

import by.grsu.edu.auction.model.BetDto;
import by.grsu.edu.auction.model.MakeABetDto;

public interface BetService
{
	BetDto makeABet(String token, MakeABetDto dto);
}
