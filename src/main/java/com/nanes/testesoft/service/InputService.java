package com.nanes.testesoft.service;

import com.nanes.testesoft.model.GenericEntity;
import com.nanes.testesoft.model.Person;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public interface InputService extends CrudService<GenericEntity, Long> {}
