package com.zyc.demo.multi.datasource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.jdbc.DataSourceBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;

import javax.sql.DataSource;

/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/4/14 9:12
 */
@Configuration // 注册到springboot容器中
@MapperScan(basePackages = "com.zyc.demo.multi.test2", sqlSessionFactoryRef = "test2SqlSessionFactory")
public class DataSource2Config {
    @Value("${zyc.mybatis.test2.mapper-locations}")
    private String test2MapperLocations;
    /**
     *
     * @methodDesc: 功能描述:(配置test2数据库)
     * @author: 余胜军
     * @param: @return
     * @createTime:2017年9月17日 下午3:16:44
     * @returnType:@return DataSource
     * @copyright:上海每特教育科技有限公司
     * @QQ:644064779
     */
    @Bean(name = "test2DataSource")
    @ConfigurationProperties(prefix = "spring.datasource.test2")
    public DataSource testDataSource() {
        return DataSourceBuilder.create().build();
    }

    /**
     *
     * @methodDesc: 功能描述:(test2 sql会话工厂)
     * @author: 余胜军
     * @param: @param
     *             dataSource
     * @param: @return
     * @param: @throws
     *             Exception
     * @createTime:2017年9月17日 下午3:17:08
     * @returnType:@param dataSource
     * @returnType:@return
     * @returnType:@throws Exception SqlSessionFactory
     * @copyright:上海每特教育科技有限公司
     * @QQ:644064779
     */
    @Bean(name = "test2SqlSessionFactory")
    @Primary
    public SqlSessionFactory testSqlSessionFactory(@Qualifier("test2DataSource") DataSource dataSource)
            throws Exception {
        SqlSessionFactoryBean bean = new SqlSessionFactoryBean();
        bean.setDataSource(dataSource);
		bean.setMapperLocations(
				new PathMatchingResourcePatternResolver().getResources(test2MapperLocations));
        return bean.getObject();
    }

    /**
     *
     * @methodDesc: 功能描述:(test2 事物管理)
     * @author: 余胜军
     * @param: @param
     *             dataSource
     * @param: @return
     * @param: @throws
     *             Exception
     * @createTime:2017年9月17日 下午3:17:08
     * @returnType:@param dataSource
     * @returnType:@return
     * @returnType:@throws Exception SqlSessionFactory
     * @copyright:上海每特教育科技有限公司
     * @QQ:644064779
     */
    @Bean(name = "test2TransactionManager")
    @Primary
    public DataSourceTransactionManager testTransactionManager(@Qualifier("test2DataSource") DataSource dataSource) {
        return new DataSourceTransactionManager(dataSource);
    }

    @Bean(name = "test2SqlSessionTemplate")
    public SqlSessionTemplate testSqlSessionTemplate(
            @Qualifier("test2SqlSessionFactory") SqlSessionFactory sqlSessionFactory) throws Exception {
        return new SqlSessionTemplate(sqlSessionFactory);
    }

}
