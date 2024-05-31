package com.spring.ImageUpload1.service;

import com.spring.ImageUpload1.entity.Image;

import com.spring.ImageUpload1.repository.ImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@Service
public class ImageService {

    @Autowired
    private ImageRepository imageRepository;

    public void saveImage(MultipartFile file) throws IOException {
        Image image = new Image(file.getOriginalFilename(), file.getBytes());
        imageRepository.save(image);
    }
}

