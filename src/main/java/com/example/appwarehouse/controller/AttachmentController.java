package com.example.appwarehouse.controller;

import com.example.appwarehouse.payload.Result;
import com.example.appwarehouse.service.AttachmentService;
import jakarta.servlet.http.HttpServletResponse;
import lombok.SneakyThrows;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartHttpServletRequest;

@RestController
@RequestMapping("/attachment")
public class AttachmentController {

    @Autowired
    AttachmentService attachmentService;

    @SneakyThrows
    @PostMapping("/upload")
    public Result upload(MultipartHttpServletRequest request){
        return attachmentService.uploadfile(request);
    }

    @GetMapping("getFile/{id}")
    public void getFile(@PathVariable Integer id, HttpServletResponse response){
        attachmentService.getFile(id,response);
    }



}
