package com.learnapi.chucknorrisquotes.service;

import com.learnapi.chucknorrisquotes.repository.repo;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.sql.SQLException;

@Service
public class DataService {
    private final repo repository;

    public DataService(repo repository) {
        this.repository = repository;
    }

    public void getCoinInfo(){
        repository.getCoinInfo();
    }
}
