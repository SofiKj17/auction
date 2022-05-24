package by.grsu.edu.auction.mapper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;

import org.mapstruct.Mapper;

import by.grsu.edu.auction.entity.BetEntity;
import by.grsu.edu.auction.model.BetDto;
import by.grsu.edu.auction.model.MakeABetDto;

@Mapper(componentModel = "spring")
public interface BetMapper
{
	BetDto toDto(BetEntity entity);

	BetEntity toEntity(MakeABetDto dto);

	default Date map(String str) throws ParseException
	{
		if (str == null)
		{
			return null;
		}
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss");
		return new Date(sdf.parse(str).getTime());
	}
}
