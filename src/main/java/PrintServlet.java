
import model.AboutFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.servlet.ServletException;
import javax.servlet.http.*;

public class PrintServlet extends HttpServlet {

        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            try {
                String path = "";
                if (req.getParameter("fileRoot") == null) {
                    path = "C:\\Users\\82530\\txtfiles";
                } else {
                    path = req.getParameter("fileRoot");
                }
                File file = new File(path);
                ArrayList<AboutFile> files = new ArrayList<>();
                for (File file1 : file.listFiles()) {
                    files.add(new AboutFile(file1));
                }
                req.setAttribute("ListFile", files);
                req.setAttribute("Path", path);
                req.getRequestDispatcher("/index.jsp").forward(req, resp);
            }
            catch (Exception e){
                System.out.println(e);
                try {
                    throw new Exception("Something went wrong");
                } catch (Exception exception) {
                    exception.printStackTrace();
                }
            }
        }
        @Override
        protected void doPost( HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            String  str= req.getParameter("searchtext");
            String  path= req.getParameter("searchFile");
            File file=new File(path);
            AboutFile aboutFile=new AboutFile();
            ArrayList<AboutFile> arrayList=aboutFile.getFiles(file,str);
            req.setAttribute("ListFile",arrayList);
            req.setAttribute("Path",path);
            req.getRequestDispatcher("/index.jsp").forward(req, resp);
        }


    }
