package com.app.rest;


import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.app.model.Document;
import com.app.service.DocumentService;

@RestController
@RequestMapping(value = "/log-api")
public class DocumentController {

	@Autowired
	private DocumentService documentservice;

	public DocumentController(DocumentService documentservice) {
		super();
		this.documentservice = documentservice;
	}
	@PostMapping(value = "/documents")
	public ResponseEntity<String> uploadDocuments
	(@RequestPart MultipartFile adharCard,
			@RequestPart MultipartFile VotingCard,
			@RequestPart MultipartFile drivingLicence,
			@RequestPart MultipartFile PanCard) 
	{
		Document doc = new Document();
		try
		{
		doc.setAdharCard(adharCard.getBytes());
		doc.setDrivingLicence(drivingLicence.getBytes());
		doc.setPanCard(PanCard.getBytes());
		doc.setVotingCard(VotingCard.getBytes());
	}
		catch (IOException e) {
			e.getStackTrace();
		}
		String document =documentservice.saveDocuments(doc);
		return new ResponseEntity<String>(document, HttpStatus.CREATED);
	}
	
	
	/*
	 * @ExceptionHandler(value = IOException.class) public
	 * ResponseEntity<String>IOExceptionHandler(IOException ie) { String msg
	 * ="input Mismatch"; return new ResponseEntity<String>(msg, HttpStatus.OK);
	 * 
	 * }
	 */
	
}
