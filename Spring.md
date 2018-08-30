## spring-framework
### IOC
The org.springframework.beans and org.springframework.context packages are the basis for Spring Framework’s IoC container. The BeanFactory interface provides an advanced configuration mechanism capable of managing any type of object. ApplicationContext is a sub-interface of BeanFactory. It adds easier integration with Spring’s AOP features; message resource handling (for use in internationalization), event publication; and application-layer specific contexts such as the WebApplicationContext for use in web applications.<br>

```
SingletonBeanRegistry --- void registerSingleton(String beanName, Object singletonObject);

AbstractBeanFactory --- protected <T> T doGetBean(final String name, @Nullable final Class<T> requiredType,@Nullable final Object[] args, boolean typeCheckOnly)

AbstractBeanFactory --- s("unchecked")
	protected <T> T doGetBean(final String name, @Nullable final Class<T> requiredType,@Nullable final Object[] args, boolean typeCheckOnly)

AbstractAutowireCapableBeanFactory --- Object createBean(String beanName, RootBeanDefinition mbd, @Nullable Object[] args)

SimpleInstantiationStrategy ---  Object instantiate(RootBeanDefinition bd, @Nullable String beanName, BeanFactory owner) //bean的实例化 
```


## spring cloud
### Sprng Cloud Netflix
@EnableDiscoveryClient looks for implementations of the DiscoveryClient interface via META-INF/spring.factories. Implementations of Discovery Client will add a configuration class to spring.factories under the org.springframework.cloud.client.discovery.EnableDiscoveryClient key. Examples of DiscoveryClient implementations: are Spring Cloud Netflix Eureka, Spring Cloud Consul Discovery and Spring Cloud Zookeeper Discovery.