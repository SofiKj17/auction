package by.grsu.edu.auction.dao.impl.internal;

import java.lang.reflect.Method;

class RowInfo
{
	private String rowName;
	private String propertyName;
	private Method getter;
	private Method setter;
	private Class<?> javaType;

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

	public Class<?> getJavaType()
	{
		return javaType;
	}

	public void setJavaType(Class<?> javaType)
	{
		this.javaType = javaType;
	}
}
