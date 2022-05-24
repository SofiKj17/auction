package by.grsu.edu.auction.dao.impl.internal;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.NoResultException;

import org.springframework.jdbc.core.ResultSetExtractor;

import by.grsu.edu.auction.dao.impl.internal.annotations.DBType;

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
						Object value = rs.getObject(rowInfo.getRowName());
						if (rowInfo.getJavaType().isEnum())
						{
							value = Enum.valueOf(rowInfo.getJavaType(), (String) value);
						}
						rowInfo.getSetter().invoke(resultEntity, value);
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
						Object value = rs.getObject(rowInfo.getRowName());
						if (rowInfo.getJavaType().isEnum())
						{
							value = Enum.valueOf(rowInfo.getJavaType(), (String) value);
						}
						rowInfo.getSetter().invoke(resultEntity, value);
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

	static Object[] extractEntityPropertiesValues(Collection<RowInfo> rowInfos, Object entity)
	{
		return rowInfos.stream().map(info -> {
			try
			{
				Object result = info.getGetter().invoke(entity);
				if (info.getJavaType().isEnum())
				{
					result = result.toString();
				}
				if (info.getDbType() != null)
				{
					result = info.getDbType().getConstructor(info.getJavaType()).newInstance(result);
				}
				return result;
			}
			catch (Exception e)
			{
				throw new RuntimeException(e);
			}
		}).toArray();
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
					RowInfo rowInfo = new RowInfo(column.name(), field.getName(), getter, setter, javaType);
					rowInfos.add(rowInfo);
					Id id = field.getAnnotation(Id.class);
					rowInfo.setIsId(id != null);
					//					Enumerated enumerated = field.getAnnotation(Enumerated.class);
					//					rowInfo.setEnumerated(enumerated != null);
					DBType dbType = field.getAnnotation(DBType.class);
					if (dbType != null)
					{
						rowInfo.setDbType(dbType.value());
					}
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
