package nl.hu.v1wac.firstapp;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(urlPatterns = "/CalculatorServlet.do")

public class CalculatorServlet extends HttpServlet {
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		Integer n1 = Integer.parseInt(req.getParameter("n1"));
		Integer n2 = Integer.parseInt(req.getParameter("n2"));

		String act = req.getParameter("act");
		int antwoord = 0;
		String som = "";
		if (n1 == 0 || n2 == 0) {
			som = "Mag geen 0 invoeren";
		} else if (act == null ) {
		    som = "Invoer ontbreekt";
		} else if (act.equals("aftellen")) {
			antwoord = n1 - n2;
			som = n1 + " - " + n2 + " = " + antwoord;
		} else if (act.equals("optellen")) {
			antwoord = n1 + n2;
			som = n1 + " + " + n2 + " = " + antwoord;
		} else if (act.equals("delen")) {
			antwoord = n1 / n2;
			som = n1 + " : " + n2 + " = " + antwoord;
		} else if (act.equals("vermenigvuldigen")) {
			antwoord = n1 * n2;
			som = n1 + " x " + n2 + " = " + antwoord;
		}
		
		PrintWriter out = resp.getWriter();
		resp.setContentType("text/html");
		out.println("<!DOCTYPE html>");
		out.println("<html>");
		out.println(" <title>Rekenmachine</title>");
		out.println(" <body>");
		out.println(" <h2>Rekenmachine</h2>");
		out.println(" <h2>" + som + "</h2>");
		out.println(" </body>");
		out.println("</html>");

	}
}
