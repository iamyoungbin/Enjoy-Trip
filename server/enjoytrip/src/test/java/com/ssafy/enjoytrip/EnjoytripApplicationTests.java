package com.ssafy.enjoytrip;


import com.ssafy.enjoytrip.annotation.TestAnnotation;
import com.ssafy.enjoytrip.model.service.MemberServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@SpringBootTest
@EnableAspectJAutoProxy(proxyTargetClass = true)
class EnjoytripApplicationTests {

	@Autowired
	private MemberServiceImpl memberService;

	@TestAnnotation
	@Test
	public void contextLoads() throws Exception {
		System.out.println(memberService);
	}

}