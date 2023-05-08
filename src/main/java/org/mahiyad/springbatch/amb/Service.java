package org.mahiyad.springbatch.amb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Map;

@org.springframework.stereotype.Service
@Transactional
public class Service {
    @Autowired
    private JdbcTemplate jdbcTemplate;

    public List<String> getUsers() {
        String sql = "SELECT job_instance_id FROM batch_job_instance";
        return jdbcTemplate.queryForList(sql, String.class);
    }

    public List<Map<String, Object>> getTableColumns() {
        String sql = "SELECT * FROM batch_job_instance";
        return jdbcTemplate.queryForList(sql);
    }
}
