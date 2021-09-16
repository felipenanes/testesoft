package com.nanes.testesoft.model;

import javax.xml.bind.annotation.*;
import java.util.Collection;

@XmlRootElement(name = "Input")
@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(
        name = "Contato",
        propOrder = {"id", "nome", "email"},
        namespace = "https://mballem.com/"
)
public class InputObject {
    @XmlElement(name = "id", required = true)
    private int id;

    @XmlElement(name = "nome", required = true)
    private String nome;

    @XmlElement(name = "email", required = true)
    private String email;

    @Override
    public String toString() {
        return "InputObject{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
}