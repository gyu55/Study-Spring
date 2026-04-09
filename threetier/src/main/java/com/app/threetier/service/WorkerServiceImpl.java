package com.app.threetier.service;

import com.app.threetier.domain.vo.WorkerVO;
import com.app.threetier.repository.WorkerDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class WorkerServiceImpl implements WorkerService {
    private final WorkerDAO workerDAO;

    @Override
    public void addWorker(WorkerVO workerVO){
        workerDAO.insert(workerVO);
    }

    @Override
    public void updateWorker(WorkerVO workerVO){
        workerDAO.update(workerVO);
    }

}
