package com.app.threetier.repository;

import com.app.threetier.domain.vo.WorkerVO;
import com.app.threetier.mapper.WorkerMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;

@Repository
@RequiredArgsConstructor
public class WorkerDAO {
    private final WorkerMapper workerMapper;

    public void insert(WorkerVO workerVO){
        workerMapper.insert(workerVO);
    }

    public void update(WorkerVO workerVO){
        workerMapper.update(workerVO);
    }
}
