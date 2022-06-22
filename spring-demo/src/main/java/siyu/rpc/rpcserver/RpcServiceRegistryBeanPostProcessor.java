package siyu.rpc.rpcserver;

import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanPostProcessor;
import org.springframework.stereotype.Component;
import siyu.rpc.rpcannotation.RpcService;

import java.lang.annotation.Annotation;

/**
 * Rpc服务注册增强器
 */
@Component
public class RpcServiceRegistryBeanPostProcessor implements BeanPostProcessor {

	@Override
	public Object postProcessBeforeInitialization(Object bean, String beanName) throws BeansException {

		// 如果该bean有RpcService注解
		if (bean.getClass().isAnnotationPresent(RpcService.class)) {

			// 1.拿到RpcService uniqueId
			RpcService rpcServiceAnnotation = (RpcService) bean.getClass().getAnnotation(RpcService.class);
			String uniqueId = rpcServiceAnnotation.uniqueId();

			if (uniqueId.isEmpty()) {
				// 使用类名作为uniqueId
				uniqueId = beanName;
			}

			// TODO uniqueId -> bean映射配置到Mediator.ROUTER中

		}
		return bean;
	}
}
