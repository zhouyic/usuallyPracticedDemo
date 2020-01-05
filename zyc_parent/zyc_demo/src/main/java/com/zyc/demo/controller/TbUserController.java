package com.zyc.demo.controller;
import com.zyc.demo.entity.model.TbUser;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.beans.factory.annotation.Autowired;
import com.zyc.demo.service.TbUserService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
/**
 *
 * @author Hcl
 * @since 2020-01-03
 */
@RestController
@RequestMapping("/tbUser")
public class TbUserController{
    private final Logger logger = LoggerFactory.getLogger(TbUserController.class);
    @Autowired
    public TbUserService iTbUserService;
    @GetMapping("test")
    public String test(){
        TbUser tbUser = new TbUser();
        tbUser.setName("zyc1");
        iTbUserService.findUser(tbUser);
        return "test";
    }

}
