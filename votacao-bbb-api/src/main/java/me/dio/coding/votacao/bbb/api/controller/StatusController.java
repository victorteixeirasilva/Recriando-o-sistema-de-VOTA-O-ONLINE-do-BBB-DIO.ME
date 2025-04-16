package me.dio.coding.votacao.bbb.api.controller;


import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@Tag(name = "Status", description = "Responsavel por verificar o status da aplicação.")
@RestController
public class StatusController {

    @Operation(summary = "Verificar Status", description = "Retorna ONLINE caso a api estejá de pé")
    @GetMapping("/api/status")
    public ResponseEntity<String> status(){
        return ResponseEntity.ok("ONLINE");
    }
}
