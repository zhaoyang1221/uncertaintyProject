package com.xzy.uncertainty.service;

import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.IOException;

/**
 * @author Administrator on 2016/12/6 0006.
 */
public interface IFileService {
    boolean fileUpload(HttpServletRequest request, String local_path) throws IllegalStateException, IOException;

    boolean fileUpload(HttpServletRequest request, String local_path, MultipartFile multipartFile) throws IOException;
}
