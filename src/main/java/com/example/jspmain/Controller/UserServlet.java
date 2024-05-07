package com.example.jspmain.Controller;

import com.example.jspmain.Entity.User;
import com.example.jspmain.Service.UserService;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;

@WebServlet(name = "userServlet", value = "/user-servlet")
public class UserServlet extends HttpServlet {

    UserService userService = new UserService();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        User userById = userService.getUserById(id);

        request.setAttribute("user", userById);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/user.jsp");
        requestDispatcher.forward(request, response);

    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        Integer id = Integer.parseInt(request.getParameter("id"));
        String newLogin = request.getParameter("logininput");
        String newPassword = request.getParameter("passwordinput");

        User userByid = userService.updateUser(id, newLogin, newPassword);

        request.setAttribute("user", userByid);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/user.jsp");
        requestDispatcher.forward(request, response);

    }
}
