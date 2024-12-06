package com.app.serviceimpl;


import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.app.model.Document;
import com.app.repository.DocumentRepository;
import com.app.service.DocumentService;
@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
	private DocumentRepository documentrepository;
	

	@Override
	public String saveDocuments(Document doc) {
		String docid = UUID.randomUUID().toString().toUpperCase();
           doc.setDocumentId(docid);
		Document document = documentrepository.save(doc);

		return "Your Document are Uploaded Successfully" +":"+  docid;
	}

}
