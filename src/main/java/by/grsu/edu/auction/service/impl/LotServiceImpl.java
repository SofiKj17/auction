package by.grsu.edu.auction.service.impl;

import java.sql.Date;
import java.util.List;

import javax.naming.NoPermissionException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.grsu.edu.auction.dao.LotDao;
import by.grsu.edu.auction.entity.LotEntity;
import by.grsu.edu.auction.entity.LotStatus;
import by.grsu.edu.auction.mapper.LotMapper;
import by.grsu.edu.auction.model.LotDto;
import by.grsu.edu.auction.model.UpdateLotDto;
import by.grsu.edu.auction.service.AuthService;
import by.grsu.edu.auction.service.LotService;

@Service
public class LotServiceImpl implements LotService
{
	private final AuthService authService;
	public final LotMapper lotMapper;
	public final LotDao lotDao;

	@Autowired
	public LotServiceImpl(AuthService authService, LotMapper lotMapper, LotDao lotDao)
	{
		this.authService = authService;
		this.lotMapper = lotMapper;
		this.lotDao = lotDao;
	}

	@Override
	public LotDto createLot(String token, LotDto dto)
	{
		Long ownerId = authService.getUserIdByToken(token);
		LotEntity lotEntity = lotMapper.toEntity(dto);
		lotEntity.setStartDate(new Date(new java.util.Date().getTime()));
		lotEntity.setOwnerId(ownerId);
		lotEntity.setStatus(LotStatus.ACTIVE);
		lotEntity = lotDao.create(lotEntity);
		return lotMapper.toDto(lotEntity);
	}

	@Override
	public List<LotDto> findAllLots()
	{
		return lotMapper.toDtos(lotDao.findAll());
	}

	@Override
	public LotDto updateLot(String token, UpdateLotDto dto)
	{
		Long ownerId = authService.getUserIdByToken(token);
		LotEntity targetLot = lotDao.findById(dto.getId());
		if (!ownerId.equals(targetLot.getOwnerId()))
		{
			throw new RuntimeException(new NoPermissionException());
		}
		lotMapper.toEntity(dto, targetLot);
		lotDao.update(targetLot);
		return lotMapper.toDto(targetLot);
	}

	@Override
	public void deleteById(String token, Long lotId){
		Long ownerId = authService.getUserIdByToken(token);
		LotEntity targetLot = lotDao.findById(lotId);
		if (!ownerId.equals(targetLot.getOwnerId()))
		{
			throw new RuntimeException(new NoPermissionException());
		}
		lotDao.deleteById(lotId);
	}

	@Override
	public List<LotDto> findLotsByUserIdAndHimMaxBet(Long userId)
	{
		return lotMapper.toDtos(lotDao.findLotsByUserIdAndHimMaxBet(userId));
	}
}
