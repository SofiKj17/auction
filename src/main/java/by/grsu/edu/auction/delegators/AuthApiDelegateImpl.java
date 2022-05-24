package by.grsu.edu.auction.delegators;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import by.grsu.edu.auction.api.AuthApiDelegate;
import by.grsu.edu.auction.model.AuthDto;
import by.grsu.edu.auction.service.AuthService;

@Service
public class AuthApiDelegateImpl implements AuthApiDelegate
{
	private final AuthService authService;

	@Autowired
	public AuthApiDelegateImpl(AuthService authService) {this.authService = authService;}

	@Override
	public ResponseEntity<String> authenticate(AuthDto authDto)
	{
		return ResponseEntity.ok(authService.authenticate(authDto));
	}
}
