package com.restcontroller;

import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import com.service.OcrDocumentService;
import com.service.UploadService;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class MyController {
    private final UploadService uploadService;
    private final OcrDocumentService ocrDocumentService;

    @GetMapping
    public ResponseEntity<?> findAll() {
        return ResponseEntity.ok(ocrDocumentService.findAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> findById(@PathVariable String id) {
        return ResponseEntity.ok(ocrDocumentService.findById(id));

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> delete(@PathVariable String id) {
        ocrDocumentService.delete(id);
        return ResponseEntity.ok("Delete myDocument successful!!!");
    }

    @PostMapping("/upload")
    public ResponseEntity<?> uploadFiles(@RequestParam(defaultValue = "vie") String language,
                                         @RequestParam MultipartFile file) {
        return ResponseEntity.ok(uploadService.ocr(language, file));
    }
}

