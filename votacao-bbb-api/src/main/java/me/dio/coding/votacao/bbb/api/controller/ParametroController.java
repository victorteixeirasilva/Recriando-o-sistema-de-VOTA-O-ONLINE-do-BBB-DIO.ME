package me.dio.coding.votacao.bbb.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.coding.votacao.bbb.api.domain.model.ParametroModel;
import me.dio.coding.votacao.bbb.api.repository.ParametroRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.crossstore.ChangeSetPersister;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.HttpClientErrorException;

import java.util.Optional;

@Tag(name = "Parametros", description = "Responsavel por Gerenciar Parametros")
@RestController
@RequestMapping("/api/parametros")
public class ParametroController {

    @Autowired
    private ParametroRepository parametroRepository;

    @Operation(summary = "Salvar Parametro", description = "Retorna o parametro salvo")
    @PostMapping("/salvar")
    public ResponseEntity<ParametroModel> salvar(@RequestBody ParametroModel parametroModel){
        ParametroModel entidade = parametroRepository.save(parametroModel);
        return ResponseEntity.ok(entidade);
    }

    @Operation(summary = "Consultar Parametro", description = "Retorna o parametro consultado caso seja encontrado")
    @GetMapping("/consulta")
    public ResponseEntity consulta(@RequestParam String chave){
        Optional<ParametroModel> parametroModel = parametroRepository.findById(chave);

        if (parametroModel.isPresent()) {
            return ResponseEntity.ok(parametroModel.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi possível encontrar a chave (" + chave + ").");
        }

    }

}
