package com.nanes.testesoft.controller;

import com.google.gson.Gson;
import com.nanes.testesoft.repository.TicketRepository;
import com.nanes.testesoft.service.TicketService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "ticket")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class TicketController {

    @Autowired
    private final TicketService service;
    @Autowired
    private final TicketRepository repository;

    private static final Gson gson = new Gson();

    public TicketController(TicketService ticketService, TicketRepository ticketRepository) {
        this.service = ticketService;
        this.repository = ticketRepository;
    }

    @GetMapping(path = "/generateOne")
    public ResponseEntity<String> generateOneLuckyNumber() {
        String luckyNumber = service.getOneLuckyNumber();
        return luckyNumber.isEmpty() ? ResponseEntity.noContent().build() : ResponseEntity.ok(luckyNumber);
    }
}
