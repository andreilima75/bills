package com.deliverIt.bills.repository;

import com.deliverIt.bills.model.Contas;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;

@RepositoryRestResource(collectionResourceRel = "contas", path = "contas")
public interface ContasRepository extends JpaRepository<Contas, Long> {

    List<Contas> findByNome(String nome);

}
