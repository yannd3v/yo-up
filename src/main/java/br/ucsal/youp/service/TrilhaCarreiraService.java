package br.ucsal.youp.service;


import br.ucsal.youp.dto.TrilhaCarreiraDTO;
import br.ucsal.youp.exception.BadRequestException;
import br.ucsal.youp.mapper.TrilhaCarreiraMapper;
import br.ucsal.youp.model.Funcionario;
import br.ucsal.youp.model.TrilhaCarreira;
import br.ucsal.youp.repository.FuncionarioRepository;
import br.ucsal.youp.repository.TrilhaCarreiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class TrilhaCarreiraService {

    private final TrilhaCarreiraRepository trilhaCarreiraRepository;
    private final FuncionarioRepository funcionarioRepository;
    private final FuncionarioService funcionarioService;


    public Page<TrilhaCarreira> listAll(Pageable pageable){
        return trilhaCarreiraRepository.findAll(pageable);
    }

    public List<TrilhaCarreira> listAllNonPageable() {
        return trilhaCarreiraRepository.findAll();
    }

    public TrilhaCarreira findByIdPlanoCarreiraOrThrowBadRequestException(long id){

        return trilhaCarreiraRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Plano de carreira não encontrado"));
    }

    @Transactional
    public TrilhaCarreira save(TrilhaCarreiraDTO trilhaCarreiraDTO){
        Funcionario funcionario = funcionarioService.
                findByIdFuncionarioOrThrowBadRequestException(trilhaCarreiraDTO.funcionario_id());
        TrilhaCarreira trilhaCarreira = TrilhaCarreiraMapper.INSTANCE.toTrilhaCarreira(trilhaCarreiraDTO);
        trilhaCarreira.setFuncionario(funcionario);
//        funcionario.setPlanoCarreira(planoCarreira);
//        funcionarioRepository.save(funcionario);
        return trilhaCarreiraRepository.save(trilhaCarreira);
    }

    @Transactional
    public void replace(TrilhaCarreiraDTO trilhaCarreiraDTO) {
        Funcionario funcionario = funcionarioService.
                findByIdFuncionarioOrThrowBadRequestException(trilhaCarreiraDTO.funcionario_id());
        TrilhaCarreira trilhaCarreira = TrilhaCarreiraMapper.INSTANCE.toTrilhaCarreira(trilhaCarreiraDTO);
        trilhaCarreira.setFuncionario(funcionario);
        trilhaCarreiraRepository.save(trilhaCarreira);

    }

    @Transactional
    public void delete(long id) {
        trilhaCarreiraRepository.delete(findByIdPlanoCarreiraOrThrowBadRequestException(id));
    }
}
