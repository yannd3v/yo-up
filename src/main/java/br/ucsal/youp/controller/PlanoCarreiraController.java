package br.ucsal.youp.controller;

import br.ucsal.youp.dto.FuncionarioDTO;
import br.ucsal.youp.dto.PlanoCarreiraDTO;
import br.ucsal.youp.model.Funcionario;
import br.ucsal.youp.model.PlanoCarreira;
import br.ucsal.youp.service.FuncionarioService;
import br.ucsal.youp.service.PlanoCarreiraService;
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
@RequestMapping("planocarreira")
@Log4j2
@RequiredArgsConstructor
public class PlanoCarreiraController {

    private final PlanoCarreiraService planoCarreiraService;


    @GetMapping
    public ResponseEntity<Page<PlanoCarreira>> list(Pageable pageable){
        return ResponseEntity.ok(planoCarreiraService.listAll(pageable));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<PlanoCarreira>> listAll(){
        return ResponseEntity.ok(planoCarreiraService.listAllNonPageable());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<PlanoCarreira> findById(@PathVariable long id){
        return ResponseEntity.ok(planoCarreiraService.findByIdPlanoCarreiraOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<PlanoCarreira> save(@RequestBody @Valid PlanoCarreiraDTO planoCarreiraDTO) {
        return new ResponseEntity<>(planoCarreiraService.save(planoCarreiraDTO), HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        planoCarreiraService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody PlanoCarreiraDTO planoCarreiraDTO){
        planoCarreiraService.replace(planoCarreiraDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}
