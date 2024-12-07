package com.example.Advanced_Security.Service;

import com.example.Advanced_Security.Entity.UploadedFile;
import com.example.Advanced_Security.Repository.UploadedFileRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@Service
public class FileService {

    private final UploadedFileRepository fileRepository;
    private static final List<String> ALLOWED_MIME_TYPES = Arrays.asList("image/png", "image/jpeg", "application/pdf");
    private static final long MAX_FILE_SIZE = 50 * 1024 * 1024; // 50 MB

    public FileService(UploadedFileRepository fileRepository) {
        this.fileRepository = fileRepository;
    }

    public UploadedFile saveFile(MultipartFile file) throws IOException {
        validateFile(file);

        UploadedFile uploadedFile = new UploadedFile();
        uploadedFile.setFileName(file.getOriginalFilename());
        uploadedFile.setFileType(file.getContentType());
        uploadedFile.setFileData(file.getBytes());
        return fileRepository.save(uploadedFile);
    }

    private void validateFile(MultipartFile file) {
        if (file.isEmpty()) {
            throw new IllegalArgumentException("Uploaded file is empty.");
        }

        if (!ALLOWED_MIME_TYPES.contains(file.getContentType())) {
            throw new IllegalArgumentException("Unsupported file type: " + file.getContentType());
        }

        if (file.getSize() > MAX_FILE_SIZE) {
            throw new IllegalArgumentException("File size exceeds the maximum limit of 5 MB.");
        }
    }

    public UploadedFile getFile(Long id) {
        return fileRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("File not found with id: " + id));
    }
}
