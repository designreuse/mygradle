## applicationContext 配置

#### 扫描组件
可以用注解注册bean，bean 不用在xml中注册
```
 <context:component-scan base-package="com.git"></context:component-scan>
 
```


#### 导入propertis 文件 可以在xml 直接用${key} 来使用

```
 <context:property-placeholder location="classpath:jdbc.properties"/>
```


#### c3p0 数据库连接池配置

```
<bean id="dataSource" class="com.mchange.v2.c3p0.ComboPooledDataSource">
        <property name="driverClass" value="${jdbc.driver}"></property>
        <property name="jdbcUrl" value="${jdbc.url}"></property>
        <property name="user" value="${jdbc.username}"></property>
        <property name="password" value="${jdbc.password}"></property>

        <!-- 其他配置 -->
        <!--初始化时获取三个连接，取值应在minPoolSize与maxPoolSize之间。Default: 3 -->
        <property name="initialPoolSize" value="3"></property>
        <!--连接池中保留的最小连接数。Default: 3 -->
        <property name="minPoolSize" value="3"></property>
        <!--连接池中保留的最大连接数。Default: 15 -->
        <property name="maxPoolSize" value="5"></property>
        <!--当连接池中的连接耗尽的时候c3p0一次同时获取的连接数。Default: 3 -->
        <property name="acquireIncrement" value="3"></property>
        <!-- 控制数据源内加载的PreparedStatements数量。如果maxStatements与maxStatementsPerConnection均为0，则缓存被关闭。Default: 0 -->
        <property name="maxStatements" value="8"></property>
        <!--maxStatementsPerConnection定义了连接池内单个连接所拥有的最大缓存statements数。Default: 0 -->
        <property name="maxStatementsPerConnection" value="5"></property>
        <!--最大空闲时间,1800秒内未使用则连接被丢弃。若为0则永不丢弃。Default: 0 -->
        <property name="maxIdleTime" value="1800"></property>

    </bean>

```

#### hibernate配置
```
    <!--  配置SessionFactory -->
    <bean id="sessionFactory" class="org.springframework.orm.hibernate5.LocalSessionFactoryBean">
        <property name="dataSource" ref="dataSource"/>

        <property name="hibernateProperties">
            <props>
                <prop key="hibernate.dialect">org.hibernate.dialect.MySQL5Dialect</prop>
                <prop key="hibernate.show_sql">true</prop>
                <prop key="hibernate.format_sql">true</prop>
                <prop key="hibernate.hbm2ddl.auto">update</prop>
            </props>
        </property>
        <property name="mappingLocations" value="classpath:hbm/*.hbm.xml"></property>


    </bean>


```

#### 注解方式配置事物
```
    <!-- 配置声明式的事务管理（采用基于注解的方式） -->
    <bean id="transactionManager" class="org.springframework.orm.hibernate5.HibernateTransactionManager">
        <property name="sessionFactory" ref="sessionFactory"></property>
    </bean>
    <tx:annotation-driven transaction-manager="transactionManager" />

```

#### 导入其他的配置xml
```
 <import resource="spring_beans.xml"></import>

```
## 数据库配置 jdbc.propertis
```
jdbc.url = jdbc:mysql://127.0.0.1/oa?useUnicode=true&characterEncoding=UTF-8
jdbc.driver = com.mysql.jdbc.Driver
jdbc.username= root
jdbc.password=.jjplay1815

```

## struts.xml 配置
```
<?xml version="1.0" encoding="UTF-8"?>

<!DOCTYPE struts PUBLIC
        "-//Apache Software Foundation//DTD Struts Configuration 2.5//EN"
        "http://struts.apache.org/dtds/struts-2.5.dtd">

<struts>
    <constant name="struts.enable.DynamicMethodInvocation" value="true"></constant>
    <!--设置开发模式，默认关闭。如果设置true：将提供更多提示信息，自动加载文件-->
    <constant name="struts.devMode" value="true"></constant>
    <!--
    name:单纯的给包起一个名字,不要与其他包名重复
        namespace: 为action访问加上一层或多层路径
        extends: 继承一个其他包,目的是引入其他包的配置
        abstract: 声明包是抽象的.意思就是让别的包来继承,声明为抽象的包中不能含有Action配置
    -->
    <package name="hello" namespace="/" extends="struts-default">
        <!--
            name: 为我们的action类加上一个标识,在访问时填入name名称.就可以找到action
            class: action完整类名
            method:处理的方法
         -->
        <action name="index" class="com.git.action.HelloAction" method="execute">
            <!-- name:返回结果的标识,用于找到结果路径
                 type: 可以决定跳转到结果的方式=> 转发,重定向.....
             -->

            <result name="success" type="dispatcher">/index.jsp</result>
        </action>

        <action name="user_*" class="com.git.action.SaveUserAction" method="{1}">
            <result name="input">/save.jsp</result>
            <result name="success">/success.jsp</result>
        </action>



    </package>

</struts>
```

