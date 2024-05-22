package br.ucsal.youp.mapper;

import br.ucsal.youp.dto.GestorDTO;
import br.ucsal.youp.model.Gestor;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class GestorMapper {

    public static final GestorMapper INSTANCE = Mappers.getMapper(GestorMapper.class);
    public abstract Gestor toGestor(GestorDTO gestorDTO);
}
