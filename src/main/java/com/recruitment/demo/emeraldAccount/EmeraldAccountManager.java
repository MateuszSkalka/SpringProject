package com.recruitment.demo.emeraldAccount;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class EmeraldAccountManager {
    private EmeraldAccountRepository emeraldAccountRepository;

    @Autowired
    public EmeraldAccountManager(EmeraldAccountRepository emeraldAccountRepository){
        this.emeraldAccountRepository = emeraldAccountRepository;
    }

    public Optional<EmeraldAccount> findById(long id){
        return emeraldAccountRepository.findById(id);
    }

    public Iterable<EmeraldAccount> findAll(){
        return emeraldAccountRepository.findAll();
    }

    public EmeraldAccount save(EmeraldAccount emeraldAccount){
        return emeraldAccountRepository.save(emeraldAccount);
    }

    public void deleteById(long id){
        emeraldAccountRepository.deleteById(id);
    }







}
