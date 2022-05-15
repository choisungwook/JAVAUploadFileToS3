package com.s3.demo;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Slf4j
public class DemoController {
    private final AWSS3Serrvice awsS3Service;

    @PostMapping("/upload")
    public String uploadFile(@RequestPart List<MultipartFile> multipartFile) {
        try {
            awsS3Service.uploadFiles(multipartFile);
        } catch (Exception e){
            log.error(String.format("error: %s", e.toString()));
            return "Error";
        }

        return "Done";
    }
}
