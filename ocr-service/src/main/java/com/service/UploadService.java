package com.service;

import lombok.RequiredArgsConstructor;
import net.sourceforge.tess4j.Tesseract;
import net.sourceforge.tess4j.TesseractException;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import com.model.OcrDocument;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

@Service
@RequiredArgsConstructor
public class UploadService {
    private final Tesseract tesseract;
    private final OcrDocumentService ocrDocumentService;

    public String ocr(String language, MultipartFile file) {
        try {
            File convFile = convert(file);
            tesseract.setLanguage(language);
            System.loadLibrary("tesseract");
            String text = tesseract.doOCR(convFile);
            OcrDocument ocrResult = new OcrDocument();
            ocrResult.setNoiDung(text);
            ocrDocumentService.saveDocument(ocrResult);

            return ocrResult.getNoiDung();
        } catch (TesseractException | IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static File convert(MultipartFile file) throws IOException {
        String relativePath = "tesseract-ocr/file";
        String absolutePath = "/opt/" + relativePath;
        File convFile = new File(absolutePath, file.getOriginalFilename());
        FileOutputStream fos = new FileOutputStream(convFile);
        fos.write(file.getBytes());
        fos.close();
        return convFile;
    }
}
