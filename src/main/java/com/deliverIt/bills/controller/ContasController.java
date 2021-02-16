package com.deliverIt.bills.controller;

import com.deliverIt.bills.dto.ContasDTO;
import com.deliverIt.bills.model.Contas;
import com.deliverIt.bills.service.ContasService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@Api(value = "Contas")
public class ContasController {

    final ContasService contasService;

    @Autowired
    ContasController(ContasService contasService) {
        this.contasService = contasService;
    }

    @ApiOperation(value = "Adiciona uma nova conta")
    @PostMapping("/contas")
    void addContas(@RequestBody Contas newConta) {
        contasService.save(newConta);
    }

    @ApiOperation(value = "Retorna todas as contas com o mesmo nome")
    @GetMapping(path = {"/contas/{nome}"})
    public List<ContasDTO> findByNome(@PathVariable String nome) {
        return contasService.findByNome(nome);
    }

    @ApiOperation(value = "Retorna todas as contas do banco")
    @GetMapping(value = "/contas")
    public List<ContasDTO> getAll() {
        return contasService.findAll();
    }

    @ApiOperation(value = "Apaga todas as contas do banco (usar com cuidado)")
     @DeleteMapping("/contas")
    void deleteContas() {
        contasService.deleteAll();
    }

    @ApiOperation(value = "Apaga todas as contas com o mesmo nome")
    @DeleteMapping("/contas/{nome}")
    void deleteContasByNome(@PathVariable String nome) {
        contasService.delete(nome);
    }

}
