package cn.ynni.exam.controllar;

import cn.ynni.exam.model.Paper;
import cn.ynni.exam.model.Question;
import cn.ynni.exam.service.PaperService;
import cn.ynni.exam.service.QuestionService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;

public class SelectQuestionServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.setCharacterEncoding("UTF-8");
        resp.setContentType("text/html;charset=UTF-8");

        String paperId = req.getParameter("paperId");

        QuestionService questionService = new QuestionService();
        ArrayList<Question> questionArrayList = questionService.selectQuestion(Integer.parseInt(paperId));

        PaperService paperService = new PaperService();
        ArrayList<Paper> paperArrayList = paperService.selectPerpar();

        req.setAttribute("questionArrayList", questionArrayList);
        req.setAttribute("paperArrayList", paperArrayList);

        req.getRequestDispatcher("ModifyTest.jsp").forward(req, resp);
    }
}
