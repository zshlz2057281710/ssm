package project01.ui;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
@WebServlet("/ajax01")
public class Ajaxtest extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setHeader("Access-Control-Allow-Origin", "*");
        resp.setHeader("Access-Control-Expose-Headers", "*");
        resp.setHeader("Access-Control-Allow-Methods", "*");
        PrintWriter writer = resp.getWriter();
        String username = req.getParameter("username");
        System.out.println("server端收到---->" + username);
        if("admin".equals(username)){//存在
            writer.print(true);
        }else{
            writer.print(false);
        }
    }
}
