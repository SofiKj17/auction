package by.grsu.edu.auction.dao.impl.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.NoResultException;

import org.springframework.jdbc.core.ResultSetExtractor;

class DaoImplHelper
{
	static <T> ResultSetExtractor<T> buildSingleResultSetExtractor(Class<T> clazz, List<RowInfo> rowInfos)
	{
		return rs -> {
			if (rs.next())
			{
				try
				{
					T resultEntity = clazz.newInstance();
					for (RowInfo rowInfo : rowInfos)
					{
						rowInfo.getSetter().invoke(resultEntity, rs.getObject(rowInfo.getRowName(), rowInfo.getJavaType()));
					}
					return resultEntity;
				}
				catch (Exception e)
				{
					throw new RuntimeException(e);
				}
			}
			throw new NoResultException();
		};
	}

	static <T> ResultSetExtractor<List<T>> buildMultipleResultSetExtractor(Class<T> clazz, List<RowInfo> rowInfos)
	{
		return rs -> {
			List<T> result = new LinkedList<>();
			while (rs.next())
			{
				try
				{
					T resultEntity = clazz.newInstance();
					for (RowInfo rowInfo : rowInfos)
					{
						rowInfo.getSetter().invoke(resultEntity, rs.getObject(rowInfo.getRowName(), rowInfo.getJavaType()));
					}
					result.add(resultEntity);
				}
				catch (Exception e)
				{
					throw new RuntimeException(e);
				}
			}
			return result;
		};
	}

	static List<RowInfo> buildRowInfos(Class<?> clazz)
	{
		List<RowInfo> rowInfos = new LinkedList<>();
		for (Field field : clazz.getDeclaredFields())
		{
			Column column = field.getAnnotation(Column.class);
			if (column != null)
			{
				try
				{
					String fieldName = field.getName();
					Class<?> javaType = field.getType();
					Method getter = clazz.getMethod(buildGetterName(fieldName));
					Method setter = clazz.getMethod(buildSetterName(fieldName), javaType);
					rowInfos.add(new RowInfo(column.name(), field.getName(), getter, setter, javaType));
				}
				catch (NoSuchMethodException e)
				{
					throw new RuntimeException(e);
				}
			}
		}
		return rowInfos;
	}

	private static String buildSetterName(String fieldName)
	{
		char[] chars = fieldName.toCharArray();
		char firstChar = Character.toUpperCase(chars[0]);
		chars[0] = firstChar;
		return "set" + new String(chars);
	}

	private static String buildGetterName(String fieldName)
	{
		char[] chars = fieldName.toCharArray();
		char firstChar = Character.toUpperCase(chars[0]);
		chars[0] = firstChar;
		return "get" + new String(chars);
	}
}
