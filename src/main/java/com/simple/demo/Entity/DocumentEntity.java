package com.simple.demo.Entity;

import org.hibernate.annotations.UuidGenerator;

import com.fasterxml.jackson.annotation.JsonProperty;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.Table;

@Entity
@Table(name="document_entity")
public class DocumentEntity {
	
	

	@Id
	@UuidGenerator
	@Column(name = "file_id")
	private String fileId;
	
	
	@Column(name = "file_name")
	private String fileName;
	
	
	@Column(name = "file_type")
	private String fileType;
	
	@Column(name = "data", length = 2000000)
	@Lob
	@JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
	private byte[] data;

	public String getFileId() {
		return fileId;
	}

	public void setFileId(String fileId) {
		this.fileId = fileId;
	}

	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	public String getFileType() {
		return fileType;
	}

	public void setFileType(String fileType) {
		this.fileType = fileType;
	}

	public byte[] getData() {
		return data;
	}

	public void setData(byte[] data) {
		this.data = data;
	}
	
	

}
