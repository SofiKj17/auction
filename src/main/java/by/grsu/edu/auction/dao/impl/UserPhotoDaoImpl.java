package by.grsu.edu.auction.dao.impl;

import org.springframework.stereotype.Repository;

import by.grsu.edu.auction.dao.UserPhotoDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.UserPhotoEntity;

@Repository
public class UserPhotoDaoImpl extends DaoImpl<UserPhotoEntity, Long> implements UserPhotoDao
{
	public UserPhotoDaoImpl()
	{
		super(UserPhotoEntity.class);
	}
}
