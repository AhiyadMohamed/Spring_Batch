package org.mahiyad.springbatch.service;


import org.mahiyad.springbatch.data.entities.BatchJobInstance;
import org.mahiyad.springbatch.data.repositories.BatchJobIntanceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BatchServiceimpl implements BatchService{

    @Autowired
    private BatchJobIntanceRepository batchJobIntanceRepository;


    @Override
    public List<BatchJobInstance> findAllJob() {
        return batchJobIntanceRepository.findAll();
    }
}
