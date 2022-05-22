package by.grsu.edu.auction.dao.impl.internal;

import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Table;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import by.grsu.edu.auction.dao.Dao;

import static by.grsu.edu.auction.dao.impl.internal.DaoImplHelper.buildMultipleResultSetExtractor;
import static by.grsu.edu.auction.dao.impl.internal.DaoImplHelper.buildRowInfos;
import static by.grsu.edu.auction.dao.impl.internal.DaoImplHelper.buildSingleResultSetExtractor;

public abstract class DaoImpl<T> extends JdbcDaoSupport implements Dao<T>
{
	private static final String SELECT_ALL_TEMPLATE = "SELECT %s FROM %s";
	private static final String SELECT_BY_ID_TEMPLATE = "SELECT %s FROM %s WHERE id = ?";

	private final Class<T> clazz;
	private final List<RowInfo> rowInfos;

	private final String selectAllQuery;
	private final String selectByIdQuery;

	public DaoImpl(Class<T> clazz)
	{
		this.clazz = clazz;
		Table tableAnnotation = clazz.getAnnotation(Table.class);
		String tableName = tableAnnotation.name();
		this.rowInfos = buildRowInfos(clazz);
		String concatedRows = concatRowsNames();
		this.selectAllQuery = String.format(SELECT_ALL_TEMPLATE, concatedRows, tableName);
		this.selectByIdQuery = String.format(SELECT_BY_ID_TEMPLATE, concatedRows, tableName);
	}

	@Override
	public T findById(Long id)
	{
		return super.getJdbcTemplate()
			.query(selectByIdQuery, buildSingleResultSetExtractor(clazz, rowInfos), id);
	}

	@Override
	public List<T> findAll()
	{
		return super.getJdbcTemplate()
			.query(selectAllQuery, buildMultipleResultSetExtractor(clazz, rowInfos));
	}

	private String concatRowsNames()
	{
		return rowInfos.stream().map(RowInfo::getRowName).collect(Collectors.joining(", "));
	}

	@Autowired
	protected void setDataSource1(DataSource dataStorage)
	{
		super.setDataSource(dataStorage);
	}
}
