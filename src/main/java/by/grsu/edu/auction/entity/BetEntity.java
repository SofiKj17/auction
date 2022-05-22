package by.grsu.edu.auction.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "bet")
public class BetEntity
{
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "lot_id")
	private Long lotId;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "money")
	private String money;
	@Column(name = "time")
	private Date time;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getLotId()
	{
		return lotId;
	}

	public void setLotId(Long lotId)
	{
		this.lotId = lotId;
	}

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public String getMoney()
	{
		return money;
	}

	public void setMoney(String money)
	{
		this.money = money;
	}

	public Date getTime()
	{
		return time;
	}

	public void setTime(Date time)
	{
		this.time = time;
	}
}
