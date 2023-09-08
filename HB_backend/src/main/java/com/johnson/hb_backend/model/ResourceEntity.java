package com.johnson.hb_backend.model;

import lombok.Data;

import javax.persistence.*;
import java.util.Objects;

@Data
@Entity
@Table(name = "resource_list", schema = "hb")
public class ResourceEntity {
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Id
	@Column(name = "id")
	private int id;
	@Basic
	@Column(name = "title")
	private String title;
	@Basic
	@Column(name = "brief")
	private String brief;
	@Basic
	@Column(name = "author")
	private String author;
	@Basic
	@Column(name = "link")
	private String link;
	@Basic
	@Column(name = "label")
	private String label;

	public void setId(int id) {
		this.id = id;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public void setBrief(String brief) {
		this.brief = brief;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

	public void setLink(String link) {
		this.link = link;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;
		ResourceEntity that = (ResourceEntity) o;
		return id == that.id && Objects.equals(title, that.title) && Objects.equals(brief, that.brief) && Objects.equals(author, that.author) && Objects.equals(link, that.link) && Objects.equals(label, that.label);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, brief, author, link, label);
	}
}
