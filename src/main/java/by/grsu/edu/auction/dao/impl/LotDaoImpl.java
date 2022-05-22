package by.grsu.edu.auction.dao.impl;

import by.grsu.edu.auction.dao.LotDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.LotEntity;

public class LotDaoImpl extends DaoImpl<LotEntity> implements LotDao
{
	public LotDaoImpl()
	{
		super(LotEntity.class);
	}
}
