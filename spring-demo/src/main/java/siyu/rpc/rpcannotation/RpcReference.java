package siyu.rpc.rpcannotation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD) // 只能字段注解
public @interface RpcReference {
	String uniqueId() default "";
}
