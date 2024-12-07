package com.example.Advanced_Security.Controller;

import com.example.Advanced_Security.Entity.UploadedFile;
import com.example.Advanced_Security.Service.FileService;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RestController
@RequestMapping("/files")
public class FileController {

    private final FileService fileService;

    public FileController(FileService fileService) {
        this.fileService = fileService;
    }

    @PostMapping("/upload")
    public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
        try {
            fileService.saveFile(file);
            return ResponseEntity.ok("File uploaded successfully");
        } catch (IOException e) {
            return ResponseEntity.status(500).body("Could not upload file: " + e.getMessage());
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<byte[]> getFile(@PathVariable Long id) {
        UploadedFile uploadedFile = fileService.getFile(id);

        return ResponseEntity.ok()
                .contentType(MediaType.parseMediaType(uploadedFile.getFileType()))
                .header(HttpHeaders.CONTENT_DISPOSITION, "attachment; filename=\"" + uploadedFile.getFileName() + "\"")
                .body(uploadedFile.getFileData());
    }
}
