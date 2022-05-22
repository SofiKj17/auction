package by.grsu.edu.auction.dao.impl;

import by.grsu.edu.auction.dao.CategoryDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.CategoryEntity;

public class CategoryDaoImpl extends DaoImpl<CategoryEntity> implements CategoryDao
{
	public CategoryDaoImpl()
	{
		super(CategoryEntity.class);
	}
}
