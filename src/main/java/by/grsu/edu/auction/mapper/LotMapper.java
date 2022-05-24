package by.grsu.edu.auction.mapper;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.NullValuePropertyMappingStrategy;

import by.grsu.edu.auction.entity.LotEntity;
import by.grsu.edu.auction.model.LotDto;
import by.grsu.edu.auction.model.UpdateLotDto;

@Mapper(componentModel = "spring")
public interface LotMapper
{
	LotDto toDto(LotEntity entity);

	List<LotDto> toDtos(List<LotEntity> entities);

	LotEntity toEntity(LotDto dto);

	List<LotEntity> toEntity(List<LotDto> dto);

	void toEntity(UpdateLotDto dto, @MappingTarget LotEntity entity);

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
