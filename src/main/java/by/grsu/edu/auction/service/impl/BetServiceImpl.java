package by.grsu.edu.auction.service.impl;

import java.sql.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.grsu.edu.auction.dao.BetDao;
import by.grsu.edu.auction.entity.BetEntity;
import by.grsu.edu.auction.mapper.BetMapper;
import by.grsu.edu.auction.model.BetDto;
import by.grsu.edu.auction.model.MakeABetDto;
import by.grsu.edu.auction.service.AuthService;
import by.grsu.edu.auction.service.BetService;

@Service
public class BetServiceImpl implements BetService
{
	private final AuthService authService;
	private final BetDao betDao;
	private final BetMapper betMapper;

	@Autowired
	public BetServiceImpl(AuthService authService, BetDao betDao, BetMapper betMapper)
	{
		this.authService = authService;
		this.betDao = betDao;
		this.betMapper = betMapper;
	}

	@Override
	public BetDto makeABet(String token, MakeABetDto dto)
	{
		Long userId = authService.getUserIdByToken(token);
		BetEntity entity = betMapper.toEntity(dto);
		entity.setUserId(userId);
		entity.setTime(new Date(new java.util.Date().getTime()));
		entity = betDao.create(entity);
		return betMapper.toDto(entity);
	}
}
