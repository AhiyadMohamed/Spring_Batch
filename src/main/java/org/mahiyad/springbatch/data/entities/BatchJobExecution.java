package org.mahiyad.springbatch.data.entities;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.Date;

@Entity
@Data @AllArgsConstructor @NoArgsConstructor
@Table(name = "BATCH_JOB_EXECUTION")
public class BatchJobExecution {
    @Id
    @Column(name = "JOB_EXECUTION_ID")
    private Long id;

    @Column(name = "VERSION")
    private Long version;

    @Column(name = "CREATE_TIME")
    private Date createTime;

    @Column(name = "START_TIME")
    private Date startTime;

    @Column(name = "END_TIME")
    private Date endTime;

    @Column(name = "STATUS")
    private String status;

    @Column(name = "EXIT_CODE")
    private String exitCode;

    @Column(name = "EXIT_MESSAGE")
    private String exitMessage;

    @Column(name = "LAST_UPDATED")
    private Date lastUpdated;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "JOB_INSTANCE_ID")
    private BatchJobInstance jobInstance;


}
