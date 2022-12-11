package com.nanes.testesoft.service.impl;

import com.nanes.testesoft.repository.TicketRepository;
import com.nanes.testesoft.service.TicketService;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class TicketServiceImpl implements TicketService {

    private final TicketRepository repository;

    public TicketServiceImpl(TicketRepository repository) {
        this.repository = repository;
    }

    @Override
    public String getOneLuckyNumber() {
        //TODO: verificar para o sorteio em questão os números já gerados
        //TODO: para impedir geração de tickets repetidos.
        Random random = new Random();
        int luckyNumber = random.nextInt(99999);
        return Integer.toString(luckyNumber);
    }

}