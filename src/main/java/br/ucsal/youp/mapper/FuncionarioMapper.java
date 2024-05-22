package br.ucsal.youp.mapper;

import br.ucsal.youp.dto.FuncionarioDTO;
import br.ucsal.youp.model.Funcionario;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class FuncionarioMapper {

    public static final FuncionarioMapper INSTANCE = Mappers.getMapper(FuncionarioMapper.class);
    public abstract Funcionario toFuncionario(FuncionarioDTO animeDTO);
}
