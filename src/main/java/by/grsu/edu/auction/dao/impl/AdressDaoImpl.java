package by.grsu.edu.auction.dao.impl;

import org.springframework.stereotype.Repository;

import by.grsu.edu.auction.dao.AdressDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.AdressEntity;

@Repository
public class AdressDaoImpl extends DaoImpl<AdressEntity, Long> implements AdressDao
{
	public AdressDaoImpl()
	{
		super(AdressEntity.class);
	}
}
