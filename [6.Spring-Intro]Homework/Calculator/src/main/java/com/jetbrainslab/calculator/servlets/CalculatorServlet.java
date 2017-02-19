package com.jetbrainslab.calculator.servlets;

import com.jetbrainslab.calculator.enums.Operations;
import com.jetbrainslab.calculator.service.Service;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CalculatorServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Service service = new Service();
        double firstNumber = Double.valueOf(req.getParameter("firstNum"));
        double sercondNumber = Double.valueOf(req.getParameter("secondNum"));
        Operations operation = Operations.valueOf(req.getParameter("operation"));
        double result = service.calculate(firstNumber, sercondNumber, operation);
        resp.getWriter().print(result);
    }
}
