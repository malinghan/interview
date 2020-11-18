### Maven的Profile机制
- Profile能让你为一个特殊的环境自定义一个特殊的构建。
profile使得不同环境间构建的可移植性成为可能。
Maven中的profile是一组可选的配置，可以用来设置或者覆盖配置默认值。
有了profile，你就可以为不同的环境定制构建。

```xml
<project>
   <profiles>
       <profile>
           <build>
               <defaultGoal>...</defaultGoal>
               <finalName>...</finalName>
               <resources>...</resources>
               <testResources>...</testResources>
               <plugins>...</plugins>
           </build>
           <reporting>...</reporting>
           <modules>...</modules>
           <dependencies>...</dependencies>
           <dependencyManagement>...</dependencyManagement>
           <distributionManagement>...</distributionManagement>
           <repositories>...</repositories>
           <pluginRepositories>...</pluginRepositories>
           <properties>...</properties>
       </profile>
   </profiles>
</project>  
```
一个Profile可以覆盖项目构件的最终名称，项目依赖，插件配置以影响构建行为，Profile还可以覆盖分发配置。
maven提供了一种针对不同环境参数“激活”一个profile的方式，这就叫做profile激活。

> 使用-P参数显示的激活一个profile

我们在进行Maven操作时就可以使用-P参数显示的指定当前激活的是哪一个profile了。比如我们需要在对项目进行打包的时候使用id为profileTest1的profile，我们就可以这样做：

```
mvn package –P profileTest1 
```



### Spring Boot的支持

SpringBoot使用一个全局的配置文件application.properties或application.yml，
配置文件路径：src/main/resource目录下或类路径下的/config下。

```
#properties格式
spring.profiles.active=dev
```

也可以在启动应用的时候添加启动参数--spring.profiles.active=dev。

>（️Spring Boot的Profile机制和Maven的其实是没关系的，文末给出了一篇博客，讲解了如何将Maven的Profile机制与Spring Boot的active profile机制同步，未验证）

### 微服务环境下的配置文件(配置中心)
前面介绍的两种方式，配置文件都显式的暴露在项目中，这对于实际运营的项目，是有比较多的问题的：

1. 对于在线运营的项目有安全隐患，数据库等信息都会暴露出来，给产品的安全带来很大的隐患
2. 对于微服务场景，不利于维护
  - （1）配置分散在不同的项目中，不利于统一管理
  - （2）配置和代码处于同一个版本体系下，不利于版本管理
  - （3）多个系统共同使用的配置更改时，需要一处处去修改，非常麻烦，容易出错
  - （4）对于动态配置的文件，也不利于OPS维护

因此，业界普遍采用了`Config Server`的方式，Spring Cloud提供了`Spring Cloud Config`的组件，帮助我们管理微服务的配置

### spring与maven的profile集成
- 第一步：在pom中添加profiles


```xml
 <profiles>
        <profile>
            <id>local</id>
            <activation>
                <activeByDefault>true</activeByDefault>
            </activation>
            <properties>
                <profileActive>local</profileActive>
            </properties>
        </profile>
        <profile>
            <id>prod</id>
            <properties>
                <profileActive>prod</profileActive>
            </properties>
        </profile>
    </profiles>
```    
- 第二步: 在application.properties中定义

```
spring.profiles.active=@spring.profiles.active@
```


### 参考链接
- https://www.cnblogs.com/softidea/p/6375806.html
- https://stackoverflow.com/questions/42390860/configure-active-profile-in-springboot-via-maven