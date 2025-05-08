package br.ucsal.youp.controller;


import br.ucsal.youp.dto.TrilhaCarreiraDTO;
import br.ucsal.youp.model.TrilhaCarreira;
import br.ucsal.youp.service.TrilhaCarreiraService;
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
@RequestMapping("trilhacarreira")
@Log4j2
@RequiredArgsConstructor
public class TrilhaCarreiraController {

    private final TrilhaCarreiraService trilhaCarreiraService;


    @GetMapping
    public ResponseEntity<Page<TrilhaCarreira>> list(Pageable pageable){
        return ResponseEntity.ok(trilhaCarreiraService.listAll(pageable));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<TrilhaCarreira>> listAll(){
        return ResponseEntity.ok(trilhaCarreiraService.listAllNonPageable());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<TrilhaCarreira> findById(@PathVariable long id){
        return ResponseEntity.ok(trilhaCarreiraService.findByIdPlanoCarreiraOrThrowBadRequestException(id));
    }

    @PostMapping
    public ResponseEntity<TrilhaCarreira> save(@RequestBody @Valid TrilhaCarreiraDTO trilhaCarreiraDTO) {
        return new ResponseEntity<>(trilhaCarreiraService.save(trilhaCarreiraDTO), HttpStatus.CREATED);
    }


    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        trilhaCarreiraService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody TrilhaCarreiraDTO trilhaCarreiraDTO){
        trilhaCarreiraService.replace(trilhaCarreiraDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}