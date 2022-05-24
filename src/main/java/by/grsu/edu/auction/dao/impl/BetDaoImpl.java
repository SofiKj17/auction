package by.grsu.edu.auction.dao.impl;

import org.springframework.stereotype.Repository;

import by.grsu.edu.auction.dao.BetDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.BetEntity;

@Repository
public class BetDaoImpl extends DaoImpl<BetEntity, Long> implements BetDao
{
	public BetDaoImpl()
	{
		super(BetEntity.class);
	}
}
