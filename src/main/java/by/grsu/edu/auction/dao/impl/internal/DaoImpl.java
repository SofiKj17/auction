package by.grsu.edu.auction.dao.impl.internal;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import javax.persistence.Table;
import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.ResultSetExtractor;
import org.springframework.jdbc.core.support.JdbcDaoSupport;

import by.grsu.edu.auction.dao.Dao;

import static by.grsu.edu.auction.dao.impl.internal.DaoImplHelper.buildRowInfos;
import static by.grsu.edu.auction.dao.impl.internal.DaoImplHelper.extractEntityPropertiesValues;

public abstract class DaoImpl<T, ID> extends JdbcDaoSupport implements Dao<T, ID>
{
	private static final String SELECT_NEXT_ID = "SELECT nextval('id_auto_increment');";
	private static final String INSERT_TEMPLATE = "INSERT INTO %s (%s) VALUES (%s);";
	private static final String SELECT_ALL_TEMPLATE = "SELECT %s FROM %s;";
	private static final String SELECT_BY_ID_TEMPLATE = "SELECT %s FROM %s WHERE %s = ?;";
	private static final String UPDATE_BY_ID_TEMPLATE = "UPDATE %s SET %s WHERE %s = ?;";
	private static final String DELETE_BY_ID_TEMPLATE = "DELETE FROM %s WHERE %s = ?;";

	private final Class<T> clazz;
	private final List<RowInfo> rowInfos;

	private RowInfo idRowInfo;
	private final String insertQuery;
	private final String selectAllQuery;
	private final String selectByIdQuery;
	private final String updateByIdQuery;
	private final String deleteByIdQuery;

	protected final ResultSetExtractor<T> singleResultSetExtractor;
	protected final ResultSetExtractor<List<T>> multipleResultSetExtractor;

	public DaoImpl(Class<T> clazz)
	{
		this.clazz = clazz;
		Table tableAnnotation = clazz.getAnnotation(Table.class);
		String tableName = tableAnnotation.name();
		this.rowInfos = buildRowInfos(clazz);
		String concatedRows = concatRowsNamesViaComma();

		singleResultSetExtractor = DaoImplHelper.buildSingleResultSetExtractor(clazz, rowInfos);
		multipleResultSetExtractor = DaoImplHelper.buildMultipleResultSetExtractor(clazz, rowInfos);

		rowInfos.stream().filter(RowInfo::isId).findFirst().ifPresent(info -> idRowInfo = info);
		this.selectAllQuery = String.format(SELECT_ALL_TEMPLATE, concatedRows, tableName);
		String idRowName = idRowInfo.getRowName();
		String insertParams = rowInfos.stream().map(e -> "?").collect(Collectors.joining(", "));
		this.insertQuery = String.format(INSERT_TEMPLATE, tableName, concatedRows, insertParams);
		this.selectByIdQuery = String.format(SELECT_BY_ID_TEMPLATE, concatedRows, tableName, idRowName);
		this.updateByIdQuery = String.format(UPDATE_BY_ID_TEMPLATE, tableName, concatRowsNamesViEqual(), idRowName);
		this.deleteByIdQuery = String.format(DELETE_BY_ID_TEMPLATE, tableName, idRowName);
	}

	@Override
	public T create(T entity)
	{
		try
		{
			idRowInfo.getSetter().invoke(entity, nexId());
			Object[] values = extractEntityPropertiesValues(rowInfos, entity);
			super.getJdbcTemplate().update(insertQuery, values);
			return entity;
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public T findById(ID id)
	{
		return super.getJdbcTemplate()
			.query(selectByIdQuery, singleResultSetExtractor, id);
	}

	@Override
	public List<T> findAll()
	{
		return super.getJdbcTemplate()
			.query(selectAllQuery, multipleResultSetExtractor);
	}

	@Override
	public int update(T entity)
	{
		try
		{
			List<Object> arguments = Arrays.stream(extractEntityPropertiesValues(rowInfos, entity)).collect(Collectors.toList());
			Object id = idRowInfo.getGetter().invoke(entity);
			arguments.add(id);
			return super.getJdbcTemplate().update(updateByIdQuery, arguments.toArray());
		}
		catch (Exception e)
		{
			throw new RuntimeException(e);
		}
	}

	@Override
	public int deleteById(ID id)
	{
		return super.getJdbcTemplate().update(deleteByIdQuery, id);
	}

	private long nexId()
	{
		return super.getJdbcTemplate().queryForObject(SELECT_NEXT_ID, Long.class);
	}

	private String concatRowsNamesViaComma()
	{
		return rowInfos.stream().map(RowInfo::getRowName).collect(Collectors.joining(", "));
	}

	private String concatRowsNamesViEqual()
	{
		return rowInfos.stream().map(info -> info.getRowName() + " = ?").collect(Collectors.joining(", "));
	}

	@Autowired
	protected void setDataSource1(DataSource dataStorage)
	{
		super.setDataSource(dataStorage);
	}
}
