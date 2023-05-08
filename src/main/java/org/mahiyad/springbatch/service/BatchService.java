package org.mahiyad.springbatch.service;

import org.mahiyad.springbatch.data.entities.BatchJobInstance;

import java.util.List;

public interface BatchService {
    List<BatchJobInstance> findAllJob();
}
