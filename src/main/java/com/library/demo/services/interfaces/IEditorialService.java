package com.library.demo.services.interfaces;

import com.library.demo.controllers.dtos.requests.EditorialRequest;
import com.library.demo.controllers.dtos.responses.EditorialResponse;
import com.library.demo.entities.Editorial;

public interface IEditorialService {

    Editorial findEditorialById(Long id);

    Editorial findEditorialByName(String name);

    EditorialResponse create(EditorialRequest request);

}
