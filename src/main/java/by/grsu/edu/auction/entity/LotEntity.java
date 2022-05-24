package by.grsu.edu.auction.entity;

import java.sql.Date;

import javax.persistence.Column;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.Table;

import org.postgresql.util.PGmoney;

import by.grsu.edu.auction.dao.impl.internal.annotations.DBType;

@Table(name = "lot")
public class LotEntity
{
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "category_id")
	private Long categoryId;
	@Column(name = "owner_id")
	private Long ownerId;
	@Column(name = "name")
	private String name;
	@Column(name = "description")
	private String description;
	@Column(name = "start_price")
	@DBType(PGmoney.class)
	private double startPrice;
	@Column(name = "blits_price")
	@DBType(PGmoney.class)
	private double blitsPrice;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "status")
	@Enumerated
	private LotStatus status;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getCategoryId()
	{
		return categoryId;
	}

	public void setCategoryId(Long categoryId)
	{
		this.categoryId = categoryId;
	}

	public Long getOwnerId()
	{
		return ownerId;
	}

	public void setOwnerId(Long ownerId)
	{
		this.ownerId = ownerId;
	}

	public String getName()
	{
		return name;
	}

	public void setName(String name)
	{
		this.name = name;
	}

	public String getDescription()
	{
		return description;
	}

	public void setDescription(String description)
	{
		this.description = description;
	}

	public double getStartPrice()
	{
		return startPrice;
	}

	public void setStartPrice(double startPrice)
	{
		this.startPrice = startPrice;
	}

	public double getBlitsPrice()
	{
		return blitsPrice;
	}

	public void setBlitsPrice(double blitsPrice)
	{
		this.blitsPrice = blitsPrice;
	}

	public Date getStartDate()
	{
		return startDate;
	}

	public void setStartDate(Date startDate)
	{
		this.startDate = startDate;
	}

	public Date getEndDate()
	{
		return endDate;
	}

	public void setEndDate(Date endDate)
	{
		this.endDate = endDate;
	}

	public LotStatus getStatus()
	{
		return status;
	}

	public void setStatus(LotStatus status)
	{
		this.status = status;
	}
}
