package com.web.vo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * Uploadfile entity. @author MyEclipse Persistence Tools
 */
@Entity
@Table(name = "uploadfile", catalog = "filedata")
public class Uploadfile implements java.io.Serializable {

	// Fields

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private Integer id;
	private String versionNum;
	private String filetype;
	private String upTime;
	private String author;

	// Constructors

	/** default constructor */
	public Uploadfile() {
	}

	/** full constructor */
	public Uploadfile(String versionNum, String filetype, String upTime,
			String author) {
		this.versionNum = versionNum;
		this.filetype = filetype;
		this.upTime = upTime;
		this.author = author;
	}

	// Property accessors
	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "Id", unique = true, nullable = false)
	public Integer getId() {
		return this.id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	@Column(name = "VersionNum", length = 20)
	public String getVersionNum() {
		return this.versionNum;
	}

	public void setVersionNum(String versionNum) {
		this.versionNum = versionNum;
	}

	@Column(name = "Filetype", length = 100)
	public String getFiletype() {
		return this.filetype;
	}

	public void setFiletype(String filetype) {
		this.filetype = filetype;
	}

	@Column(name = "UpTime", length = 100)
	public String getUpTime() {
		return this.upTime;
	}

	public void setUpTime(String upTime) {
		this.upTime = upTime;
	}

	@Column(name = "Author", length = 100)
	public String getAuthor() {
		return this.author;
	}

	public void setAuthor(String author) {
		this.author = author;
	}

}