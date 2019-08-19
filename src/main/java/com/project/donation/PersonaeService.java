package com.project.donation;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class PersonaeService {
    @Autowired
    private PersonaeRepository repo;
    public void delete(long id){
        repo.deleteById(id);
    }
    public void save(Personae personae){
        repo.save(personae);
    }
    public Personae getById(long id){
        return repo.findById(id).get();
    }
    public List<Personae> listAll(){
        return repo.findAll();
    }
}
