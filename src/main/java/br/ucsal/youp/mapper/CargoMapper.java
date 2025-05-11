package br.ucsal.youp.mapper;

import br.ucsal.youp.dto.CargoDTO;
import br.ucsal.youp.model.Cargo;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class CargoMapper {

    public static final CargoMapper INSTANCE = Mappers.getMapper(CargoMapper.class);
    public abstract Cargo toCargo(CargoDTO cargoDTO);
}
