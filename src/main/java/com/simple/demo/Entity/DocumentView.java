package com.simple.demo.Entity;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ByteArrayResource;
import org.springframework.core.io.Resource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@CrossOrigin
@RequestMapping("document")
public class DocumentView {
	
	
	@Autowired
	private DocumentRepository documentRepository;

	@GetMapping("/view/{id}")
	public ResponseEntity<Resource> downloadFile(@PathVariable("id") String id) {
		Optional<DocumentEntity> doc = documentRepository.findById(id);

		if (doc.isPresent()) {
			DocumentEntity fileUploadEntity = doc.get();
			if (!fileUploadEntity.getFileName().isEmpty()) {
				return ResponseEntity.ok().contentType(MediaType.parseMediaType(fileUploadEntity.getFileType()))
						.header(HttpHeaders.CONTENT_DISPOSITION,
								"attachment; filename=\"" + fileUploadEntity.getFileName() + "\"")
						.body(new ByteArrayResource(fileUploadEntity.getData()));
			}
		}

		return ResponseEntity.notFound().build();
	}

}
