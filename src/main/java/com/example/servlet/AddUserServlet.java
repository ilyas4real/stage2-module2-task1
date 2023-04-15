package com.example.servlet;

import com.example.User;
import com.example.Warehouse;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

public class AddUserServlet extends HttpServlet{
    //write your code here!
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        RequestDispatcher rd = req.getRequestDispatcher("/add.jsp");
        rd.forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        PrintWriter out = resp.getWriter();

        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");

        User user = new User(firstName, lastName);
        Warehouse.getInstance().addUser(user);

        req.setAttribute("user", user);
        RequestDispatcher rd = req.getRequestDispatcher("/add.jsp");
        rd.forward(req, resp);
    }

}
