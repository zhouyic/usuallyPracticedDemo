package com.zyc.demo.controller;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.zyc.demo.service.TrRoleMenuService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Hcl
 * @since 2020-01-03
 */
@RestController
@RequestMapping("/trRoleMenu")
public class TrRoleMenuController{
    private final Logger logger = LoggerFactory.getLogger(TrRoleMenuController.class);
    @Autowired
    public TrRoleMenuService iTrRoleMenuService;

}
