1.
Exception in thread "main" java.lang.NoClassDefFoundError: org/apache/velocity/context/Context
Caused by: java.lang.ClassNotFoundException: org.apache.velocity.context.Context
加入依赖:
<!-- 模板引擎 -->
		<dependency>
			<groupId>org.apache.velocity</groupId>
			<artifactId>velocity-engine-core</artifactId>
			<version>2.0</version>
		</dependency>


2.It was either not specified and/or could not be found for the javaType (java.time.LocalDateTime)

https://blog.csdn.net/Milan__Kundera/article/details/93889040

3.spring-boot mybatis-plus 集成 + 代码生成器自定义controller 模板
http://www.jeepxie.net/article/205517.html

4.It was either not specified and/or could not be found for the javaType (java.time.LocalDateTime)

https://blog.csdn.net/Milan__Kundera/article/details/93889040



5. 亲测  springboot 2.x整合mybatis-plus 3.x
https://www.cnblogs.com/HackerBlog/articles/10250549.html
  代码生成:
    https://www.cnblogs.com/hcl1991/p/10225758.html

6. 技术学习
    6.1 排除非表字段的三种方式
        a. 使用 transient   不参与序列化
        eg:  private transient String remark;

        b. 使用静态变量   全类只有一份
         private  static String remark;

         lombok不会生成set.get方法
          eg:

         /**备注*/
        private  static String remark;

        public static String getRemark() {
            return remark;
        }
        c. 使用mp的注解
          /**备注*/
          @TableField(exist = false)
          private  String remark;