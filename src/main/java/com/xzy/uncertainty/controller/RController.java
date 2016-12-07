package com.xzy.uncertainty.controller;

import com.xzy.uncertainty.service.IRService;
import org.rosuda.REngine.REXPMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.ejb.Local;
import javax.faces.flow.ReturnNode;
import javax.servlet.http.HttpServletRequest;
import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author Administrator on 2016/11/21 0021.
 */
@Controller
@RequestMapping("/RService")
public class RController {
    @Resource
    private IRService rService;

    @Value("${local_path}")
    private String local_path;

    @ResponseBody
    @RequestMapping(value = "/dimensionSummary", method = RequestMethod.GET)
    public Map DimensionSummary(HttpServletRequest request) throws REXPMismatchException {
        String fileName = (String)request.getSession().getAttribute("fileName");
        return rService.getDimensionSummary(local_path, fileName);
    }
}
