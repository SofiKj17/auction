package by.grsu.edu.auction.service.impl;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import by.grsu.edu.auction.dao.UserDao;
import by.grsu.edu.auction.entity.UserEntity;
import by.grsu.edu.auction.model.AuthDto;
import by.grsu.edu.auction.service.AuthService;

@Service
public class AuthServiceImpl implements AuthService
{
	private final Map<String, Long> authenticatedUsersIds;
	private final UserDao userDao;

	@Autowired
	public AuthServiceImpl(UserDao userDao)
	{
		this.userDao = userDao;
		authenticatedUsersIds = new HashMap<>();
		authenticatedUsersIds.put("someID", 1L);
	}

	@Override
	public String authenticate(AuthDto authDto)
	{
		UserEntity entity = userDao.findByEmail(authDto.getEmail());
		if (entity == null)
		{
			throw new RuntimeException("Not found email : " + authDto.getEmail());
		}
		if (!entity.getPasswordHash().equals(authDto.getPassword()))
		{
			throw new RuntimeException("Wrong password");
		}
		String token = generateToken();
		authenticatedUsersIds.put(token, entity.getId());
		return token;
	}

	@Override
	public Long getUserIdByToken(String token)
	{
		return authenticatedUsersIds.get(token);
	}

	@Override
	public Boolean isUserAuthorized(String token)
	{
		return authenticatedUsersIds.containsKey(token);
	}

	private static String generateToken()
	{
		int leftLimit = 97; // letter 'a'
		int rightLimit = 122; // letter 'z'
		int targetStringLength = 43;
		Random random = new Random();

		return random.ints(leftLimit, rightLimit + 1)
			.limit(targetStringLength)
			.collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
			.toString();
	}
}
