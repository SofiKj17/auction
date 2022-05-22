package by.grsu.edu.auction.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "adress")
public class AdressEntity
{
	@Id
	@Column(name = "id")
	protected Long id;
	@Column(name = "country")
	private String countryName;
	@Column(name = "city")
	private String cityName;
	@Column(name = "post_code")
	private String postCode;
	@Column(name = "street_name")
	private String streetName;
	@Column(name = "house_number")
	private String houseNumber;
	@Column(name = "flat_number")
	private String flatNumber;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public String getCountryName()
	{
		return countryName;
	}

	public void setCountryName(String countryName)
	{
		this.countryName = countryName;
	}

	public String getCityName()
	{
		return cityName;
	}

	public void setCityName(String cityName)
	{
		this.cityName = cityName;
	}

	public String getPostCode()
	{
		return postCode;
	}

	public void setPostCode(String postCode)
	{
		this.postCode = postCode;
	}

	public String getStreetName()
	{
		return streetName;
	}

	public void setStreetName(String streetName)
	{
		this.streetName = streetName;
	}

	public String getHouseNumber()
	{
		return houseNumber;
	}

	public void setHouseNumber(String houseNumber)
	{
		this.houseNumber = houseNumber;
	}

	public String getFlatNumber()
	{
		return flatNumber;
	}

	public void setFlatNumber(String flatNumber)
	{
		this.flatNumber = flatNumber;
	}
}
