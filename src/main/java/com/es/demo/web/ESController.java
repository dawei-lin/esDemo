package com.es.demo.web;

import com.es.demo.dao.ItemRepository;
import com.es.demo.dao.LogDao;
import com.es.demo.entity.Log;
import com.es.demo.entity.LogParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.elasticsearch.core.ElasticsearchTemplate;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * @author ldw
 * @date 2019/9/18 19:19
 */
@RestController
public class ESController {
    @Autowired
    private ItemRepository itemRepository;
    @Autowired
    private ElasticsearchTemplate elasticsearchTemplate;
    @Autowired
    private LogDao logDao;


    @RequestMapping("/saveLogFromDb")
    public String saveLogFromDb() {
        List<Log> logList = logDao.getAll();
        for (Log log : logList) {
            log.setId(UUID.randomUUID().toString().replace("-", ""));
            System.out.println(log);
            itemRepository.save(log);
        }
        return "success";
    }

    @RequestMapping("/saveLog")
    public String saveLog(@RequestBody Log log) {
        log.setId(UUID.randomUUID().toString().replace("-", ""));
        itemRepository.save(log);
        return "success";
    }

    @RequestMapping("/updateLog")
    public String update(@RequestBody Log log) {
        itemRepository.save(log);
        return "success";
    }

    @RequestMapping("/delete")
    public String deleteLog(String id) {
        itemRepository.deleteById(id);
        return "success";
    }

    @RequestMapping("/findAll")
    public List<Log> findAll() {
        Iterable<Log> it = itemRepository.findAll();
        List<Log> logList = new ArrayList<>();
        for (Log log : it) {
            logList.add(log);
        }
        return logList;
    }

    @RequestMapping("/findByLogTime")
    public List<Log> findByLogTime(@RequestBody LogParam logParam) {
        Iterable<Log> it = itemRepository.findByLogTimeBetween(logParam.getBeginTime().getTime(), logParam.getEndTime().getTime());
        List<Log> logList = new ArrayList<>();
        for (Log log : it) {
            logList.add(log);
        }
        return logList;
    }

    @RequestMapping("/findByLogParam")
    public List<Log> findByLogParam(@RequestBody LogParam logParam) {
        Iterable<Log> it = itemRepository.findByModuleTypeAndUserNameAndLogTimeBetweenOrderByLogTimeDesc(logParam.getModuleType(), logParam.getUserName(), logParam.getBeginTime().getTime(), logParam.getEndTime().getTime());
        List<Log> logList = new ArrayList<>();
        for (Log log : it) {
            logList.add(log);
        }
        return logList;
    }

    @RequestMapping("/createIndex")
    public String createIndex() {
        elasticsearchTemplate.createIndex(Log.class);
        return "success";
    }

    @RequestMapping("/deleteIndex")
    public String deleteIndex() {
        elasticsearchTemplate.deleteIndex(Log.class);
        return "success";
    }

}
