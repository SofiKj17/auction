package by.grsu.edu.auction.dao.impl;

import by.grsu.edu.auction.dao.AdressDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.AdressEntity;

public class AdressDaoImpl extends DaoImpl<AdressEntity> implements AdressDao
{
	public AdressDaoImpl()
	{
		super(AdressEntity.class);
	}
}
