package com.es.demo.dao;

import com.es.demo.entity.Log;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

/**
 * @author ldw
 * @date 2019/9/18 19:11
 */
public interface ItemRepository extends ElasticsearchRepository<Log, String> {
    List<Log> findByLogTimeBetween(Long fromLogTime, Long toLogTime);

    List<Log> findByModuleTypeAndUserNameAndLogTimeBetween(String moduleType, String userName, Long fromLogTime, Long toLogTime);

    List<Log> findByModuleTypeAndUserNameAndLogTimeBetweenOrderByLogTimeDesc(String moduleType, String userName, Long fromLogTime, Long toLogTime);
}
