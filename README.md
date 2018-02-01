## ssm

###springMVC+mybaits

- 参照：http://how2j.cn/k/ssm/ssm-tutorial/1137.html?tid=77#nowhere
- 参照：http://www.mybatis.org/mybatis-3/zh/sqlmap-xml.html

#### 数据库 创建表 准备数据 
- 创建数据库
```
create database how2java;
```
- 数据库
```
use how2java;
  
CREATE TABLE category_ (
  id int(11) NOT NULL AUTO_INCREMENT,
  name varchar(30) ,
  PRIMARY KEY (id)
) DEFAULT CHARSET=UTF8;
```
- 准备数据
```
use how2java;
   
insert into category_ values(null,"category1");
insert into category_ values(null,"category2");
insert into category_ values(null,"category3");
insert into category_ values(null,"category4");
insert into category_ values(null,"category5");
 
select * from category_
```