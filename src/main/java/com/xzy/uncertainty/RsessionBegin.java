package com.xzy.uncertainty;

import org.math.R.Rsession;
import org.rosuda.REngine.REXP;
import org.rosuda.REngine.REXPList;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * @author Administrator on 2016/10/24 0024.
 */
public class RsessionBegin {
    public static void main(String args[]) throws REXPMismatchException {
        Rsession s = Rsession.newInstanceTry(System.out, null);
        s.sendFile(new File("D:\\zhaoyang\\Documents\\Workspace\\IdeaProjects\\uncertaintyProject\\src\\main\\resources\\dataset\\Kobe_Bryant.csv"));
        s.eval("Kobe <- read.csv(\"Kobe_Bryant.csv\")");
        s.eval("myvars <- c(\"G\", \"MP\", \"FG\", \"FGA\", \"X3P\", \"X3PA\", \"FT\", \"FTA\", \"ORB\", \"DRB\", \"AST\", \"STL\", \"BLK\", \"TOV\", \"PF\", \"PTS\")");
        s.eval("Kobe <- Kobe[myvars]");
        String[] summary = s.eval("summary(Kobe)").asStrings();
        String[] namesOfDim = s.eval("names(Kobe)").asStrings();
        Map<String, ArrayList<String>> map = new HashMap<String, ArrayList<String>>();
//        for (int i = 0; i<namesOfDim.length; i++) {
//            ArrayList<String> sub = new ArrayList<String>();
//            for (int j = 6*i; j <= 5+6*i; j++ ) {
//                sub.add(summary[j]);
//            }
//            map.put(namesOfDim[i], sub);
//        }
//        if (!s.isPackageInstalled("Hmisc", "4.0.0")) {
//            s.installPackage("Hmisc", true);
//        }
//        if (!s.isPackageLoaded("Hmisc")) {
//            s.loadPackage("Hmisc");
//        }
//        RList describeByKobe = s.eval("describe(Kobe)").asList();
//        describeByKobe.get(0);
//        System.out.println(describeByKobe.toString());
        s.end();
    }
}
