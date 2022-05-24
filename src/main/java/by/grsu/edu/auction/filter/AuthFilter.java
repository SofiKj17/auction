package by.grsu.edu.auction.filter;

import java.io.IOException;

import javax.security.sasl.AuthenticationException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import org.apache.catalina.connector.RequestFacade;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import by.grsu.edu.auction.service.AuthService;

@Component
public class AuthFilter implements Filter
{
	private static final String CUSTOM_AUTH_TOKEN_HEADER_NAME = "custom-auth-token";

	private final AuthService authService;

	@Autowired
	public AuthFilter(AuthService authService) {this.authService = authService;}

	@Override
	public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
		throws IOException, ServletException
	{
		RequestFacade requestFacade = (RequestFacade) servletRequest;
		String uri = requestFacade.getRequestURI();
		if (!uri.equals("/auth"))
		{
			String customAuthToken = requestFacade.getHeader(CUSTOM_AUTH_TOKEN_HEADER_NAME);
			if (customAuthToken == null)
			{
				throw new AuthenticationException();
			}
			if (!authService.isUserAuthorized(customAuthToken))
			{
				throw new AuthenticationException();
			}
		}
		filterChain.doFilter(servletRequest, servletResponse);
	}
}
