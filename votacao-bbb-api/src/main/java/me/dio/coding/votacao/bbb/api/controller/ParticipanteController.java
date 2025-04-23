package me.dio.coding.votacao.bbb.api.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import me.dio.coding.votacao.bbb.api.domain.model.ParametroModel;
import me.dio.coding.votacao.bbb.api.domain.model.ParticipanteModel;
import me.dio.coding.votacao.bbb.api.repository.ParticipanteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@Tag(name = "Participantes", description = "Responsavel por Gerenciar os Participantes")
@RestController
@RequestMapping("/api/participantes")
public class ParticipanteController {

    @Autowired
    private ParticipanteRepository repository;

    @Operation(summary = "Salvar participante", description = "Retorna o participante salvo")
    @PostMapping("/salvar")
    public ResponseEntity<ParticipanteModel> salvar(@RequestBody ParticipanteModel participante){
        ParticipanteModel entidade = repository.save(participante);
        return ResponseEntity.ok(entidade);
    }

    @Operation(summary = "Consultar Participante", description = "Retorna o participante consultado caso seja encontrado")
    @GetMapping("/consulta")
    public ResponseEntity consulta(@RequestParam String chave){
        Optional<ParticipanteModel> participanteModel = repository.findById(chave);

        if (participanteModel.isPresent()) {
            return ResponseEntity.ok(participanteModel.get());
        } else {
            return ResponseEntity.status(HttpStatus.NOT_FOUND)
                    .body("Não foi possível encontrar a chave (" + chave + ").");
        }

    }

}
