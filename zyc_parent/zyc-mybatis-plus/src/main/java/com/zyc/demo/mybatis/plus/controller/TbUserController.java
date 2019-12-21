package com.zyc.demo.mybatis.plus.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.zyc.demo.mybatis.plus.service.TbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Hcl
 * @since 2019-12-15
 */
@RestController
@RequestMapping("/tbUser")
public class TbUserController{
    private final Logger logger = LoggerFactory.getLogger(TbUserController.class);
    @Autowired
    public TbUserService iTbUserService;

}
