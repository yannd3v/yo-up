package br.ucsal.youp.service;

import br.ucsal.youp.dto.FuncionarioDTO;
import br.ucsal.youp.exception.BadRequestException;
import br.ucsal.youp.mapper.FuncionarioMapper;
import br.ucsal.youp.model.Funcionario;
import br.ucsal.youp.repository.FuncionarioRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class FuncionarioService {

    private final FuncionarioRepository funcionarioRepository;

    public Page<Funcionario> listAll(Pageable pageable){
        return funcionarioRepository.findAll(pageable);
    }

    public List<Funcionario> listAllNonPageable() {
        return funcionarioRepository.findAll();
    }

    public List<Funcionario> findByNome(String nome){
        return funcionarioRepository.findByNome(nome);
    }

    public Funcionario findByIdOrThrowBadRequestException(long id){

        return funcionarioRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Funcionário não encontrado"));
    }

    @Transactional
    public Funcionario save(FuncionarioDTO funcionarioDTO) {
        return funcionarioRepository.save(FuncionarioMapper.INSTANCE.toFuncionario(funcionarioDTO));
    }

    @Transactional
    public void delete(long id) {
        funcionarioRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    @Transactional
    public void replace(FuncionarioDTO funcionarioDTO) {
        Funcionario savedFuncionario = findByIdOrThrowBadRequestException(funcionarioDTO.id());
        Funcionario funcionario = FuncionarioMapper.INSTANCE.toFuncionario(funcionarioDTO);
        funcionarioRepository.save(funcionario);

    }

}
