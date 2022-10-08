package project01.ui;

import project01.entriy.User;

import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.concurrent.TimeUnit;
@WebServlet("/lanjie")
public class lanjie implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("loginFilter初始化");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
                    HttpServletRequest request = (HttpServletRequest) servletRequest;
        HttpSession session = request.getSession();
        User curentuser = (User) session.getAttribute("curentuser");
        if(curentuser!=null){
            filterChain.doFilter(servletRequest,servletResponse);
        }else {
            request.getRequestDispatcher("/mainui.html").forward(servletRequest,servletResponse);
        }
    }

    @Override
    public void destroy() {
        System.out.println("loginFilter销毁");
        try { TimeUnit.SECONDS.sleep(5); } catch (InterruptedException e) { e.printStackTrace(); }
    }
}
