package br.ucsal.youp.mapper;

import br.ucsal.youp.dto.TrilhaCarreiraDTO;
import br.ucsal.youp.model.TrilhaCarreira;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class TrilhaCarreiraMapper {

    public static final TrilhaCarreiraMapper INSTANCE = Mappers.getMapper(TrilhaCarreiraMapper.class);
    public abstract TrilhaCarreira toTrilhaCarreira(TrilhaCarreiraDTO trilhaCarreiraDTO);
}
