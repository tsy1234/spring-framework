package siyu.rpc.service.impl;

import org.springframework.stereotype.Service;
import siyu.rpc.rpcannotation.RpcService;
import siyu.rpc.service.PersonService;

@RpcService(uniqueId = "studentService")
@Service
public class StudentServiceImpl implements PersonService {
	@Override
	public String hello() {
		return "[student service]: i am a student";
	}
}
