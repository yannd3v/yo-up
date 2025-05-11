package br.ucsal.youp.controller;

import br.ucsal.youp.dto.FuncionarioDTO;
import br.ucsal.youp.model.Funcionario;
import br.ucsal.youp.service.FuncionarioService;
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
@RequestMapping("funcionarios")
@Log4j2
@RequiredArgsConstructor
public class FuncionarioController {

    private final FuncionarioService funcionarioService;


    @GetMapping
    public ResponseEntity<Page<Funcionario>> list(Pageable pageable){
        return ResponseEntity.ok(funcionarioService.listAll(pageable));
    }

    @GetMapping(path = "/all")
    public ResponseEntity<List<Funcionario>> listAll(){
        return ResponseEntity.ok(funcionarioService.listAllNonPageable());
    }

    @GetMapping(path = "/{id}")
    public ResponseEntity<Funcionario> findById(@PathVariable long id){
        return ResponseEntity.ok(funcionarioService.findByIdFuncionarioOrThrowBadRequestException(id));
    }

    @GetMapping(path = "/find")
    public ResponseEntity<List<Funcionario>> findByNome(@RequestParam String nome){
        return ResponseEntity.ok(funcionarioService.findByNome(nome));
    }


    @PostMapping
    public ResponseEntity<Funcionario> save(@RequestBody @Valid FuncionarioDTO funcionarioDTO) {
        return new ResponseEntity<>(funcionarioService.save(funcionarioDTO), HttpStatus.CREATED);
    }

    @PostMapping("/login")
    public ResponseEntity<Funcionario> login(@RequestBody FuncionarioDTO loginRequest) {
        Funcionario funcionario = funcionarioService.findByEmailAndSenha(loginRequest.email(), loginRequest.senha());
        if (funcionario != null) {
            return ResponseEntity.ok(funcionario);
        } else {
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable long id){
        funcionarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @PutMapping
    public ResponseEntity<Void> replace(@RequestBody FuncionarioDTO funcionarioDTO){
        funcionarioService.replace(funcionarioDTO);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

}