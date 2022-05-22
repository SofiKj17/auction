package by.grsu.edu.auction.entity;

import javax.persistence.Column;
import javax.persistence.Id;
import javax.persistence.Table;

@Table(name = "comment")
public class CommentEntity
{
	@Id
	@Column(name = "id")
	private Long id;
	@Column(name = "lot_id")
	private Long lotId;
	@Column(name = "user_id")
	private Long userId;
	@Column(name = "comment_id")
	private Long commentId;
	@Column(name = "text")
	private String text;

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

	public Long getCommentId()
	{
		return commentId;
	}

	public void setCommentId(Long commentId)
	{
		this.commentId = commentId;
	}

	public String getText()
	{
		return text;
	}

	public void setText(String text)
	{
		this.text = text;
	}
}
