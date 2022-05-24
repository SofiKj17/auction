package by.grsu.edu.auction.dao.impl.internal;

import java.lang.reflect.Method;

class RowInfo
{
	private String rowName;
	private String propertyName;
	private Method getter;
	private Method setter;
	private Class<?> javaType;
	private Boolean isId;
	private Boolean enumerated;
	private Class<?> dbType;

	RowInfo(String rowName, String propertyName, Method getter, Method setter, Class<?> javaType)
	{
		this.rowName = rowName;
		this.propertyName = propertyName;
		this.getter = getter;
		this.setter = setter;
		this.javaType = javaType;
	}

	public String getRowName()
	{
		return rowName;
	}

	public void setRowName(String rowName)
	{
		this.rowName = rowName;
	}

	public String getPropertyName()
	{
		return propertyName;
	}

	public void setPropertyName(String propertyName)
	{
		this.propertyName = propertyName;
	}

	public Method getGetter()
	{
		return getter;
	}

	public void setGetter(Method getter)
	{
		this.getter = getter;
	}

	public Method getSetter()
	{
		return setter;
	}

	public void setSetter(Method setter)
	{
		this.setter = setter;
	}

	public Class getJavaType()
	{
		return javaType;
	}

	public void setJavaType(Class<?> javaType)
	{
		this.javaType = javaType;
	}

	public Boolean isId()
	{
		return isId;
	}

	public void setIsId(Boolean id)
	{
		isId = id;
	}

	public Boolean isEnumerated()
	{
		return enumerated;
	}

	public void setEnumerated(Boolean enumerated)
	{
		this.enumerated = enumerated;
	}

	public Class<?> getDbType()
	{
		return dbType;
	}

	public void setDbType(Class<?> dbType)
	{
		this.dbType = dbType;
	}
}