## struts国际化 struts.propertis
```
struts.custom.i18n.resources=globalMessages
```
globalMessages 国际化文件开始的名称

* globalMessages_en.properties

* globalMessages_zh.properties

```
firstname=firstname
lastname=lastname
age=age

firstname=\u59d3
lastname=\u540d
age=\u5e74\u9f84
```

#### 使用
```
<s:property value="%{getText('firstname')}" />

```
------------------2017.09.19---------------------

valid
delete
type redirect
return del()
if(confirm(""")){
}

update
updatePUser


xls
userservice
public INputstream getinputstream

userserviceimpl
http://poi.apache.org/spreadsheet/how-to.html#sxssf

把文件放到内存




action
<type success type=stream>

<param name = "contentType" >application/vnd.ms-excel</>
<param name = "contentDisposition"> filename="allusers.xls"</>
<param name="inputName">downloadFile</>

</type>

public InputStream getDownloadFile() {
return this.server.getInputstram
}


## validation
* SaveUserAction-user_save-validation.xml  打包时没有放到class 中


---------------920-------------
1，新建deleteServerlet 服务器启动清除临时文件
web.xml
1,不需要mapping

2, wb.getbytes  byteArrayInputstream
先写入bytearrayoutputStream
然后获取到数组 构造bytearrayinputstream

documentcatalog 文档类型
id
name
parent
children
date
flag  true 文档类别  false 文档连接
authorId
authorName
type  固定类型
order
content  连接的描述
url  连接的url
documentItems



documentItem 文档条目
id
name
authorId
authorName
date
documentcatlog
realsize 真实的大小 字节
size  MB GB
randomName 存在硬盘上的文件名
type  扩展名


users
id
username
password
relaname
type    普通用户 还是管理员


 set 
 name 表示类的关联
 table 关联多的表
 cascade 级联关系
 inverse true  这个级联关系需要多的一方维护
 lazy 懒加载
 order-by 对set排序
 key  一的关联字段
 one-to-many多的类名
 
 1，文档的添加
 2，文档的修改
 
 u.date.toString().substring(0,10)
 u.flag ==1
 
 <param name="type">1</param>
 <param name="parentId">1</param>
 
 ridiectName
  <param name="type">${}</param>
  <param name="parentId"type>1</param>
  
  
  requet.getContextPathgit
  
  
  hibernate
  merge
  1,如果session中不存在与参数object 具有相同主键的对象，
       那么首先需要根据主键从数据库中记载出该对象，然后将参数object中的属性拷贝到加载出来的那个对象上面，
       最后返回该持久化对象，同时需要注意，参数object并没有关联到session上。
       
  2，如果session中存在于参数object具有相同主键的对象，那么直接将参数object中属性拷贝到该持久化对象上，
    然后将持久化对象返回，同时需要注意，参数object中并没有关联到session上。
         
-----------------------------
   Struts has detected an unhandled exception:
   
   Messages:	
   A different object with the same identifier value was already associated with the session : [com.git.bean.DocumentitemEntity#0]
   File:	org/hibernate/internal/ExceptionConverterImpl.java
   Line number:	118      
         
         for (DocumentitemEntity entity : items) {
         
                     entity.setDocumentCatalog(documentCatalog);
                     session.save(entity);
                     session.flush();
                     session.clear();
         
         
                 }
         
 #### 文件下载乱码
         
 ```
     public String getFilename() throws UnsupportedEncodingException {
         return new String(filename.getBytes(), "ISO8859-1");
 
     }
     
     
       <action name="download" class="com.git.action.documentItem.DownloadDocumentItemAction">
                 <result name="success" type="stream">
                     <!--<param name="contentType">application/vnd.ms-excel</param>-->
                     <param name="contentType">application/octet-stream;charset=ISO8859-1</param>
                     <param name="contentDisposition">attachment;filename=${filename}</param>
                     <param name="inputName">downloadFile</param>
                 </result>
             </action>
         
 ```        
         
         
## 更新文件名
文件可以跟当前文件重名 不能跟其他文件重名
         