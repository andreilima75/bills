package com.deliverIt.bills.service;

import com.deliverIt.bills.dto.ContasDTO;
import com.deliverIt.bills.model.Contas;
import com.deliverIt.bills.repository.ContasRepository;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import java.util.Date;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class ContasServiceTest {

    @Autowired
    private ContasService contasService;

    @MockBean
    private ContasRepository contasRepository;

    @Test
    @Order(1)
    void findByNome() {
        contasService.save(getMockAccount());
        List<ContasDTO> contasDTO = contasService.findByNome("test");
        assertNotNull(contasDTO);
    }

    @Test
    @Order(2)
    void findAll() {
        contasService.save(getMockAccount());
        List<ContasDTO> contasDTO = contasService.findAll();
        assertNotNull(contasDTO);
    }

    @Test
    @Order(3)
    void save() {
        contasService.save(getMockAccount());
    }

    @Test
    @Order(4)
    void delete() {
        contasService.delete("test");
    }

    @Test
    @Order(5)
    void deleteAll() {
        contasService.deleteAll();
    }

    private Contas getMockAccount() {
        return new Contas("test", 1D, new Date(), new Date(), 11L, null);
    }
}