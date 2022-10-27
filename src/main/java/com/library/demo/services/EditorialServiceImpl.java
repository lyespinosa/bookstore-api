package com.library.demo.services;

import com.library.demo.controllers.dtos.requests.EditorialRequest;
import com.library.demo.controllers.dtos.responses.EditorialResponse;
import com.library.demo.entities.Editorial;
import com.library.demo.repositories.IEditorialRepository;
import com.library.demo.services.interfaces.IEditorialService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EditorialServiceImpl implements IEditorialService {

    @Autowired
    private IEditorialRepository repository;


    @Override
    public Editorial findEditorialById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("No se encontró"));
    }

    @Override
    public Editorial findEditorialByName(String name) {
        return repository.findByName(name).orElseThrow(() -> new RuntimeException("No se encontró"));
    }

    @Override
    public EditorialResponse create(EditorialRequest request) {
        Editorial editorial = new Editorial();
        editorial.setName(request.getName());
        Editorial savedEditorial = repository.save(editorial);
        return from(savedEditorial);
    }

    private EditorialResponse from(Editorial editorial){
        EditorialResponse response = new EditorialResponse();
        response.setId(editorial.getId());
        response.setName(editorial.getName());
        return response;
    }
}
