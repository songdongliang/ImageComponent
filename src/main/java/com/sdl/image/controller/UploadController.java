package com.sdl.image.controller;

import com.sdl.image.modle.FastDFSFile;
import com.sdl.image.modle.FileManager;
import org.csource.common.NameValuePair;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

@RequestMapping("upload")
@Controller
public class UploadController {

    @PostMapping("/image")
    @ResponseBody
    public String add(@RequestParam("file") MultipartFile attach) {
        // 获取文件后缀名
        String ext = attach.getOriginalFilename().substring(attach.getOriginalFilename().lastIndexOf(".") + 1);
        FastDFSFile file = null;
        try {
            file = new FastDFSFile(attach.getBytes(),ext);
        } catch (IOException e) {
            e.printStackTrace();
        }
        NameValuePair[] meta_list = new NameValuePair[4];
        meta_list[0] = new NameValuePair("fileName", attach.getOriginalFilename());
        meta_list[1] = new NameValuePair("fileLength", String.valueOf(attach.getSize()));
        meta_list[2] = new NameValuePair("fileExt", ext);
        meta_list[3] = new NameValuePair("fileAuthor", "songdongliang");
        String filePath = FileManager.upload(file,meta_list);
        System.out.println(filePath);
        return filePath;
    }
}
