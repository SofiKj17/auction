package by.grsu.edu.auction.dao.impl;

import org.springframework.stereotype.Repository;

import by.grsu.edu.auction.dao.CommentDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.CommentEntity;

@Repository
public class CommentDaoImpl extends DaoImpl<CommentEntity, Long> implements CommentDao
{
	public CommentDaoImpl()
	{
		super(CommentEntity.class);
	}
}
