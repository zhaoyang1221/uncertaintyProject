package com.xzy.uncertainty.controller;

import com.xzy.uncertainty.service.IRService;
import org.rosuda.REngine.REXPMismatchException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
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

    @ResponseBody
    @RequestMapping("/dimensionSummary")
    public Map DimensionSummary() throws REXPMismatchException {
        return rService.getDimensionSummary();
    }
}
