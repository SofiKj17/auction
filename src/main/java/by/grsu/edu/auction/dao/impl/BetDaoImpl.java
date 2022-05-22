package by.grsu.edu.auction.dao.impl;

import by.grsu.edu.auction.dao.BetDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.BetEntity;

public class BetDaoImpl extends DaoImpl<BetEntity> implements BetDao
{
	public BetDaoImpl()
	{
		super(BetEntity.class);
	}
}
