# boot-crm

基于SpringBoot的客户关系管理系统<br>
本项目为课程的课后实训<br>
本项目参考自黑马程序员出版的《JavaEE企业级应用开发教程（Spring+SpringMVC+MyBatis）》

### 1.环境需求

1. 操作系统：Microsoft Window7/10  32/64位

2. Java版本：JDK8

3. 服务i其Tomcat9

4. 开发工具Eclipse/其他
5. 数据库：Mysql

### 2.功能描述

1.登录管理：分普通用户和管理员，其中管理员可以添加和禁用普通用户的账号；而普通用户除了没有添加、修改系统用户信息的功能外，具有操作系统的其他权限。这里的用户是指网络中心管理人员。

2.客户管理：实现对客户(学生用户)的添加、修改、删除和查询操作。参照BOOT客户管理系统来实现，其中[客户所属行业]作为客户(学生)的所在专业使用，[客户级别]分为包月客户和包年客户两类。

3.订单管理(校园宽带业务)：主要面向学生(客户)，提供学生所在宿舍的宽带包月/包年的缴费业务，主要管理的内容包括：订单编号、缴费人(客户)、缴费日期、到期日期(自动计算)、费用(自动计算，需要预先设置包月和包年的费用)、缴费类型(包年/包月)、经办人(登录用户)，订单可以查询、修改和删除；实现续费功能；实现统计功能：某个时间段的缴费总金额。
