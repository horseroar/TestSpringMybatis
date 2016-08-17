环境搭建好之后，开发数据相关的步骤分为三个步骤：

    1,配置xml的sql语句
    2,xml对应的mapper接口新增需要的调用方法（方法名与xml中的id名保持一致）
    3,用@Autowired将xxxMapper注入到业务类，业务类调用其xxxMapper中的方法完成数据库的操作


PS：

需要用到的mybatis中的功能:

1. 普通的CRUD

2. 批量情况下的CUD

3. 事务控制
    spring统一切面控制,待添加

4. 根据条件判断动态组装SQL语句
    以往在java程序里面是使用if判断进行组装及字符串处理
        在存储过程中也有对应的if判断以及字符串处理
        在mybatis中提供了if标签以及字符串处理的标签，可以很灵活地动态完成SQL的拼装

    在批量中的应用场景：
        当日销账与隔日销账，更新和提取记录的表会不同，需要动态判断


5.其他
    不知道能不能很好的处理CHAR类型的数据的查询，待尝试...

参考链接

环境搭建：
https://segmentfault.com/a/1190000002870283
http://www.cnblogs.com/xdp-gacl/p/4271627.html

mybatis框架的使用：
孤傲苍狼的博客(mybatis系列)
http://topmanopensource.iteye.com/blog/1833001
http://blog.csdn.net/myjlvzlp/article/details/8434376
http://my.oschina.net/jsonavaj/blog/265112



