package br.ucsal.youp.mapper;


import br.ucsal.youp.dto.FuncionarioDTO;
import br.ucsal.youp.dto.HabilidadeDTO;
import br.ucsal.youp.model.Funcionario;
import br.ucsal.youp.model.Habilidade;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public abstract class HabilidadeMapper {

    public static final HabilidadeMapper INSTANCE = Mappers.getMapper(HabilidadeMapper.class);
    public abstract Habilidade toHabilidade(HabilidadeDTO habilidadeDTO);

}
