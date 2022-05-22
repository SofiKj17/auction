package by.grsu.edu.auction.dao.impl;

import by.grsu.edu.auction.dao.LotPhotoDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.LotPhotoEntity;

public class LotPhotoDaoImpl extends DaoImpl<LotPhotoEntity> implements LotPhotoDao
{
	public LotPhotoDaoImpl()
	{
		super(LotPhotoEntity.class);
	}
}
