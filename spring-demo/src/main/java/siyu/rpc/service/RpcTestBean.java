/**
 * Siyu Tao
 * Copyright (c) 2015-2022 All Rights Reserved.
 */
package siyu.rpc.service;

import org.springframework.stereotype.Component;
import siyu.rpc.rpcannotation.RpcReference;

@Component
public class RpcTestBean {

	@RpcReference(uniqueId = "studentService")
	PersonService studentService;

	@RpcReference(uniqueId = "teacherService")
	PersonService teacherService;

	public void test() {
		System.out.println(studentService.hello());
		System.out.println(teacherService.hello());
	}
}
