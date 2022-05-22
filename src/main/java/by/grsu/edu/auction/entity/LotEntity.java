package by.grsu.edu.auction.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private String startPrice;
	@Column(name = "blits_price")
	private String blitsPrice;
	@Column(name = "start_date")
	private Date startDate;
	@Column(name = "end_date")
	private Date endDate;
	@Column(name = "status")
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

	public String getStartPrice()
	{
		return startPrice;
	}

	public void setStartPrice(String startPrice)
	{
		this.startPrice = startPrice;
	}

	public String getBlitsPrice()
	{
		return blitsPrice;
	}

	public void setBlitsPrice(String blitsPrice)
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
