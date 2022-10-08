package project01.ui;




import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.FileItemFactory;


import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.UUID;
@WebServlet("/upload")

public class Uploadsever extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        FileItemFactory factory=new DiskFileItemFactory();
        ServletFileUpload upload = new ServletFileUpload(factory);
        try {
            List<FileItem> fileItems = upload.parseRequest(req);

            for (FileItem fil:fileItems) {
                String name=fil.getFieldName();
                if("pp".equals(name)){
                    String xxname=fil.getName();
                 String extname=xxname.substring(xxname.lastIndexOf("."));
                 String newname= UUID.randomUUID()+extname;
                    File file=new File("d:/upload/"+newname);
                    fil.write(file);
                }else {
                    String value = fil.getString();
                    System.out.println("value=============>" + value);
                }
                }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
