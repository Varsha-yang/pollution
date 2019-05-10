package com.kdc.pollution.job;

import com.kdc.pollution.job.service.WorkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.sql.SQLException;

@Component
@EnableScheduling
public class WorkJob {
    @Autowired
    private WorkService workService;

    //@Scheduled(fixedDelay = 1000000000)
    private  void  main() throws SQLException {
        workService.execute();
    }
}
