package br.ucsal.youp.service;

import br.ucsal.youp.dto.HabilidadeDTO;
import br.ucsal.youp.exception.BadRequestException;
import br.ucsal.youp.mapper.HabilidadeMapper;
import br.ucsal.youp.model.Habilidade;
import br.ucsal.youp.repository.HabilidadeRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class HabilidadeService {

    private final HabilidadeRepository habilidadeRepository;

    public Page<Habilidade> listAll(Pageable pageable){
        return habilidadeRepository.findAll(pageable);
    }

    public List<Habilidade> listAllNonPageable() {
        return habilidadeRepository.findAll();
    }

    public List<Habilidade> findByNome(String nome){
        return habilidadeRepository.findByNome(nome);
    }

    public Habilidade findByIdOrThrowBadRequestException(long id){

        return habilidadeRepository.findById(id)
                .orElseThrow(() -> new BadRequestException("Gestor não encontrado"));
    }

    @Transactional
    public Habilidade save(HabilidadeDTO habilidadeDTO) {
        Habilidade habilidade = HabilidadeMapper.INSTANCE.toHabilidade(habilidadeDTO);
        return habilidadeRepository.save(habilidade);
    }

    @Transactional
    public void delete(long id) {
        habilidadeRepository.delete(findByIdOrThrowBadRequestException(id));
    }

    @Transactional
    public void replace(HabilidadeDTO habilidadeDTO) {
        Habilidade habilidade = HabilidadeMapper.INSTANCE.toHabilidade(habilidadeDTO);
        habilidadeRepository.save(habilidade);

    }
}
