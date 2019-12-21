package com.zyc.demo.mybatis.plus.mapper;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.zyc.demo.mybatis.plus.entity.TbUser;
import lombok.extern.slf4j.Slf4j;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.StringUtils;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author zhouyicai
 * @Description: TODO
 * @date 2019/12/14 17:14
 */
@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class TbUserMapperTest {
    @Autowired
    private TbUserMapper tbUserMapper;

    /**
     * 插入测试
     */
    @Test
    public void insert(){
        System.out.println(LocalDateTime.now());
        TbUser user = new TbUser();
        user.setName("向后");
        user.setAge(30);
        user.setEmail("xh@qq.com");
        user.setManagerId(1205809811506118657L);
        user.setCreateTime(LocalDateTime.now());
        user.setRemark("我是一个备注信息");
        Integer count = tbUserMapper.insert(user);
        System.out.println("影响的行数:"+count);
    }
    /**
     * 普通查询
     */
    @Test
    public void selectById(){
        TbUser tbUser = tbUserMapper.selectById(1206019197931458561L);
        log.info(tbUser.toString());
    }

    /**
     * 普通查询
     */
    @Test
    public void selectByIdS(){
        List<Long> ids = Arrays.asList(1206016266322649090L, 1206018667322638337L, 1206019197931458561L);
        List<TbUser> userList = tbUserMapper.selectBatchIds(ids);
        Assert.assertEquals(3,userList.size());
        userList.forEach(System.out::println);
    }

    /**
     * 普通查询 根据map条件查询集合
     */
    @Test
    public void selectByMap(){
        Map<String, Object> columnap = new HashMap<>();
        //columnap中的key是数据库中列
        columnap.put("name","东");
        columnap.put("age", 26);
        List<TbUser> userList = tbUserMapper.selectByMap(columnap);
        userList.forEach(System.out::println);
    }

    /**
     * 条件查询 查询名字中包含向并且年龄小于40的员工
     */
    @Test
    public void selectByWrapper(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "向");
        queryWrapper.le("age", 40);
        List<TbUser> usersList = tbUserMapper.selectList(queryWrapper);
        usersList.forEach(System.out::println);
    }
    /**
     * 条件查询 查询名字中包含向并且年龄在20和40之间邮箱不为空的员工
     */
    @Test
    public void selectByWrapper2(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "向").between("age", 20, 40).isNotNull("email");
        List<TbUser> usersList = tbUserMapper.selectList(queryWrapper);
        usersList.forEach(System.out::println);
    }

    /**
     * 条件查询 查询名字中包含向或者且年龄大于25，按照年龄降序排序，年龄相同按照id升序排序
     */
    @Test
    public void selectByWrapper3(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "向").or().ge("age", 25).orderByDesc("age")
                .orderByAsc("id");
        List<TbUser> usersList = tbUserMapper.selectList(queryWrapper);
        usersList.forEach(System.out::println);
    }


    /**
     * 条件查询 创建日期为2019年12月15日并直属上级为大boss的员工
     * inSql 子查询
     */
    @Test
    public void selectByWrapper4(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
//        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}", "2019-12-15 or true or true").inSql("manager_id", "select id from tb_user where name like '大%'");
        queryWrapper.apply("date_format(create_time,'%Y-%m-%d')={0}", "2019-12-15").inSql("manager_id", "select id from tb_user where name like '大%'");
        List<TbUser> usersList = tbUserMapper.selectList(queryWrapper);
        usersList.forEach(System.out::println);
    }

    /**
     * 条件查询 名字为王姓且（年龄小于40或邮箱不为空）
     * name like '王%'  and (age < 40 or email is not null)
     */
    @Test
    public void selectByWrapper5(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "大").and(wq -> wq.lt("age", 40).or().isNotNull("email"));
        List<TbUser> usersList = tbUserMapper.selectList(queryWrapper);
        usersList.forEach(System.out::println);
    }

    /**
     * 条件查询 名字为王姓且（年龄小于40并且大于20并邮箱不为空）
     * name like '王%'  and (age < 40 and age > 20 and email is not null)
     */
    @Test
    public void selectByWrapper6(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.likeRight("name", "大").and(wq -> wq.lt("age", 40).gt("age", 20).isNotNull("email"));

        List<TbUser> usersList = tbUserMapper.selectList(queryWrapper);
        usersList.forEach(System.out::println);
    }
    /**
     * 条件查询 (年龄小于40或邮箱不为空)并且名字为王姓
     * (age <40 or email is not null) and name like '王%'
     */
    @Test
    public void selectByWrapper7(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.nested(wq->wq.lt("age",40).or().isNotNull("email"))
                .likeRight("name", '大');
        List<TbUser> usersList = tbUserMapper.selectList(queryWrapper);
        usersList.forEach(System.out::println);
    }

    /**
     * 条件查询 年龄为 27，28， 30
     * age in(27,28,30)
     * (age <40 or email is not null) and name like '王%'
     */
    @Test
    public void selectByWrapper8(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age", Arrays.asList(27, 28, 30));
        List<TbUser> usersList = tbUserMapper.selectList(queryWrapper);
        usersList.forEach(System.out::println);
    }
    /**
     * 条件查询 年龄为 27，28， 30 只返回符合条件的一条数据
     * limit 1
     */
    @Test
    public void selectByWrapper9(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.in("age", Arrays.asList(27, 28, 30))
                .last("limit 1");
        List<TbUser> usersList = tbUserMapper.selectList(queryWrapper);
        usersList.forEach(System.out::println);
    }

    /**
     * select不列出全部字段
     * 1. 名字中包含并且年龄小于40
     * name like '%雨%' and age < 40
     */
    @Test
    public void selectByWrapperSupper(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name").like("name", "南").lt("age", 40);
        List<TbUser> users = tbUserMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }
    /**
     * select不列出全部字段(排除某字段)
     * 1. 名字中包含并且年龄小于40
     * name like '%雨%' and age < 40
     */
    @Test
    public void selectByWrapperSupper2(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("name", "南").lt("age", 40)
            .select(TbUser.class,info->!info.getColumn().equals("create_time")&&!info.getColumn().equals("manager_id"));
        List<TbUser> users = tbUserMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    /**
     * 测试condition
     * 1. 名字中包含王姓并且邮箱不为空
     * name like '%雨%' and email is not null
     */
    @Test
    public void testCondition(){
        String name = "大";
        String email = "d";
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.like(org.apache.commons.lang3.StringUtils.isNotEmpty(name), "name", name)
                .like(org.apache.commons.lang3.StringUtils.isNotEmpty(email), "email", email);
        List<TbUser> users = tbUserMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    /**
     * 实体作为条件构造器构造方法的参数
     */
    @Test
    public void testWrapper(){
        TbUser tbUser = new TbUser();
        /**可以在实体属性上设置@TableField(condition = SqlCondition.LIKE)
         */
        tbUser.setName("大boss");
        tbUser.setAge(25);
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>(tbUser);
        List<TbUser> users = tbUserMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    /**
     * allEq()
     */
    @Test
    public void selectWrapperAllEq(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        Map<String, Object> params = new HashMap<>();
        params.put("name", "东");
        params.put("age", null);
//        queryWrapper.allEq(params);
        /**过滤 字段为null的条件*/
//        queryWrapper.allEq(params, false);
        /**过字段条件（是否加入到sql中）*/
        queryWrapper.allEq((k, v) -> !k.equals("name"), params);
        List<TbUser> users = tbUserMapper.selectList(queryWrapper);
        users.forEach(System.out::println);

    }

    /**
     * selectMaps()
     */
    @Test
    public void selectWrapperMaps(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name").like("name", "大").lt("age", 40);
        List<Map<String, Object>> maps = tbUserMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);

    }

    /**
     * selectMaps()
     *按照直属上级分组,查询每组的平均年龄,最大年龄，最小年龄。
     * 并且只取年龄总和小于500的组
     * select avg(age) avg_age,min(age) min_age,max(age) max_age
     * from user
     * group by maanger_id
     * having sum(age) <500
     */
    @Test
    public void selectWrapperMaps2(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select(" avg(age) avg_age", "min(age) min_age","max(age) max_age")
            .groupBy("manager_id")
            .having("sum(age) <{0}",500);
        List<Map<String, Object>> maps = tbUserMapper.selectMaps(queryWrapper);
        maps.forEach(System.out::println);

    }

    /**
     * 返回第一列
     */
    @Test
    public void selectWrapperObjs(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name").like("name", "向").lt("age", 40);
        List<Object> objects = tbUserMapper.selectObjs(queryWrapper);
        objects.forEach(System.out::println);

    }

    /**
     * 总记录数
     */
    @Test
    public void selectWrapperCount(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name").like("name", "向").lt("age", 40);
        Integer count = tbUserMapper.selectCount(queryWrapper);
        System.out.println("总记录数："+count);

    }

    /**
     * 只返回一条记录
     */
    @Test
    public void selectWrapperOne(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.select("id", "name").like("name", "向东").lt("age", 40);
        TbUser user = tbUserMapper.selectOne(queryWrapper);
        System.out.println(user);

    }

    /**
     * lambda条件构造器
     */
    @Test
    public void selectLambda(){
        LambdaQueryWrapper<TbUser> lambda = new QueryWrapper<TbUser>().lambda();
//        LambdaQueryWrapper<TbUser> tbUserLambdaQueryWrapper = new LambdaQueryWrapper<TbUser>();
        lambda.like(TbUser::getName, "向").lt(TbUser::getAge, 40);
        List<TbUser> users = tbUserMapper.selectList(lambda);
        users.forEach(System.out::println);

    }

    /**
     * lambda条件构造器
     * 名字为王姓并且(年龄小于40或邮箱不为空)
     * nam  e like '王%' and(age < 40 or email is not null)
     */
    @Test
    public void selectLambda2(){
        LambdaQueryWrapper<TbUser> lambda = new QueryWrapper<TbUser>().lambda();
//        LambdaQueryWrapper<TbUser> tbUserLambdaQueryWrapper = new LambdaQueryWrapper<TbUser>();
        lambda.likeRight(TbUser::getName, "向")
                .and(lqw -> lqw.lt(TbUser::getAge, 40).or().isNotNull(TbUser::getEmail));
        List<TbUser> users = tbUserMapper.selectList(lambda);
        users.forEach(System.out::println);
    }

    /**
     * 分页测试
     */
    @Test
    public void selectPage(){
        QueryWrapper<TbUser> queryWrapper = new QueryWrapper<>();
        queryWrapper.ge("age", 26);
        Page<TbUser> page = new Page<>(1, 2,0L);
//        IPage<TbUser> iPage = tbUserMapper.selectPage(page, queryWrapper);
//        System.out.println("总页数:" + iPage.getPages());
//        System.out.println("总记录数:" + iPage.getTotal());
//        List<TbUser> records = iPage.getRecords();
//        records.forEach(System.out::println);

        IPage<Map<String,Object>> iPage = tbUserMapper.selectMapsPage(page, queryWrapper);
        System.out.println("总页数:" + iPage.getPages());
        System.out.println("总记录数:" + iPage.getTotal());
        List<Map<String, Object>> records = iPage.getRecords();
        records.forEach(System.out::println);

    }

}
