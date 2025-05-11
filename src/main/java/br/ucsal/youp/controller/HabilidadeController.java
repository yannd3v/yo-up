package br.ucsal.youp.controller;


import br.ucsal.youp.dto.FuncionarioDTO;
import br.ucsal.youp.dto.HabilidadeDTO;
import br.ucsal.youp.model.Cargo;
import br.ucsal.youp.model.Funcionario;
import br.ucsal.youp.model.Habilidade;
import br.ucsal.youp.service.HabilidadeService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("habilidade")
@Log4j2
@RequiredArgsConstructor
public class HabilidadeController {


    private final HabilidadeService habilidadeService;

    @GetMapping
    public ResponseEntity<Page<Habilidade>> list(Pageable pageable){
        return ResponseEntity.ok(habilidadeService.listAll(pageable));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Habilidade>> listAll(){
        return ResponseEntity.ok(habilidadeService.listAllNonPageable());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Habilidade> findById(@PathVariable long id){
        return ResponseEntity.ok(habilidadeService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Habilidade>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(habilidadeService.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<Habilidade> save(@RequestBody @Valid HabilidadeDTO habilidadeDTO) {
        return new ResponseEntity<>(habilidadeService.save(habilidadeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        habilidadeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody HabilidadeDTO habilidadeDTO){
        habilidadeService.replace(habilidadeDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
