package org.mahiyad.springbatch.config.stop;




import org.springframework.batch.core.BatchStatus;
import org.springframework.batch.core.JobExecution;
import org.springframework.batch.core.JobInstance;
import org.springframework.batch.core.explore.JobExplorer;
import org.springframework.batch.core.launch.JobExecutionNotRunningException;
import org.springframework.batch.core.launch.JobOperator;
import org.springframework.batch.core.launch.NoSuchJobExecutionException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;


@Component
public class JobService {


    @Autowired
    private JobExplorer jobExplorer;

    @Autowired
    private JobOperator jobOperator;


    public void stopBatchByName(String jobName) throws NoSuchJobExecutionException, JobExecutionNotRunningException {
        List<JobInstance> jobInstances = jobExplorer.getJobInstances(jobName, 0, Integer.MAX_VALUE);

        for (JobInstance jobInstance : jobInstances) {
            List<JobExecution> executions = jobExplorer.getJobExecutions(jobInstance);

            for (JobExecution execution : executions) {
                if (execution.getStatus() == BatchStatus.STARTED || execution.getStatus() == BatchStatus.STARTING) {
                    jobOperator.stop(execution.getId());

                }
            }
        }
    }

    //2 Eme
    public boolean stopJobByName(String jobName) throws NoSuchJobExecutionException, JobExecutionNotRunningException {
        List<JobInstance> jobInstances = jobExplorer.getJobInstances(jobName, 0, Integer.MAX_VALUE);

        boolean batchStopped = false;

        for (JobInstance jobInstance : jobInstances) {
            List<JobExecution> executions = jobExplorer.getJobExecutions(jobInstance);

            for (JobExecution execution : executions) {
                if (execution.getStatus() == BatchStatus.STARTED || execution.getStatus() == BatchStatus.STARTING) {
                    jobOperator.stop(execution.getId());
                    batchStopped = true;
                }
            }
        }

        return batchStopped;
    }


}
