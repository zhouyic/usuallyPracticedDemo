package com.zyc.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.zyc.demo.service.TbRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Hcl
 * @since 2020-01-03
 */
@RestController
@RequestMapping("/tbRole")
public class TbRoleController{
    private final Logger logger = LoggerFactory.getLogger(TbRoleController.class);
    @Autowired
    public TbRoleService iTbRoleService;

}
