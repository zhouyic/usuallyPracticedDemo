package com.zyc.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.zyc.demo.service.TrUserRoleService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Hcl
 * @since 2020-01-03
 */
@RestController
@RequestMapping("/trUserRole")
public class TrUserRoleController{
    private final Logger logger = LoggerFactory.getLogger(TrUserRoleController.class);
    @Autowired
    public TrUserRoleService iTrUserRoleService;

}
