package com.xzy.uncertainty.controller;

import com.xzy.uncertainty.service.IFileService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Administrator on 2016/12/6 0006.
 */
@Controller
@RequestMapping("/fileService")
public class FileUploadController {
    @Resource
    private IFileService fileUploadService;

    @ResponseBody
    @RequestMapping("/fileUpload")
    public String fileUpload(HttpServletRequest request) throws IllegalStateException, IOException {
        return fileUploadService.fileUpload(request);
    }

}
