package by.grsu.edu.auction.dao.impl;

import org.springframework.stereotype.Repository;

import by.grsu.edu.auction.dao.CategoryDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.CategoryEntity;

@Repository
public class CategoryDaoImpl extends DaoImpl<CategoryEntity, Long> implements CategoryDao
{
	public CategoryDaoImpl()
	{
		super(CategoryEntity.class);
	}
}
