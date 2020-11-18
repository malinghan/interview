`@SpringBootApplication` 注解中核心注解`@EnableAutoConfiguration`注解在starter起什么作用呢?

```java
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Inherited
@AutoConfigurationPackage
@Import(AutoConfigurationImportSelector.class)
public @interface EnableAutoConfiguration {
	String ENABLED_OVERRIDE_PROPERTY = "spring.boot.enableautoconfiguration";
	Class<?>[] exclude() default {};
	String[] excludeName() default {};
}
```

 可以从源码看出关键功能是

@import注解导入自动配置功能类`AutoConfigurationImportSelector`类，

主要方法`getCandidateConfigurations()`使用了`SpringFactoriesLoader.loadFactoryNames()`
方法加载`META-INF/spring.factories`的文件（`spring.factories`声明具体自动配置）。

```
protected List<String> getCandidateConfigurations(AnnotationMetadata metadata,
			AnnotationAttributes attributes) {
		List<String> configurations = SpringFactoriesLoader.loadFactoryNames(
				getSpringFactoriesLoaderFactoryClass(), getBeanClassLoader());
		Assert.notEmpty(configurations,
				"No auto configuration classes found in META-INF/spring.factories. If you "
						+ "are using a custom packaging, make sure that file is correct.");
		return configurations;
}
```

##### Q：通常情况下，starter会根据条件进行操作处理，比如根据不同条件创建不同Bean。在SpringBoot有哪些注解可用呢?

