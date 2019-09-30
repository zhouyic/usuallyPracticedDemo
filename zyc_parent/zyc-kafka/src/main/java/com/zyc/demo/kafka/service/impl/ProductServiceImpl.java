package com.zyc.demo.kafka.service.impl;

import com.zyc.demo.kafka.constant.BaseResponse;
import com.zyc.demo.kafka.dao.ProductMapper;
import com.zyc.demo.kafka.entity.Product;
import com.zyc.demo.kafka.service.ProductService;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2018/9/11 20:40
 */
@Log
@Service
public class ProductServiceImpl implements ProductService {
    @Autowired
    ProductMapper productMapper;
    @Override
    public BaseResponse queryAll(String name) {
        log.info(MessageFormat.format("method:{0},request time:{1},param name:{2}","queryAll",System.nanoTime(),name));
        List<Map<String, Object>> mapList = new ArrayList<Map<String, Object>>();
        mapList = productMapper.getAll(name);
        if(mapList!=null&&mapList.size()>0){
            return new BaseResponse(1, mapList);
        }else{
            return new BaseResponse(0, mapList);
        }
    }



    @Override
    public Map<String, Object> save(Product product) {
        log.info(MessageFormat.format("method:{0},request time:{1},param product:{2}","save",System.nanoTime(),product));
        Map<String, Object> rMap = new HashMap<String, Object>();
        rMap.put("status", 0);
        if(product!=null){
            Integer count = productMapper.insert(product);
            if(count>0){
                rMap.put("status", 1);
            }else{

            }
        }
        return rMap;
    }
    @Override
    public Map<String, Object> remove(Integer id) {
        log.info(MessageFormat.format("method:{0},request time:{1},param id:{2}","remove",System.nanoTime(),id));
        Map<String, Object> rMap = new HashMap<String, Object>();
        rMap.put("status", 0);
        if(id!=null){
            Integer count = productMapper.delete(id);
            if(count>0){
                rMap.put("status", 1);
            }
        }
        return rMap;
    }
}
