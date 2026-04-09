package com.app.threetier.service;

import com.app.threetier.domain.vo.WorkerVO;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
@Slf4j
public class WorkerServiceTests {

    @Autowired
    private WorkerService workerService;

    @Test
    void addWorkerTest(){
        WorkerVO workerVO = new WorkerVO();
        workerVO.setWorkerName("test");
        workerService.addWorker(workerVO);
    }
}
