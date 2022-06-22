package siyu.rpc.service.impl;

import org.springframework.stereotype.Service;
import siyu.rpc.rpcannotation.RpcService;
import siyu.rpc.service.PersonService;

@RpcService(uniqueId = "teacherService")
@Service
public class TeacherServiceImpl implements PersonService {
	@Override
	public String hello() {
		return "[teacher service]: i am a teacher";
	}
}
