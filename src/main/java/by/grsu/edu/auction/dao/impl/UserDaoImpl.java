package by.grsu.edu.auction.dao.impl;

import org.springframework.stereotype.Repository;

import by.grsu.edu.auction.dao.UserDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.UserEntity;

@Repository
public class UserDaoImpl extends DaoImpl<UserEntity> implements UserDao
{
	public UserDaoImpl()
	{
		super(UserEntity.class);
	}
}
