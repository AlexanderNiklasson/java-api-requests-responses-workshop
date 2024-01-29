package com.booleanuk.api;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.net.http.HttpResponse;
import java.util.ArrayList;

@RestController
@RequestMapping("publishers")
public class PublishersController {
    private ArrayList<Publisher> publishers;

    public PublishersController(){
        this.publishers = new ArrayList<>();
    }

    @GetMapping
    public ArrayList<Publisher>getAll(){
        return this.publishers;
    }

    @GetMapping("/{id}")
    public Publisher getOne(@PathVariable(name = "id") int id){
        if(id < this.publishers.size()){
            return this.publishers.get(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
    }
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher create(@RequestBody Publisher publisher) {
        if(publisher.getCity() == null || publisher.getName() == null){
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
        }
        this.publishers.add(publisher);
        return publisher;
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.CREATED)
    public Publisher update(@PathVariable (name = "id") int id, @RequestBody Publisher publisher) {
        if (id < this.publishers.size()) {
            if(publisher.getCity() == null || publisher.getName() == null){
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST, "Bad Request");
            }
            this.publishers.get(id).setName(publisher.getName());
            this.publishers.get(id).setCity(publisher.getCity());
            return this.publishers.get(id);
        }
        else{
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
        }

    }

    @DeleteMapping("/{id}")
    public Publisher delete(@PathVariable (name = "id") int id) {
        if (id < this.publishers.size()) {
            return this.publishers.remove(id);
        }
        throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Not Found");
    }
}
