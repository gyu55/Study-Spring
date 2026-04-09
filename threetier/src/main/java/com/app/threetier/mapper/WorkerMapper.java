package com.app.threetier.mapper;

import com.app.threetier.domain.vo.WorkerVO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface WorkerMapper {
    public void insert(WorkerVO workerVO);
    public void update(WorkerVO workerVO);
}
