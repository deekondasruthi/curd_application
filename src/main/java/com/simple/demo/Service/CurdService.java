package com.simple.demo.Service;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
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
import org.springframework.core.io.UrlResource;
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
		
			 
			 model.setImage(eventImage(dto.getImage()));
			 
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

				Path filePath = Paths.get(getfileFolder() + "/image/").resolve(optModel.get().getImage() );
				Resource resource = new UrlResource(filePath.toUri());
				String extensionType = null;

				extensionType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

				// Check if the file exists
				if (resource.exists() || resource.isReadable()) {
					return ResponseEntity.ok().header(org.apache.tika.metadata.HttpHeaders.CONTENT_TYPE, extensionType) // Adjust																						// needed
							.body(resource);
				} 
			} else {
				return null;
			}

		} catch (Exception e) {
			return null;
		}
		return null;
	}
	
	

	public static String eventImage(MultipartFile image) throws IOException {
		String extensionType = null;

		StringTokenizer st = new StringTokenizer(image.getOriginalFilename());

		while (st.hasMoreElements()) {
			extensionType = st.nextElement().toString();
		}
		String fileName = FileUtils.getRandomString() + "." + extensionType;

		Path currentworkingDir = Paths.get(getfileFolder());
		File saveFile = new File(currentworkingDir + "/image");
		saveFile.mkdir();

		byte[] bytes = image.getBytes();
		Path path = Paths.get(saveFile + "/" + fileName);

		Files.write(path, bytes);

		return fileName;
	}

	public static byte [] viewEventImage(String image, HttpServletRequest request) throws IOException {
		try {

			Path filePath = Paths.get(getfileFolder() + "/image/").resolve(image);
			Resource resource = new UrlResource(filePath.toUri());
			String extensionType = null;

			extensionType = request.getServletContext().getMimeType(resource.getFile().getAbsolutePath());

			// Check if the file exists
			if (resource.exists() || resource.isReadable()) {
				return Files.readAllBytes(ResponseEntity.ok().header(org.apache.tika.metadata.HttpHeaders.CONTENT_TYPE, extensionType) // Adjust																						// needed
						.body(resource).getBody().getFile().toPath());
			} 
			return null;
		} catch (MalformedURLException e) {
			return null;
		}
	}
	

	public static String getfileFolder() {
		Path currentRelativePath = Paths.get("");
		File s = currentRelativePath.toAbsolutePath().toFile();
		File file = new File(s.getParent().indent(0));
		File parentDirectory = file.getParentFile();
		
		File saveFile = new File( "/opt/CrudDocuments" );
		saveFile.mkdir();
		return  "/opt/CrudDocuments" ;
	} 
	
	
}

	