package project01.ui;

import com.alibaba.fastjson.JSON;
import project01.dto.EmpDto;
import project01.entriy.Emp;
import project01.service.UserImpl.uerImp;
import project01.service.UserSver;
import project01.utils.TableResult;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
@WebServlet("/layui/page/list")
public class Emplist extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       this.doPost(req,resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/json;charset=utf-8");
        PrintWriter out = resp.getWriter();
        String page=req.getParameter("page");
        String limit=req.getParameter("limit");
        System.out.println(page);
        System.out.println(limit);
        String searchParams = req.getParameter("searchParams");
        System.out.println(searchParams);
        EmpDto empDto = JSON.parseObject(searchParams, EmpDto.class);
        UserSver userSver=new uerImp();
        Integer count = userSver.count(empDto);
        List<Emp> list = userSver.reAllemp(Integer.valueOf(page), Integer.valueOf(limit));
        TableResult result = new TableResult(0,"suc",count,list);
        String empJsonstr = JSON.toJSONString(result);
        out.print(empJsonstr);
    }
}
