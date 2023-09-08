package com.johnson.hb_backend;

import com.johnson.hb_backend.controller.MemberController;
import com.johnson.hb_backend.model.MemberEntity;
import com.johnson.hb_backend.service.MemberService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

@SpringBootTest
class HbBackendApplicationTests {

	@Autowired
	private MemberController memberController;

}
