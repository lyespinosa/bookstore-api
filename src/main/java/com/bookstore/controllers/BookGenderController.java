package com.bookstore.controllers;

import com.bookstore.controllers.dtos.responses.BaseResponse;
import com.bookstore.controllers.dtos.responses.BookResponse;
import com.bookstore.controllers.dtos.responses.GenderResponse;
import com.bookstore.services.interfaces.IBookGenderService;
import com.bookstore.controllers.dtos.requests.CreateBookGenderRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("books_genders")
public class BookGenderController {

    @Autowired
    private IBookGenderService service;

    @GetMapping
    public ResponseEntity<BaseResponse> listBookGenders(){
        BaseResponse baseResponse = service.listBookGenders();
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @GetMapping("genders/book/{id}")
    public List<GenderResponse> listAllGendersByBookId(@PathVariable Long id) {
        return service.listAllGendersByBookId(id);
    }

    @GetMapping("books/gender/{id}")
    public List<BookResponse> listAllBooksByGenderId(@PathVariable Long id) {
        return service.listAllBooksByGenderId(id);
    }

    @PostMapping
    public ResponseEntity<BaseResponse> create(@RequestBody @Valid CreateBookGenderRequest request){
        BaseResponse baseResponse = service.create(request);
        return new ResponseEntity<>(baseResponse, baseResponse.getHttpStatus());
    }

    @DeleteMapping("{id}")
    public void delete(@PathVariable Long id){
        service.delete(id);
    }


}
