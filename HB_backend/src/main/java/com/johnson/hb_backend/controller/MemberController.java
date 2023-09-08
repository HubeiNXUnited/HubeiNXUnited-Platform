package com.johnson.hb_backend.controller;

import com.johnson.hb_backend.model.MemberEntity;
import com.johnson.hb_backend.service.MemberService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/members") // 请求路径
public class MemberController {

	private final MemberService memberService;

	@Autowired
	public MemberController(MemberService memberService) {
		this.memberService = memberService;
	}

	@GetMapping("/all")
	public List<MemberEntity> getAllMembers() {
		return memberService.getAllEntities();
	}

}
