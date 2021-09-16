package com.nanes.testesoft.controller;

import com.nanes.testesoft.model.InputObject;
import com.nanes.testesoft.utils.InputJaxB2;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "input")
@CrossOrigin(origins = "http://localhost:4200", maxAge = 3600)
public class InputController {
    @GetMapping(path = "")
    public ResponseEntity<String> readInput() {
        InputObject output = (InputObject) new InputJaxB2().unmarshalFromFile(
                InputObject.class,
                "teste.xml"
        );
        return ResponseEntity.ok(output.toString());
    }
}
