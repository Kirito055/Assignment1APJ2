
import model.AboutFile;

import java.io.*;
import java.util.ArrayList;
import java.util.Objects;
import javax.servlet.ServletException;
import javax.servlet.http.*;
import javax.servlet.annotation.*;

@WebServlet(name = "helloServlet", value = "/hello-servlet")
public class PrintServlet extends HttpServlet {

    public void doGet(HttpServletRequest req, HttpServletResponse resp) throws IOException {
        try {
            String  path = "C:\\Users\\82530\\txtfiles";

            File file = new File(path);
            ArrayList<AboutFile> files = new ArrayList<>();
            for (File file1 : Objects.requireNonNull(file.listFiles())) {
                System.out.println(file1.getName());
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
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String  str= req.getParameter("searchtext");
        String  path= req.getParameter("searchFile");
        File file=new File(path);
        AboutFile aboutFile=new AboutFile();
        ArrayList<AboutFile> arrayList=aboutFile.getFiles(file,str);
        req.setAttribute("ListFile",arrayList);
        req.setAttribute("Path",path);
        req.getRequestDispatcher("/index.jsp").forward(req, resp);
    }

    public void destroy() {
    }
}