package me.dio.coding.votacao.bbb.api.domain.model;

import lombok.*;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Document
public class ParametroModel {

    @Id
    private String chave;
    private String valor;

}
