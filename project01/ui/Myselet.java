package project01.ui;

import com.alibaba.fastjson.JSON;
import com.mysql.cj.xdevapi.JsonString;
import project01.entriy.User;
import project01.service.UserImpl.uerImp;
import project01.utils.Result;


import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/log")
public class Myselet extends HttpServlet{

        @Override
        protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            this.doPost(req, resp);
        }

        @Override
        protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
            resp.setContentType("text/html;charset=utf-8");
//            req.setCharacterEncoding("utf-8");
            PrintWriter out = resp.getWriter();
            HttpSession session=req.getSession();
            String username=req.getParameter("username");
            String password=req.getParameter("pwd");
            System.out.println(username);
            System.out.println(password);
            User user1=new User(username,password);
            uerImp imp=new uerImp();
            boolean islogin = imp.islogin(user1);
            if(islogin){

                session.setAttribute("user",user1);
//                resp.sendRedirect("mainui.html");
                Result result=new Result(0,"success",null);
                String str = JSON.toJSONString(result);
                out.print(str);
            }else {
                Result result=new Result(1,"exerr",null);
                String str = JSON.toJSONString(result);
                out.print(str);
            }


        }



}
