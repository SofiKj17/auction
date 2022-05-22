package by.grsu.edu.auction.dao.impl;

import by.grsu.edu.auction.dao.UserPhotoDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.UserPhotoEntity;

public class UserPhotoDaoImpl extends DaoImpl<UserPhotoEntity> implements UserPhotoDao
{
	public UserPhotoDaoImpl()
	{
		super(UserPhotoEntity.class);
	}
}
