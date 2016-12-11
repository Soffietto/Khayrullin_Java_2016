package com.jetbrains.calculator.servlets;

import com.jetbrains.calculator.servlets.MainServlet;
import org.junit.BeforeClass;
import org.junit.Test;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class MainServletTest {
    private static HttpServletRequest req;
    private static HttpServletResponse resp;
    private static PrintWriter out;
    private static MainServlet mainServlet;
    private static final String PROPER_URI = "/calculator/5+6";
    private static final String ERROR_MESSAGE = "Permission denied";

    @BeforeClass
    public static void setUp() throws IOException {
        req = mock(HttpServletRequest.class);
        resp = mock(HttpServletResponse.class);
        mainServlet = new MainServlet();
        out = mock(PrintWriter.class);
        when(resp.getWriter()).thenReturn(out);
        when(req.getRequestURI()).thenReturn(PROPER_URI);
    }

    @Test
    public void doGetShouldTakeRequestURI() throws ServletException, IOException {
        mainServlet.doGet(req, resp);
        verify(req).getRequestURI();
    }

    @Test
    public void doPostShouldPrintErrorMsgAndSetStatus() throws IOException, ServletException {
        mainServlet.doPost(req, resp);
        verify(resp.getWriter()).print(ERROR_MESSAGE);
        verify(resp).setStatus(405);
    }
}
