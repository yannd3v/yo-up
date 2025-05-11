package br.ucsal.youp.controller;


import br.ucsal.youp.dto.CargoDTO;
import br.ucsal.youp.dto.HabilidadeDTO;
import br.ucsal.youp.model.Cargo;
import br.ucsal.youp.model.Habilidade;
import br.ucsal.youp.service.CargoService;
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
@RequestMapping("cargo")
@Log4j2
@RequiredArgsConstructor
public class CargoController {

    private final CargoService cargoService;

    @GetMapping
    public ResponseEntity<Page<Cargo>> list(Pageable pageable){
        return ResponseEntity.ok(cargoService.listAll(pageable));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Cargo>> listAll(){
        return ResponseEntity.ok(cargoService.listAllNonPageable());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Cargo> findById(@PathVariable long id){
        return ResponseEntity.ok(cargoService.findByIdOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Cargo>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(cargoService.findByNome(nome));
    }

    @PostMapping
    public ResponseEntity<Cargo> save(@RequestBody @Valid CargoDTO cargoDTO) {
        return new ResponseEntity<>(cargoService.save(cargoDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        cargoService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody CargoDTO cargoDTO){
        cargoService.replace(cargoDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
