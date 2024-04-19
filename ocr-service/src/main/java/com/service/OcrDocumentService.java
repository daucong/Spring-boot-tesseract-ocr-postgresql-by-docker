package com.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import com.model.OcrDocument;
import com.repository.OcrDocumentRepository;

@Service
@RequiredArgsConstructor
public class OcrDocumentService {
    private final OcrDocumentRepository ocrDocumentRepository;

    public OcrDocument saveDocument(OcrDocument document) {
        return ocrDocumentRepository.save(document);
    }

    public Iterable<OcrDocument> saveListDocument(Iterable<OcrDocument> document) {
        return ocrDocumentRepository.saveAll(document);
    }

    public OcrDocument findById(String id) {
        return ocrDocumentRepository.findById(id).orElse(null);
    }

    public Iterable<OcrDocument> findAll() {
        return ocrDocumentRepository.findAll();
    }

    public void delete(String id) {
        ocrDocumentRepository.deleteById(id);
    }
}
