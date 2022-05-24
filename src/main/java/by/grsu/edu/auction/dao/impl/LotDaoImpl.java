package by.grsu.edu.auction.dao.impl;

import java.util.List;

import org.springframework.stereotype.Repository;

import by.grsu.edu.auction.dao.LotDao;
import by.grsu.edu.auction.dao.impl.internal.DaoImpl;
import by.grsu.edu.auction.entity.LotEntity;

@Repository
public class LotDaoImpl extends DaoImpl<LotEntity, Long> implements LotDao
{
	private static final String SELECT_LOTS_BY_USER_ID_WITH_HIM_MAX_BET =
			"select " +
			" * " +
			"from " +
			" lot l " +
			"where " +
			" l.id in ( " +
			" select " +
			"  b.lot_id " +
			" from " +
			"  bet b " +
			" join \"user\" u on " +
			"  u.id = b.user_id  " +
			" group by " +
			"  u.id,  " +
			"  lot_id  " +
			" having u.id = ? " +
			");";

	public LotDaoImpl()
	{
		super(LotEntity.class);
	}

	@Override
	public List<LotEntity> findLotsByUserIdAndHimMaxBet(Long userId)
	{
		return super.getJdbcTemplate()
			.query(SELECT_LOTS_BY_USER_ID_WITH_HIM_MAX_BET, multipleResultSetExtractor, userId);
	}
}
