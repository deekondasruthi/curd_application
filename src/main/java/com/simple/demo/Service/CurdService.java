package com.simple.demo.Service;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.Properties;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import com.simple.demo.Entity.AppConstants;
import com.simple.demo.Entity.CurdEntity;
import com.simple.demo.Entity.DocumentEntity;
import com.simple.demo.Entity.DocumentRepository;
import com.simple.demo.Entity.EmailService;
import com.simple.demo.dto.RequestDto;
import com.simple.demo.dto.ResponseModel;
import com.simple.demo.repository.CurdRepository;

import jakarta.activation.DataHandler;
import jakarta.activation.DataSource;
import jakarta.activation.FileDataSource;
import jakarta.mail.Authenticator;
import jakarta.mail.BodyPart;
import jakarta.mail.MessagingException;
import jakarta.mail.Multipart;
import jakarta.mail.PasswordAuthentication;
import jakarta.mail.Session;
import jakarta.mail.Transport;
import jakarta.mail.internet.MimeBodyPart;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.MimeMultipart;

@Service
public class CurdService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CurdRepository repository;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	
	@Autowired
	private Environment env;
	
	@Autowired
	private ResourceLoader resourceLoader;
	@Autowired
	private EmailService emailService;

	public ResponseModel create(RequestDto dto) {
		ResponseModel response=new ResponseModel();
	
			 CurdEntity model=new CurdEntity();
			 model.setName(dto.getName());
			 model.setAge(dto.getAge());
			 model.setBloodGroup(dto.getBloodGroup());
			 repository.save(model);
			 response.setFlag(1);
			 response.setResponse(model);
			 response.setResponseMessage("Success");
		
		return response;
	}

	public ResponseModel getAll() {
		
		ResponseModel response=new ResponseModel();
		List<CurdEntity>model=repository.findAll();
		if (!model.isEmpty()) {
			
			 response.setFlag(1);
			 response.setResponse(model);
			 response.setResponseMessage("Success");
		} else {
			 response.setFlag(2);
			 response.setResponseMessage("Data Not Found");

		}
		return response;
	}

	public ResponseModel update(int id, RequestDto dto) {
		ResponseModel response=new ResponseModel();
		Optional<CurdEntity>optModel=repository.findById(id);
		if (optModel.isPresent()) {
			CurdEntity model=optModel.get();
			model.setName(dto.getName());
			model.setAge(dto.getAge());
			model.setBloodGroup(dto.getBloodGroup());
			repository.save(model);
			
			 response.setFlag(1);
			 response.setResponse(model);
			 response.setResponseMessage("Success");
		} else {
			
			 response.setFlag(2);
			 response.setResponseMessage("Data Not Found");

		}
		return response;
	}

	public ResponseModel delete(int id) {
		ResponseModel response=new ResponseModel();
	repository.deleteById(id);
	response.setFlag(1);
	response.setResponseMessage("Succss");
		return response;
	}

	public ResponseModel getById(int id) {
		ResponseModel response=new ResponseModel();
		Optional<CurdEntity>optModel=repository.findById(id);
		if (optModel.isPresent()) {
			CurdEntity model=optModel.get();
			
			 response.setFlag(1);
			 response.setResponse(model);
			 response.setResponseMessage("Success");
		} else {
			
			 response.setFlag(2);
			 response.setResponseMessage("Data Not Found");

		}
		return response;
	}

	public ResponseModel addCreate(RequestDto dto) {
		// TODO Auto-generated method stub
		ResponseModel response=new ResponseModel();
		try {
			
			 CurdEntity model=new CurdEntity();
			 model.setName(dto.getName());
			 model.setAge(dto.getAge());
			 model.setEmailAddress(dto.getEmail());
			 model.setMobileNumber(dto.getMobileNo());
			 model.setBloodGroup(dto.getBloodGroup());
			 DocumentEntity doc=new DocumentEntity();
			 doc.setData(dto.getImage().getBytes());
			 doc.setFileName(dto.getImage().getOriginalFilename());
			 doc.setFileType(dto.getImage().getContentType());
			 documentRepository.save(doc);
			 if(!dto.getImage().getOriginalFilename().equalsIgnoreCase("blob")) {
				 model.setImgae(doc);
			 }
			 repository.save(model);
			 emailService.sendmail(model);
			 
			 response.setFlag(1);
			 response.setResponse(model);
			 response.setResponseMessage("Success");
		
			 return response;
			
		} catch (Exception e) {
			e.printStackTrace();
			response.setStatusCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
			response.setErrorMessage(e.getLocalizedMessage());
			response.setFlag(5);
			return response;
		}
	}
		
}

	