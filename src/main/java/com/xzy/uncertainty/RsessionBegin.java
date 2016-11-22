package com.xzy.uncertainty;

import org.math.R.Rsession;
import org.rosuda.REngine.REXPMismatchException;
import org.rosuda.REngine.RList;

import java.io.File;
import java.util.List;


/**
 * @author Administrator on 2016/10/24 0024.
 */
public class RsessionBegin {
    public static void main(String args[]) throws REXPMismatchException {
        Rsession s = Rsession.newInstanceTry(System.out, null);
        s.sendFile(new File("E:\\visualization\\IdeaProjects\\uncertaintyProject\\src\\main\\resources\\dataset\\Kobe_Bryant.csv"));
        s.eval("Kobe <- read.csv(\"Kobe_Bryant.csv\")");
        s.eval("myvars <- c(\"G\", \"MP\", \"FG\", \"FGA\", \"X3P\", \"X3PA\", \"FT\", \"FTA\", \"ORB\", \"DRB\", \"AST\", \"STL\", \"BLK\", \"TOV\", \"PF\", \"PTS\")");
        s.eval("Kobe <- Kobe[myvars]");
        List summary = s.eval("summary(Kobe)").asList();
        System.out.println(summary.get(0));
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
