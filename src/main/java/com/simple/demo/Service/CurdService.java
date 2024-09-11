package com.simple.demo.Service;

import java.io.File;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Optional;
import java.util.StringTokenizer;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.core.io.Resource;
import org.springframework.core.io.ResourceLoader;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.simple.demo.Entity.CurdEntity;
import com.simple.demo.Entity.DocumentRepository;
import com.simple.demo.Entity.EmailService;
import com.simple.demo.dto.RequestDto;
import com.simple.demo.dto.ResponseModel;
import com.simple.demo.repository.CurdRepository;
import com.simple.demo.utils.FileUtils;

import jakarta.servlet.ServletContext;
import jakarta.servlet.http.HttpServletRequest;

@Service
public class CurdService {
	
	private final Logger logger = LoggerFactory.getLogger(this.getClass());
	@Autowired
	private CurdRepository repository;
	
	@Autowired
	private DocumentRepository documentRepository;
	
	@Autowired
	ServletContext context;
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
			 model.setImage(saveImage(dto.getImage()));
			 
			 
//			 
//			 DocumentEntity doc=new DocumentEntity();
//			 doc.setData(dto.getImage().getBytes());
//			 doc.setFileName(dto.getImage().getOriginalFilename());
//			 doc.setFileType(dto.getImage().getContentType());
//			 documentRepository.save(doc);
//			 
//			 if(!dto.getImage().getOriginalFilename().equalsIgnoreCase("blob")) {
//				 model.setImgae(doc);
//			 }
//			 
//			 String folder = new FileUtils().genrateFolderName(" " + dto.getMobileNumber().trim().substring(0, 4));
//
//				String extensionType = null;
//
//				StringTokenizer st = new StringTokenizer(dto.getProfilePic().getOriginalFilename());
//
//				while (st.hasMoreElements()) {
//					extensionType = st.nextElement().toString();
//				}
//
//				String fileName = FileUtils.getRandomString() + "." + extensionType;
//				model.setProfilePic(folder + "/" + fileName);
//
//
//				Path currentworkingDir = Paths.get(context.getRealPath("/WEB-INF"));
//				File saveFile = new File(currentworkingDir + "/adminuser/" + folder);
//				saveFile.mkdir();
//
//				byte[] bytes = dto.getProfilePic().getBytes();
//				Path path = Paths.get(saveFile + "/" + fileName);
//				System.out.println(path);
//				Files.write(path, bytes);
			 
			 
			 	
			 
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
	
	
	
	private String saveImage(MultipartFile profilePhoto) throws Exception{
		
			String extensionType = null;
			StringTokenizer st = new StringTokenizer(profilePhoto.getOriginalFilename(), ".");
			while (st.hasMoreElements()) {
				extensionType = st.nextElement().toString();
			}
			String fileName = FileUtils.getRandomString() + "." + extensionType;

			Path currentWorkingDir = Paths.get(context.getRealPath("/WEB-INF/"));
			File saveFile = new File(currentWorkingDir + "/images/");
			saveFile.mkdir();

			byte[] bytes = profilePhoto.getBytes();
			Path path = Paths.get(saveFile + "/" + fileName);
			Files.write(path, bytes);
			return fileName;
		
	}

	public ResponseEntity<Resource> viewimage(int id, HttpServletRequest request) {
		try {

			Optional<CurdEntity>optModel=repository.findById(id);

			if (optModel.isPresent() && optModel.get().getImage() != null) {

				final Resource resource = resourceLoader
						.getResource("/WEB-INF/images/" + optModel.get().getImage());
				String contentType = null;

				contentType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

				// Fallback to the default content type if type could not be determined
				if (contentType == null) {
					contentType = "application/octet-stream";
				}
				return ResponseEntity.ok().contentType(MediaType.parseMediaType(contentType))
						.header(HttpHeaders.CONTENT_DISPOSITION,
								"attachment; filename=\"" + resource.getFilename() + "\"")
						.body(resource);
			} else {
				return null;
			}

		} catch (Exception e) {
			return null;
		}
	}
	
	
	
	
}

	