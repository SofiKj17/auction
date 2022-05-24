package by.grsu.edu.auction.dao;

import java.util.List;

import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.BetEntity;
import by.grsu.edu.auction.entity.LotEntity;
import by.grsu.edu.auction.entity.UserEntity;

public interface LotDao extends Dao<LotEntity, Long>
{
	List<LotEntity> findLotsByUserIdAndHimMaxBet(Long userId);
}
