package by.grsu.edu.auction.dao.impl;

import org.springframework.stereotype.Repository;

import by.grsu.edu.auction.dao.LotPhotoDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.LotPhotoEntity;

@Repository
public class LotPhotoDaoImpl extends DaoImpl<LotPhotoEntity, Long> implements LotPhotoDao
{
	public LotPhotoDaoImpl()
	{
		super(LotPhotoEntity.class);
	}
}
