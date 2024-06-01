package br.ucsal.youp.mapper;

import br.ucsal.youp.dto.PlanoCarreiraDTO;
import br.ucsal.youp.model.PlanoCarreira;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class PlanoCarreiraMapper {

    public static final PlanoCarreiraMapper INSTANCE = Mappers.getMapper(PlanoCarreiraMapper.class);
    public abstract PlanoCarreira toPlanoCarreira(PlanoCarreiraDTO planoCarreiraDTO);
}
