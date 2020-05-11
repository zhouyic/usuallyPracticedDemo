package com.zyc.demo.mybatis.plus;


import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import org.apache.commons.lang3.builder.ToStringExclude;

import javax.security.auth.login.Configuration;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/12/14 15:26
 */
public class MpGenerator {
    public static void main(String[] args) throws IOException {
        //web功能读取配置文件内容
        Properties prop = new Properties();
//        prop.load(new FileInputStream("/customGenerator.properties"));
        prop.load(MpGenerator.class.getResourceAsStream("/customGenerator.properties"));
        String outputDir = prop.getProperty("outputDir");
        String author = prop.getProperty("author");
        String mapperName = prop.getProperty("mapperName");
        String xmlName = prop.getProperty("xmlName");
        String serviceName = prop.getProperty("serviceName");
        String serviceImplName = prop.getProperty("serviceImplName");
        String controllerName = prop.getProperty("controllerName");
        String driverName = prop.getProperty("driverName");
        String username = prop.getProperty("username");
        String password = prop.getProperty("password");
        String url = prop.getProperty("url");


        String packageConfigParent = prop.getProperty("packageConfig.parent");
        String packageConfigController = prop.getProperty("packageConfig.controller");
        String  packageConfigService = prop.getProperty("packageConfig.service");
        String  packageConfigServiceImpl = prop.getProperty("packageConfig.serviceImpl");
        String  packageConfigMapper = prop.getProperty("packageConfig.mapper");
        String  packageConfigEntity = prop.getProperty("packageConfig.entity");
        String  packageConfigXml = prop.getProperty("packageConfig.xml");


        String  templatesController = prop.getProperty("templates.controller");
        String  templatesService = prop.getProperty("templates.service");
        String  templatesServiceImpl = prop.getProperty("templates.serviceImpl");
        String  templatesEntity = prop.getProperty("templates.entity");
        String  templatesMapper = prop.getProperty("templates.mapper");
        String  templatesXml = prop.getProperty("templates.xml");

        AutoGenerator mpg = new AutoGenerator();
        // 全局配置
        GlobalConfig gc = new GlobalConfig();
        gc.setOutputDir(outputDir);
        gc.setFileOverride(true);
        gc.setActiveRecord(true);// 不需要ActiveRecord特性的请改为false
        gc.setEnableCache(false);// XML 二级缓存
        gc.setBaseResultMap(true);// XML ResultMap
        gc.setBaseColumnList(true);// XML columList
        gc.setAuthor(author);

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName(mapperName);
        gc.setXmlName(xmlName);
        gc.setServiceName(serviceName);
        gc.setServiceImplName(serviceImplName);
        gc.setControllerName(controllerName);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        DataSourceConfig dsc = new DataSourceConfig();
        dsc.setDbType(DbType.MYSQL);
        dsc.setDriverName(driverName);
        dsc.setUsername(username);
        dsc.setPassword(password);
        dsc.setUrl(url);
        mpg.setDataSource(dsc);

        // 策略配置
        StrategyConfig strategy = new StrategyConfig();
        strategy.setInclude("tb_sales_info");
        strategy.setNaming(NamingStrategy.underline_to_camel);// 表名生成策略
        mpg.setStrategy(strategy);

        // 包配置
        PackageConfig pc = new PackageConfig();
        pc.setParent(packageConfigParent);
        pc.setController(packageConfigController);
        pc.setService(packageConfigService);
        pc.setServiceImpl(packageConfigServiceImpl);
        pc.setMapper(packageConfigMapper);
        pc.setEntity(packageConfigEntity);
        pc.setXml(packageConfigXml);
        mpg.setPackageInfo(pc);


        // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
        // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
        TemplateConfig tc = new TemplateConfig();
        tc.setController(templatesController);
        tc.setService(templatesService);
        tc.setServiceImpl(templatesServiceImpl);
        tc.setEntity(templatesEntity);
        tc.setMapper(templatesMapper);
        tc.setXml(templatesXml);
        mpg.setTemplate(tc);
        // 执行生成
        mpg.execute();

    }
}
