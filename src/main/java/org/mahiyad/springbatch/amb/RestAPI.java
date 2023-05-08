package org.mahiyad.springbatch.amb;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("api")
public class RestAPI {


    @Autowired
    private Service service;

    @GetMapping("/users")
    public List<String> getUsers() {
        return service.getUsers();
    }

    @GetMapping("/Batch")
    public List<Map<String, Object>> getTableColumns() {
        return service.getTableColumns();
    }
}
