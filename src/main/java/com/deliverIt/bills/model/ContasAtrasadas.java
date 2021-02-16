package com.deliverIt.bills.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

/**
 * @author Andrei Lima
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "ContasAtrasadas")
@XmlRootElement
public class ContasAtrasadas implements Serializable {

    private static final long serialVersionUID = 1L;

    @Column(name = "ValorCorrigido")
    private Double valorCorrigido;

    @Column(name = "QuantidadeDiasAtraso")
    private Long quantidadeDiasAtraso;

    @Id
    @Basic(optional = false)
    @Column(name = "KeyContas")
    private Long keyContas;

    @JoinColumn(name = "KeyContas", referencedColumnName = "KeyContas", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Contas contas;

}
