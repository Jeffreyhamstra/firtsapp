package nl.hu.v1wac.firstapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//@WebServlet(urlPatterns = "/CalculatorServlet.do")


public class RekenmachineJs extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer n1 = Integer.parseInt(req.getParameter("n1"));
		Integer n2 = Integer.parseInt(req.getParameter("n2"));
		Integer n3 = Integer.parseInt(req.getParameter("n2"));
		Integer n4 = Integer.parseInt(req.getParameter("n2"));
		Integer n5 = Integer.parseInt(req.getParameter("n2"));
		Integer n6 = Integer.parseInt(req.getParameter("n2"));
		Integer n7 = Integer.parseInt(req.getParameter("n2"));
		Integer n8 = Integer.parseInt(req.getParameter("n2"));
		Integer n9 = Integer.parseInt(req.getParameter("n2"));
		Integer n0 = Integer.parseInt(req.getParameter("n2"));
		
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println(" <title>Rekenmachine</title>");
		out.println(" <body>");
		out.println(" <h2>Rekenmachine</h2>");
		out.println(" </body>");
		out.println("</html>");


	}
}
