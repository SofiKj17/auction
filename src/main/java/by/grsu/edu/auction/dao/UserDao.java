package by.grsu.edu.auction.dao;

import by.grsu.edu.auction.entity.UserEntity;

public interface UserDao extends Dao<UserEntity, Long>
{
	UserEntity findByEmail(String email);
}
