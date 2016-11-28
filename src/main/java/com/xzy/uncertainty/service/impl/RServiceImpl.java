package com.xzy.uncertainty.service.impl;


import com.xzy.uncertainty.service.IRService;
import org.apache.ibatis.io.Resources;
import org.math.R.Rsession;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPMismatchException;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import static org.math.R.Rsession.cast;

/**
 * @author Administrator on 2016/11/21 0021.
 */
@Service
public class RServiceImpl implements IRService{
    public Map<String, ArrayList<String>> getDimensionSummary() throws REXPMismatchException {
        Rsession s = Rsession.newInstanceTry(System.out, null);
        //获取项目路径
//        String courseFile = System.getProperty("user.dir");

//        s.sendFile(new File("E:\\visualization\\IdeaProjects\\uncertaintyProject\\src\\main\\R\\Kobe_Bryant.csv"));
        s.sendFile(new File("D:\\zhaoyang\\Documents\\Workspace\\IdeaProjects\\uncertaintyProject\\src\\main\\R\\Kobe_Bryant.csv"));
        s.eval("Kobe <- read.csv(\"Kobe_Bryant.csv\")");
        s.eval("myvars <- c(\"G\", \"MP\", \"FG\", \"FGA\", \"X3P\", \"X3PA\", \"FT\", \"FTA\", \"ORB\", \"DRB\", \"AST\", \"STL\", \"BLK\", \"TOV\", \"PF\", \"PTS\")");
        s.eval("Kobe <- Kobe[myvars]");
        String[] summary = s.eval("summary(Kobe)").asStrings();
        String[] namesOfDim = s.eval("names(Kobe)").asStrings();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
        for (int i = 0; i<namesOfDim.length; i++) {
            ArrayList<String> sub = new ArrayList<String>();
            for (int j = 6*i; j <= 5+6*i; j++ ) {
                sub.add(summary[j]);
            }
            map.put(namesOfDim[i], sub);
        }

        return map;
    }
}
