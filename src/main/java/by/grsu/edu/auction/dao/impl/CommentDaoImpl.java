package by.grsu.edu.auction.dao.impl;

import by.grsu.edu.auction.dao.CommentDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.CommentEntity;

public class CommentDaoImpl extends DaoImpl<CommentEntity> implements CommentDao
{
	public CommentDaoImpl()
	{
		super(CommentEntity.class);
	}
}
