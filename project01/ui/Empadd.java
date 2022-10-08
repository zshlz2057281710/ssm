package project01.ui;

import com.alibaba.fastjson.JSON;
import project01.entriy.Emp;
import project01.service.UserImpl.uerImp;
import project01.service.UserSver;
import project01.utils.Result;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet("/page/emp/add")
public class Empadd extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        PrintWriter out = resp.getWriter();
        Result result = new Result(0,"suc",null);

        try{


            String empno = req.getParameter("empno");
            String ename = req.getParameter("ename");
            String job = req.getParameter("job");
            String sal=req.getParameter("sal");



            Emp emp = new Emp(Integer.parseInt(empno),ename,job,Integer.parseInt(sal));
            UserSver userSver=new uerImp();
            userSver.add(emp);




        }catch (Exception e){
            result.setCode(1);
            result.setMsg("保存失败!");
        }finally {
            String jsonString = JSON.toJSONString(result);
            out.print(jsonString);
        }


    }
}