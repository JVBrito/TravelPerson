package org.travel.person.bean;

import java.io.Serializable;
import java.util.List;

import org.travel.person.dao.DocumentDAO;
import org.travel.person.model.Document;

import jakarta.enterprise.context.SessionScoped;
import jakarta.inject.Inject;
import jakarta.inject.Named;

@Named
@SessionScoped
public class DocumentBean implements Serializable {

    private static final long serialVersionUID = 1L;

    private Document document = new Document();
    private List<Document> documents;

    private DocumentDAO documentDAO;
    
    @Inject
    public DocumentBean(DocumentDAO documentDAO) {
		super();
		this.documentDAO = documentDAO;
	}

	public void save() {
        if (document.getId() == 0) {
            documentDAO.save(document);
        } else {
            documentDAO.update(document);
        }
        document = new Document();
        documents = null;
    }

    public void delete(Document document) {
        documentDAO.delete(document);
        documents = null;
    }

    public List<Document> getDocuments() {
        if (documents == null) {
            documents = documentDAO.findAll();
        }
        return documents;
    }

    public Document getDocument() {
        return document;
    }

    public void setDocument(Document document) {
        this.document = document;
    }
}
