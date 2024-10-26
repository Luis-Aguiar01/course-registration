package br.edu.ifsp.dsw1.ex1;

import java.io.IOException;

import br.edu.ifsp.dsw1.ex1.strategy.CelsiusConverter;
import br.edu.ifsp.dsw1.ex1.strategy.Converter;
import br.edu.ifsp.dsw1.ex1.strategy.FahrenheitConverter;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@WebServlet("/conversor.do")
public class Servlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private final Converter converter;
	
	public Servlet() {
		converter = new Converter();
	}
	
	@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");

		try (var out = response.getWriter()) {
			out.println("<!DOCTYPE html>\r\n"
					+ "<html lang=\"pt-BR\">\r\n"
					+ "<head>\r\n"
					+ "    <meta charset=\"UTF-8\">\r\n"
					+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
					+ "    <title>Document</title>\r\n"
					+ "    <link rel=\"stylesheet\" href=\"style.css\">\r\n"
					+ "</head>\r\n"
					+ "<body>\r\n"
					+ "    <form action=\"conversor.do\" method=\"POST\">\r\n"
					+ "        <div class=\"form-content\">\r\n"
					+ "            <label for=\"temperature\">Temperature:</label>\r\n"
					+ "            <input type=\"number\" name=\"temperature\" id=\"temperature\" placeholder=\"Digite a temperatura\">\r\n"
					+ "        </div>\r\n"
					+ "        \r\n"
					+ "        <div class=\"form-content radio\">\r\n"
					+ "            <label for=\"celsius\">Celsius:</label>\r\n"
					+ "            <input type=\"radio\" name=\"unit\" id=\"celsius\" value=\"celsius\">\r\n"
					+ "        </div>\r\n"
					+ "\r\n"
					+ "        <div class=\"form-content radio\">\r\n"
					+ "            <label for=\"fahrenheit\">Fahrenheit:</label>\r\n"
					+ "            <input type=\"radio\" name=\"unit\" id=\"fahrenheit\" value=\"fahrenheit\">\r\n"
					+ "        </div>\r\n"
					+ "        \r\n"
					+ "        <div class=\"form-content\">\r\n"
					+ "            <input type=\"submit\" value=\"Submit\" class=\"button\">\r\n"
					+ "        </div>\r\n"
					+ "    </form>\r\n"
					+ "</body>\r\n"
					+ "</html>"
					);
		}
	}
	
	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		
		var receivedTemperature = request.getParameter("temperature");
		var convertTo = request.getParameter("unit");
		var temperature = 0.0;
		var message = "";
		var out = response.getWriter();
		
		try {
			temperature = Double.parseDouble(receivedTemperature);
		}
		catch (NumberFormatException e) {
			temperature = 0;
		}
		
		converter.setTemperature(temperature);
		
		if (convertTo.equals("celsius")) {
			converter.setConverter(new CelsiusConverter());
			message = "Fahrenheit";
		} else {
			converter.setConverter(new FahrenheitConverter());
			message = "Celsius";
		}
		
		double convertedTemperature = converter.convert(temperature);
		
		out.println("<!DOCTYPE html>\r\n"
				+ "<html lang=\"pt-BR\">\r\n"
				+ "<head>\r\n"
				+ "    <meta charset=\"UTF-8\">\r\n"
				+ "    <meta name=\"viewport\" content=\"width=device-width, initial-scale=1.0\">\r\n"
				+ "    <title>Document</title>\r\n"
				+ "    <link rel=\"stylesheet\" href=\"style.css\">\r\n"
				+ "</head>\r\n"
				+ "<body>\r\n"
				+ "    <form action=\"conversor.do\" method=\"POST\">\r\n"
				+ "        <div class=\"form-content\">\r\n"
				+ "            <label for=\"temperature\">Temperature:</label>\r\n"
				+ "            <input type=\"number\" name=\"temperature\" id=\"temperature\" placeholder=\"Digite a temperatura\">\r\n"
				+ "        </div>\r\n"
				+ "        \r\n"
				+ "        <div class=\"form-content radio\">\r\n"
				+ "            <label for=\"celsius\">Celsius:</label>\r\n"
				+ "            <input type=\"radio\" name=\"unit\" id=\"celsius\" value=\"celsius\">\r\n"
				+ "        </div>\r\n"
				+ "\r\n"
				+ "        <div class=\"form-content radio\">\r\n"
				+ "            <label for=\"fahrenheit\">Fahrenheit:</label>\r\n"
				+ "            <input type=\"radio\" name=\"unit\" id=\"fahrenheit\" value=\"fahrenheit\">\r\n"
				+ "        </div>\r\n"
				+ "        \r\n"
				+ "        <div class=\"form-content\">\r\n"
				+ "            <input type=\"submit\" value=\"Submit\" class=\"button\">\r\n"
				+ "        </div>\r\n"
				+ "    </form>\r\n"
				+ "    <h1 class=\"result sucess\">A temperatura " + temperature  + " " + message + " é igual a: " + convertedTemperature + " " + convertTo  + "</h1>\r\n"
				+ "</body>\r\n"
				+ "</html>"
				);
	}
}
