/**
 * Siyu Tao
 * Copyright (c) 2015-2022 All Rights Reserved.
 */
package siyu.rpc.rpcclient;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.BeanFactory;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.beans.factory.support.BeanDefinitionBuilder;
import org.springframework.beans.factory.support.BeanDefinitionRegistry;
import org.springframework.stereotype.Component;
import org.springframework.util.ClassUtils;
import org.springframework.util.ReflectionUtils;
import siyu.rpc.rpcannotation.RpcReference;

import java.lang.reflect.Field;
import java.util.HashMap;
import java.util.Map;

/**
 * 对所有@RpcReference注解字段进行代理对象生成以及BeanDefinition添加
 */
@Component
public class RpcReferenceInjectBeanFactoryPostProcessor implements BeanFactoryPostProcessor {

	private BeanFactory beanFactory;

	private Map<String, BeanDefinition> beanDefinitions = new HashMap<>();

	private BeanDefinitionRegistry registry;

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

		this.beanFactory = beanFactory;

		/** 遍历所有beanDefinition 查找带有@RpcReference注解字段 */
		for (String beanName: beanFactory.getBeanDefinitionNames()) {

			BeanDefinition beanDefinition = beanFactory.getBeanDefinition(beanName);
			String beanClassName = beanDefinition.getBeanClassName();

			// TODO @Bean如果返回类型是Object beanClassName为null？测试一下
			if (beanClassName != null) {
				Class<?> clazz = ClassUtils.resolveClassName(beanClassName, this.getClass().getClassLoader());
				ReflectionUtils.doWithFields(clazz, this::parseFields);
			}
		}

		this.registry = (BeanDefinitionRegistry) beanFactory;
		this.beanDefinitions.forEach(this::registyRpcReference);

	}

	/**
	 * 作为callback使用
	 * 如果字段带有@RpcReference注解 对该字段生成一个beanDefinition(FactoryBean)
	 *
	 * @param field
	 */
	private void parseFields(Field field) {
		RpcReference annotation = field.getAnnotation(RpcReference.class);

		if (annotation == null) return ;

		// 装配BeanDefinition
		BeanDefinitionBuilder builder = BeanDefinitionBuilder.genericBeanDefinition(RpcReferenceBean.class);
		builder.setInitMethodName("init");
		builder.addPropertyValue("type", field.getType());
		builder.addPropertyReference("uniqueId", annotation.uniqueId()); // 记得传入uniqueId

		BeanDefinition beanDefinition = builder.getBeanDefinition();

		this.beanDefinitions.put(field.getName(), beanDefinition);

	}

	/**
	 * 注册字段代理对象definition到beanFactory
	 *
	 * @param beanName
	 * @param beanDefinition
	 */
	private void registyRpcReference(String beanName, BeanDefinition beanDefinition) {

		if (this.beanFactory.containsBean(beanName)) {
			throw new IllegalArgumentException("[rpc reference registry] spring context already has a bean named " + beanName +
					"please change @RpcReference field name");
		}

		this.registry.registerBeanDefinition(beanName, beanDefinition);

		System.out.printf("beanName为{0}的RpcReference服务注册definition成功%n", beanName);

	}
}
