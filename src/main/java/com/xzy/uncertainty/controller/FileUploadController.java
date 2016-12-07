package com.xzy.uncertainty.controller;

import com.xzy.uncertainty.service.IFileService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import sun.util.resources.cldr.pa.LocaleNames_pa;

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

    @Value("${local_path}")
    private String local_path;

    @ResponseBody
    @RequestMapping(value = "/fileUpload", method = RequestMethod.POST)
    public String fileUpload(HttpServletRequest request) throws IllegalStateException, IOException {
        return fileUploadService.fileUpload(request, local_path);
    }

}
