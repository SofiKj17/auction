package by.grsu.edu.auction.dao;

import java.util.List;

public interface Dao<T, ID>
{
	T create(T entity);

	T findById(ID id);

	List<T> findAll();

	int update(T entity);

	int deleteById(ID id);
}
