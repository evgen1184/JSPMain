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
import java.util.List;
@WebServlet(name = "usersServlet", value = "/users-servlet")
public class UsersServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        UserService userService = new UserService();
        userService.printAllUsersToConsole();

        List<User> allUsers = userService.getAllUsers();
        request.setAttribute("users", allUsers);

        RequestDispatcher requestDispatcher = request.getRequestDispatcher("WEB-INF/users.jsp");
        requestDispatcher.forward(request, response);


}
    }
