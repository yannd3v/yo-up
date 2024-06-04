package br.ucsal.youp.service;

import br.ucsal.youp.dto.FuncionarioDTO;
import br.ucsal.youp.dto.PlanoCarreiraDTO;
import br.ucsal.youp.exception.BadRequestException;
import br.ucsal.youp.mapper.FuncionarioMapper;
import br.ucsal.youp.mapper.PlanoCarreiraMapper;
import br.ucsal.youp.model.Funcionario;
import br.ucsal.youp.model.PlanoCarreira;
import br.ucsal.youp.repository.FuncionarioRepository;
import br.ucsal.youp.repository.PlanoCarreiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class PlanoCarreiraService {

    private final PlanoCarreiraRepository planoCarreiraRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioService funcionarioService;


    public Page<PlanoCarreira> listAll(Pageable pageable){
        return planoCarreiraRepository.findAll(pageable);
    }

    public List<PlanoCarreira> listAllNonPageable() {
        return planoCarreiraRepository.findAll();
    }

    public PlanoCarreira findByIdPlanoCarreiraOrThrowBadRequestException(long id){

        return planoCarreiraRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Plano de carreira não encontrado"));
    }

    @Transactional
    public PlanoCarreira save(PlanoCarreiraDTO planoCarreiraDTO){
        Funcionario funcionario = funcionarioService.
                findByIdFuncionarioOrThrowBadRequestException(planoCarreiraDTO.funcionario_id());
        PlanoCarreira planoCarreira = PlanoCarreiraMapper.INSTANCE.toPlanoCarreira(planoCarreiraDTO);
        planoCarreira.setFuncionario(funcionario);
//        funcionario.setPlanoCarreira(planoCarreira);
//        funcionarioRepository.save(funcionario);
        return planoCarreiraRepository.save(planoCarreira);
    }

    @Transactional
    public void replace(PlanoCarreiraDTO planoCarreiraDTO) {
        Funcionario funcionario = funcionarioService.
                findByIdFuncionarioOrThrowBadRequestException(planoCarreiraDTO.funcionario_id());
        PlanoCarreira planoCarreira = PlanoCarreiraMapper.INSTANCE.toPlanoCarreira(planoCarreiraDTO);
        planoCarreira.setFuncionario(funcionario);
        planoCarreiraRepository.save(planoCarreira);

    }

    @Transactional
    public void delete(long id) {
        planoCarreiraRepository.delete(findByIdPlanoCarreiraOrThrowBadRequestException(id));
    }
}
