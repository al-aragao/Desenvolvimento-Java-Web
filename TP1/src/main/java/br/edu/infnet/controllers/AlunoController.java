package br.edu.infnet.controllers;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import br.edu.infnet.domain.models.Aluno;

public class AlunoController extends HttpServlet {
	private static final long serialVersionUID = 1L;

    public AlunoController() {
        // TODO Auto-generated constructor stub
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("index.html").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name = request.getParameter("Name");
		String mail = request.getParameter("Email");
		String password = request.getParameter("Password");
		
		Aluno aluno = new Aluno(name, mail, password);
		System.out.println(aluno.toString());
		
		PrintWriter out = response.getWriter();
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"en\">\r\n"
				+ "<head>\r\n"
				+ "<meta charset=\"ISO-8859-1\">\r\n"
				+ "<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n"
				+ "<title>TP1 - Thiago Aragão</title>\r\n"
				+ "<link\r\n"
				+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css\"\r\n"
				+ "	rel=\"stylesheet\"\r\n"
				+ "	integrity=\"sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3\"\r\n"
				+ "	crossorigin=\"anonymous\">\r\n"
				+ "<link rel=\"stylesheet\"\r\n"
				+ "	href=\"https://cdn.jsdelivr.net/npm/bootstrap-icons@1.6.1/font/bootstrap-icons.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "\r\n"
				+ "	<nav class=\"navbar navbar-expand-lg navbar-dark bg-dark\">\r\n"
				+ "		<div class=\"container\">\r\n"
				+ "			<a class=\"navbar-brand\" href=\"#\">TP1 Thiago Aragão</a>\r\n"
				+ "		</div>\r\n"
				+ "	</nav>\r\n"
				+ "\r\n"
				+ "	<section class=\"container\">\r\n"
				+ "		<div class=\"row\">\r\n"
				+ "			<div class=\"col-md\">\r\n"
				+ "				<h1 class=\"text-success\">Aluno cadastrado com sucesso!</h1>\r\n"
				+ "				<form action=\"aluno\" method=\"GET\">\r\n"
				+ "					<p>O aluno <b>" + aluno.getName() + "</b> com e-mail <b>" + aluno.getEmail() + "</b> foi salvo com sucesso.</p>\r\n"
				+ "					<div class=\"mb-3\">\r\n"
				+ "						<button class=\"btn btn-outline-secondary\" type=\"submit\">Voltar</button>\r\n"
				+ "					</div>\r\n"
				+ "				</form>\r\n"
				+ "			</div>\r\n"
				+ "		</div>\r\n"
				+ "	</section>\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "\r\n"
				+ "	<script\r\n"
				+ "		src=\"https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js\"\r\n"
				+ "		integrity=\"sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p\"\r\n"
				+ "		crossorigin=\"anonymous\"></script>\r\n"
				+ "</body>\r\n"
				+ "</html>");		
	}

}
