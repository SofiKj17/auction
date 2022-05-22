package by.grsu.edu.auction.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "user_photo")
public class UserPhotoEntity
{
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "use_id")
	private Long userId;
	@Column(name = "reference")
	private String reference;
	@Column(name = "reference_type")
	private ReferenceType referenceType;

	public Long getId()
	{
		return id;
	}

	public void setId(Long id)
	{
		this.id = id;
	}

	public Long getUserId()
	{
		return userId;
	}

	public void setUserId(Long userId)
	{
		this.userId = userId;
	}

	public String getReference()
	{
		return reference;
	}

	public void setReference(String reference)
	{
		this.reference = reference;
	}

	public ReferenceType getReferenceType()
	{
		return referenceType;
	}

	public void setReferenceType(ReferenceType referenceType)
	{
		this.referenceType = referenceType;
	}
}
