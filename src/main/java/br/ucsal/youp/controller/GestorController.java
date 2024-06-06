package br.ucsal.youp.controller;

import br.ucsal.youp.dto.AddRequisitoRequest;
import br.ucsal.youp.dto.FuncionarioDTO;
import br.ucsal.youp.dto.GestorDTO;
import br.ucsal.youp.model.FuncionarioRequisitos;
import br.ucsal.youp.model.Gestor;
import br.ucsal.youp.model.PlanoCarreira;
import br.ucsal.youp.service.FuncionarioService;
import br.ucsal.youp.service.GestorService;
import br.ucsal.youp.service.PlanoCarreiraService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("gestores")
@Log4j2
@RequiredArgsConstructor
public class GestorController {

    @Autowired
    private final GestorService gestorService;

    @Autowired
    private final PlanoCarreiraService planoCarreiraService;

    @Autowired
    private final FuncionarioService funcionarioService;


    @GetMapping
    public ResponseEntity<Page<Gestor>> list(Pageable pageable){
        return ResponseEntity.ok(gestorService.listAll(pageable));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Gestor>> listAll(){
        return ResponseEntity.ok(gestorService.listAllNonPageable());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Gestor> findById(@PathVariable long id){
        return ResponseEntity.ok(gestorService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Gestor>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(gestorService.findByNome(nome));
    }

    @GetMapping("/findPlanoCarreiraById/{id}")
    public ResponseEntity<PlanoCarreira> findPlanoCarreiraById(@PathVariable long id){
        return ResponseEntity.ok(planoCarreiraService.findByIdPlanoCarreiraOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<Gestor> save(@RequestBody @Valid GestorDTO gestorDTO) {
        return new ResponseEntity<>(gestorService.save(gestorDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        gestorService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody GestorDTO gestorDTO){
        gestorService.replace(gestorDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PostMapping("/addRequisito")
    public ResponseEntity<List<String>> addRequisito(@RequestBody FuncionarioRequisitos requisito){
        System.out.println(requisito);
        return ResponseEntity.ok(gestorService.addRequisito(requisito));
    }

}