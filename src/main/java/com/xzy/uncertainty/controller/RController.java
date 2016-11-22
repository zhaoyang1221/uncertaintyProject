package com.xzy.uncertainty.controller;

import com.xzy.uncertainty.service.IRService;
import org.rosuda.REngine.REXPMismatchException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.faces.flow.ReturnNode;
import java.util.List;

/**
 * @author Administrator on 2016/11/21 0021.
 */
@Controller
@RequestMapping("/RService")
public class RController {
    @Resource
    IRService rService;

    @ResponseBody
    @RequestMapping("/dimensionSummary")
    public List DimensionSummary() throws REXPMismatchException {
        return rService.getDimensionSummary();
    }
}
