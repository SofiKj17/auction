package by.grsu.edu.auction.dao.impl;

import org.springframework.stereotype.Repository;

import by.grsu.edu.auction.dao.UserDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.UserEntity;

@Repository
public class UserDaoImpl extends DaoImpl<UserEntity, Long> implements UserDao
{
	private static final String SELECT_BY_EMAIL = "SELECT * FROM \"user\" WHERE email = ?;";

	public UserDaoImpl()
	{
		super(UserEntity.class);
	}

	@Override
	public UserEntity findByEmail(String email)
	{
		return super.getJdbcTemplate().query(SELECT_BY_EMAIL, singleResultSetExtractor, email);
	}
}
