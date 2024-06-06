package br.ucsal.youp.service;


import br.ucsal.youp.dto.AddRequisitoRequest;
import br.ucsal.youp.dto.GestorDTO;
import br.ucsal.youp.exception.BadRequestException;
import br.ucsal.youp.mapper.GestorMapper;
import br.ucsal.youp.model.FuncionarioRequisitos;
import br.ucsal.youp.model.Gestor;
import br.ucsal.youp.repository.FuncionarioRepository;
import br.ucsal.youp.repository.FuncionarioRequisitosRepository;
import br.ucsal.youp.repository.GestorRepository;
import br.ucsal.youp.repository.PlanoCarreiraRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class GestorService {
    @Autowired
    private final GestorRepository gestorRepository;

    @Autowired
    private final FuncionarioRequisitosRepository funcionarioRequisitosRepository;

    public Page<Gestor> listAll(Pageable pageable){
        return gestorRepository.findAll(pageable);
    }

    public List<Gestor> listAllNonPageable() {
        return gestorRepository.findAll();
    }

    public List<Gestor> findByNome(String nome){
        return gestorRepository.findByNome(nome);
    }

    public Gestor findByIdOrThrowBadRequestException(long id){

        return gestorRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Gestor não encontrado"));
    }

    @Transactional
    public Gestor save(GestorDTO gestorDTO) {
        return gestorRepository.save(GestorMapper.INSTANCE.toGestor(gestorDTO));
    }

    @Transactional
    public void delete(long id) {
        gestorRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    @Transactional
    public void replace(GestorDTO gestorDTO) {
//        Gestor savedGestor = findByIdOrThrowBadRequestException(gestorDTO.id());
        Gestor gestor = GestorMapper.INSTANCE.toGestor(gestorDTO);
        gestorRepository.save(gestor);

    }

    public List<String> addRequisito(FuncionarioRequisitos requisito) {
        System.out.println(requisito);
        funcionarioRequisitosRepository.save(requisito);
        return funcionarioRequisitosRepository.findFuncionarioRequisitosByFuncionario_id(requisito.getFuncionario().getId());
    }
}
