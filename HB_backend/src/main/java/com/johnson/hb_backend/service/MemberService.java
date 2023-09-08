package com.johnson.hb_backend.service;

import com.johnson.hb_backend.model.MemberEntity;
import com.johnson.hb_backend.repository.MemberEntityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Month;
import java.util.List;

@Service
public class MemberService {
	private final MemberEntityRepository memberEntityRepository;

	@Autowired
	public MemberService(MemberEntityRepository memberEntityRepository) {
		this.memberEntityRepository = memberEntityRepository;
	}

	public List<MemberEntity> getAllEntities() {
		List<MemberEntity> memberEntityList = memberEntityRepository.findAll();

		LocalDate currentDate = LocalDate.now();
		int currentYear = currentDate.getYear();
		Month currentMonth = currentDate.getMonth();

		for (MemberEntity entity : memberEntityList) {
			int enrollmentYear = entity.getEnrollmentYear();

			int grade;
			if (currentMonth.compareTo(Month.SEPTEMBER) >= 0) {
				// 当前时间超过九月份
				grade = currentYear - enrollmentYear + 1;
			} else {
				// 当前时间不超过九月份
				grade = currentYear - enrollmentYear;
			}

			entity.setEnrollmentYear(grade);
		}

		return memberEntityList;
	}
}
