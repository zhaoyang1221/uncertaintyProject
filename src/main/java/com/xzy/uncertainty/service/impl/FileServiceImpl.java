package com.xzy.uncertainty.service.impl;

import com.xzy.uncertainty.service.IFileService;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import org.springframework.web.multipart.commons.CommonsMultipartResolver;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.util.Iterator;

/**
 * @author Administrator on 2016/12/6 0006.
 */
@Service
public class FileServiceImpl implements IFileService {

    //  文件上传目录（这里设置为程序运行目录）
//    private String fileUploadDirectory = System.getProperty("user.dir");

    public String fileUpload(HttpServletRequest request, String local_path) throws IllegalStateException, IOException {
        File uploadDirectory = new File(local_path);
        if (!uploadDirectory.exists() && !uploadDirectory.isDirectory()) {
            System.out.println("上传目录不存在");
            if (uploadDirectory.mkdir()) {
                System.out.println("上传目录创建成功");
            } else {
                System.out.println("上传目录创建失败");
            }
        } else {
            System.out.println("上传目录已存在");
        }

//      将当前上下文初始化给 CommonsMultipartResolver (多部分解释器）
        CommonsMultipartResolver multipartResolver = new CommonsMultipartResolver(request.getSession().getServletContext());
//        检查form中是否有enctype="multipart/form-data"
        if (multipartResolver.isMultipart(request)) {
//          将request变成多部分request
            MultipartHttpServletRequest multipartHttpServletRequest = (MultipartHttpServletRequest) request;
//          获取multiRequest中所有文件名
            Iterator iterator = multipartHttpServletRequest.getFileNames();

            while (iterator.hasNext()) {
//              一次遍历所有文件
                MultipartFile file = multipartHttpServletRequest.getFile(iterator.next().toString());
                if (file != null) {
                    String path = local_path + File.separator + file.getOriginalFilename();
//                  将文件名保存到session中
                    request.getSession().setAttribute("fileName", file.getOriginalFilename());
//                  上传
                    file.transferTo(new File(path));
                }

            }
        }
        return "success";
    }
}
