package by.grsu.edu.auction.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "lot_photo")
public class LotPhotoEntity
{
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "lot_id")
	private Long lotId;
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

	public Long getLotId()
	{
		return lotId;
	}

	public void setLotId(Long lotId)
	{
		this.lotId = lotId;
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
