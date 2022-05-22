package by.grsu.edu.auction.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import by.grsu.edu.auction.dao.impl.UserDaoImpl;
import by.grsu.edu.auction.entity.UserEntity;

@Controller
@RequestMapping("/test")
public class TestController
{
	@Autowired
	private UserDaoImpl dao;

	@GetMapping
	public void test()
	{
		UserEntity user = dao.findById(1L);
		List<UserEntity> users = dao.findAll();
		System.out.println(user);
	}
}
