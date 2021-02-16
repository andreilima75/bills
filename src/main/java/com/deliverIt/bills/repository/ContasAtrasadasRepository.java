package com.deliverIt.bills.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

@RepositoryRestResource(collectionResourceRel = "contasAtrasadas", path = "contasAtrasadas")
public interface ContasAtrasadasRepository extends JpaRepository<com.deliverIt.bills.model.ContasAtrasadas, Long> {
}
