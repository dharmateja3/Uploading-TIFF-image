package com.spring.ImageUpload1.controller;

import com.spring.ImageUpload1.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Controller
public class ImageController {

    private static final long MAX_FILE_SIZE = 100 * 1024 * 1024; // 100MB

    @Autowired
    private ImageService imageService;

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @PostMapping("/upload")
    public String uploadImage(@RequestParam("file") MultipartFile file, Model model) {
        if (file.getSize() > MAX_FILE_SIZE) {
            model.addAttribute("message", "File size exceeds the 100MB limit!");
            return "index";
        }
        try {
            imageService.saveImage(file);
            model.addAttribute("message", "File uploaded successfully!");
        } catch (IOException e) {
            model.addAttribute("message", "File upload failed!");
        }
        return "index";
    }
}
