package com.deliverIt.bills.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ContasDTO {

    private String nome;

    private double valorOriginal;

    private Date dataVencimento;

    private Date dataPagamento;

    private Double valorCorrigido;

    private Long quantidadeDiasAtraso;

}

