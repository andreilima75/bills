package com.deliverIt.bills.model;

import com.deliverIt.bills.dto.ContasDTO;
import com.deliverIt.bills.util.CustomDateDeserializer;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.modelmapper.ModelMapper;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;
import java.util.Date;

/**
 * @author Andrei Lima
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Contas")
@XmlRootElement
public class Contas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Basic(optional = false)
    @Column(name = "Nome")
    private String nome;

    @Basic(optional = false)
    @Column(name = "ValorOriginal")
    private double valorOriginal;

    @Basic(optional = false)
    @Column(name = "DataVencimento")
    private Date dataVencimento;

    @Basic(optional = false)
    @Column(name = "DataPagamento")
    private Date dataPagamento;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "KeyContas")
    private Long keyContas;

    @OneToOne(cascade = CascadeType.ALL, mappedBy = "contas")
    private ContasAtrasadas contasAtrasadas;

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setDataVencimento(Date dataVencimento) {
        this.dataVencimento = dataVencimento;
    }

    @JsonDeserialize(using = CustomDateDeserializer.class)
    public void setDataPagamento(Date dataPagamento) {
        this.dataPagamento = dataPagamento;
    }

    public ContasDTO convertEntityToDTO() {
        ContasDTO contasDTO = new ModelMapper().map(this, ContasDTO.class);
        if (this.contasAtrasadas != null) {
            contasDTO.setQuantidadeDiasAtraso(this.contasAtrasadas.getQuantidadeDiasAtraso());
            contasDTO.setValorCorrigido(this.contasAtrasadas.getValorCorrigido());
        }
        return contasDTO;

    }
}
