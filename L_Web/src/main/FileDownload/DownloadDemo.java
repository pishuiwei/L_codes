package src.main.FileDownload;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;
import java.io.*;

/**
 * @WebServlet("/DownloadDemo") 中的‘/’一定要加
 */
@WebServlet("/DownloadDemo")
public class DownloadDemo extends HttpServlet {

    private long count;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        System.out.println("count:" + ++count);

        System.out.println("TestB!:" + this.getServletContext().getMimeType("pom.xml"));

        resp.setContentType(this.getServletContext().getMimeType("pom.xml"));
        resp.setHeader("Content-Disposition", "attachment;filename=pom.xml");

//      String fileName = req.getParameter("filename");
        String path = this.getServletContext().getRealPath("pom.xml");
//      String path = this.getServletContext().getMimeType(fileName);

        OutputStream out = resp.getOutputStream();
        InputStream in = new FileInputStream(path);
        byte[] buffer = new byte[1024];
        int len = 0;
        while((len=in.read(buffer)) != -1) {
            out.write(buffer, 0, len);
        }

//        out.close();
        in.close();

        System.out.println("A:" + this.getServletContext().getRealPath("pom.xml"));
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doGet(req, resp);
        System.out.println("TestA!");
    }
}

