package com.deliverIt.bills.service;

import com.deliverIt.bills.dto.ContasDTO;
import com.deliverIt.bills.model.Contas;
import com.deliverIt.bills.model.ContasAtrasadas;
import com.deliverIt.bills.repository.ContasAtrasadasRepository;
import com.deliverIt.bills.repository.ContasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ContasService {

    @Autowired
    ContasRepository contasRepository;

    @Autowired
    ContasAtrasadasRepository contasAtrasadasRepository;

    public List<ContasDTO> findByNome(String nome) {
        return this.processarContasDTO(contasRepository.findByNome(nome));
    }

    public List<ContasDTO> findAll() {
        return this.processarContasDTO(contasRepository.findAll());
    }


    public void save(Contas contas) {
        contasRepository.save(contas);
        this.verificarMulta(contas);
    }

    public void delete(String nome) {
        List<Contas> contas = contasRepository.findByNome(nome);
        contas.stream().forEach(t -> contasRepository.delete(t));
    }

    public void deleteAll() {
        contasRepository.deleteAll();
    }

    private void verificarMulta(Contas contas) {
        long difference = contas.getDataPagamento().getTime() - contas.getDataVencimento().getTime();
        long daysBetween = Math.abs(difference / (1000 * 60 * 60 * 24));
        Integer multa = 0;
        Double jurosDia = 0.0;

        if (daysBetween > 5) {
            multa = 5;
            jurosDia = 0.3;
        } else if (daysBetween > 3) {
            multa = 3;
            jurosDia = 0.2;
        } else if (daysBetween > 0) {
            multa = 2;
            jurosDia = 0.1;
        }

        if (multa != 0) {
            ContasAtrasadas contasAtrasadas = new ContasAtrasadas();
            contasAtrasadas.setQuantidadeDiasAtraso(daysBetween);
            Double valorCorrigido = contas.getValorOriginal() + (contas.getValorOriginal() * multa / 100) + (contas.getValorOriginal() * (daysBetween * jurosDia) / 100);
            contasAtrasadas.setValorCorrigido(valorCorrigido);
            contasAtrasadas.setKeyContas(contas.getKeyContas());
            contasAtrasadas.setContas(contas);
            contas.setContasAtrasadas(contasAtrasadas);
            contasRepository.save(contas);
        }
    }

    private List<ContasDTO> processarContasDTO(List<Contas> accounts) {
        List<ContasDTO> response = new ArrayList<>();
        accounts.stream().forEach(t -> response.add(t.convertEntityToDTO()));
        return response;
    }
}
