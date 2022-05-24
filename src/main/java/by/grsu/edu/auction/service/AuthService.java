package by.grsu.edu.auction.service;

import by.grsu.edu.auction.model.AuthDto;

public interface AuthService
{
	String authenticate(AuthDto authDto);

	Long getUserIdByToken(String token);

	Boolean isUserAuthorized(String token);
}
