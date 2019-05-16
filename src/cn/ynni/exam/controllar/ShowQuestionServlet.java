package cn.ynni.exam.controllar;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ShowQuestionServlet extends HttpServlet {
    private int countPerPage = 2;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int page;
        try {
            page = Integer.valueOf(req.getParameter("page"));
        } catch (NumberFormatException e) {
            page = 1;
        }
        System.out.println(page);
    }
}
