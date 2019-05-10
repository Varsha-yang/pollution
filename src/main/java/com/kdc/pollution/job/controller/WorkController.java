package com.kdc.pollution.job.controller;

import com.kdc.pollution.job.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLException;
import java.util.List;

@RestController
public class WorkController {
    @Autowired
    private WorkService workService;

    @RequestMapping("/pollution")

    public List<String> test() throws SQLException {
        return  workService.execute();
    }

}
