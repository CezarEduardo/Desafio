package com.backend.financeiro.model.entity;


import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Cliente {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(nullable = false, length = 150)
    private String nome;

    @Column(nullable = false, length = 150)
    private String endereco;

    @Column(nullable = false, length = 11)
    private String cpf;

    @Column(nullable = false, length = 14)
    private String cnpj;

    @Embedded
    private Lancamentos lancamentos;
}

@Embeddable
class Lancamentos {

    @Column(nullable = false, length = 100)
    private Integer parcelas;

    @Column(nullable = false, length = 100)
    private Float valor;

    @Column(name = "data_vencimentos", length = 11)
    @JsonFormat(pattern = "dd/mm/yyyy")
    private LocalDate vencimento;

    @Column(nullable = false,length = 10)
    private String Recebido;

}
