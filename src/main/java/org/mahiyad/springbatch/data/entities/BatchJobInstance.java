package org.mahiyad.springbatch.data.entities;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "BATCH_JOB_INSTANCE")
@Data @AllArgsConstructor @NoArgsConstructor
public class BatchJobInstance {

    @Id
    @Column(name = "JOB_INSTANCE_ID")
    private Long id;


    @Column(name = "VERSION")
    private int version;

    @Column(name = "JOB_NAME")
    private String jobName;

    @Column(name = "JOB_KEY")
    private String job_key;



}
