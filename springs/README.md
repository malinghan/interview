## 第9课
### 基础题
#### 1.作业要求
1.（选做）使用Java中的动态代理，实现一个简单的AOP
##### 实现说明

实现代码: https://github.com/malinghan/interview/tree/master/springs/src/main/java/com/someecho/spring03

```java
public class AopJDKDynamicProxyFactory implements InvocationHandler {

     private Object target;

     public Object bind(Object target){
         this.target = target;
         return Proxy.newProxyInstance(target.getClass().getClassLoader(),target.getClass().getInterfaces(),this);
     }

     public Object invoke(Object proxy, Method method, Object[] args) throws Throwable{
         Annotation[] annotations = method.getAnnotations();
         System.out.println(annotations);
         Transaction transactional = method.getAnnotation(Transaction.class);
         Log log = method.getAnnotation(Log.class);
         Object result = null;
         if(transactional != null){
             new TransactionAspect().before();
         }
         if(log != null){
             new LogAspect().before();
         }
         result = method.invoke(this.target,args);
         if(transactional != null){
             new TransactionAspect().after();
         }
         if(log != null){
             new LogAspect().after();
         }
         return  result;
     }
}
```



#### 2.作业要求
2. (必做) 写代码实现Spring Bean的装配，方式越多越好(XML、Annotation都可以)
- 基于XML、基于代码
- 方式一：设置注入
- 方式二：构造注入
- 基于注解的装配
    - @Component
    - @Repository
    - @Service
    - @Controller
    - @Autowired
    - @Resource
    - @Inject
    - @Qualifer
  

##### 实现说明
见: /Users/malinghan/IdeaProjects/learning-space/interview/springs/src/main/java/com/someecho/spring04

#### 3.作业要求
3. (选做) 实现一个Spring XML自定义配置，配置一组Bean，例如Student/Klass/School

##### 实现说明
 不做


## 第10课
### 基础题
#### 10.1.作业要求
1. 选做，总结一下单例的各种写法，比较它们的优劣
##### 10.1 实现说明
https://blog.csdn.net/itachi85/article/details/50510124

#### 10.2 .作业要求
2. 选做，maven/spring的profile机制，都有什么用法？

##### 10.2 实现说明
见: springs/maven&spring的profile机制，都有什么用法.md

#### 10.3 作业要求
3. 必做，给前面课程提供的Student等Bean实现自动配置和Starter


##### 10.3 实现说明

#### 10.4 作业要求
4. 选做，总结Hibernate与Mybatis各方面的异同点


##### 10.4 实现说明


#### 10.5 作业要求
5. 选做，学习Mybatis-generator的用法和原理，学会自定义TypeHandler处理复杂类型

##### 10.5 实现说明

#### 10.6 作业要求
6. 必做，研究一下JDBC接口和儿数据库连接池，掌握他们的设计和用法
a. 使用JDBC原生接口，实现数据库的增删查改
b. 使用事务，PrepareStatement方式，批处理方式，改进上诉操作
c. 配置Hikari连接池，改进上诉操作

##### 10.6 实现说明



### 第九课，高手题
4.1 将网关的frontend/backend/filter/router/线程池都改成Spring配置方式
4.2 基于AOP改造Netty网关，filter、router使用AOP实现
4.3 基于上述改造，将网关请求前后端分离，中间使用JMS传递消息
4.4 尝试使用ByteBuddy实现一个简单的基于类的AOP
4.5 尝试使用ByteBuddy与Instrument实现一个简单JavaAgent实现无侵入下的AOP
### 第十课，高手题
1. 基于AOP和自定义注解，实现MyCache(60)对于指定方法返回值缓存60s
2. 自定义实现一个数据库连接池，并整合Hibernate/Mybatis/Spring/Springboot
3. 基于Mybatis实现一个简单的分库分表+读写分离+分布式ID生成方案