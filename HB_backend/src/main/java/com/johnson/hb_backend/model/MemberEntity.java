package com.johnson.hb_backend.model;

import lombok.Data;

import javax.persistence.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.Objects;

@Data
@Entity
@Table(name = "member", schema = "hb")
public class MemberEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	@Basic
	@Column(name = "name")
	private String name;
	@Basic
	@Enumerated(EnumType.STRING)
	@Column(name = "gender")
	private Gender gender;
	@Basic
	@Column(name = "birth_date")
	private Date birthDate;
	@Basic
	@Column(name = "enrollment_year")
	private Integer enrollmentYear;
	@Basic
	@Column(name = "college_name")
	private String collegeName;
	@Basic
	@Column(name = "acl_name")
	private String aclName;
	@Basic
	@Column(name = "hometown")
	private String hometown;
	@Basic
	@Column(name = "email")
	private String email;
	@Basic
	@Column(name = "phone")
	private String phone;
	@Basic
	@Column(name = "created_at")
	private Timestamp createdAt;
	@Basic
	@Column(name = "img_url")
	private String imgUrl;

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		MemberEntity that = (MemberEntity) o;
		return id == that.id && Objects.equals(name, that.name) && Objects.equals(gender, that.gender) && Objects.equals(birthDate, that.birthDate) && Objects.equals(enrollmentYear, that.enrollmentYear) && Objects.equals(collegeName, that.collegeName) && Objects.equals(aclName, that.aclName) && Objects.equals(hometown, that.hometown) && Objects.equals(email, that.email) && Objects.equals(phone, that.phone) && Objects.equals(createdAt, that.createdAt) && Objects.equals(imgUrl, that.imgUrl);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, gender, birthDate, enrollmentYear, collegeName, aclName, hometown, email, phone, createdAt, imgUrl);
	}
}
