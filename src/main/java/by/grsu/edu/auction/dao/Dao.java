package by.grsu.edu.auction.dao;

import java.util.List;

public interface Dao<T>
{
	T findById(Long id);

	List<T> findAll();
}
