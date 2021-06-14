package controller;


import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import beans.Bean;
import database.SQLconnection;

/**
 * Servlet implementation class ControllerServlet
 */
@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public SearchServlet() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		
		//KOMMENTAR TILL MARCUS! Finns det n�got s�tt att l�gga p� ytterliggare funktion till min servlet? Jag t�nker p� om du har n�gra tips eller id�er h�r med f�r att g�ra projektet mer omfattande s� att det fyller b�da kursernas krav.
		
		
		

		String searchString = request.getParameter("searchString");

		ArrayList<Bean> searchResult = new ArrayList<Bean>();
		
		if (SQLconnection.connectSQL()) {
			// send the string
			searchResult = SQLconnection.bearSQL(searchString, searchResult);
			searchResult = SQLconnection.ikeaSQL(searchString, searchResult);
			searchResult = SQLconnection.masterscplistSQL(searchString, searchResult);
			
			
			request.setAttribute("searchResult", searchResult);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
			
		} else {
			request.setAttribute("searchResult", searchResult);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}

	}

	
	

	
		

		// check if connection is open?
		/*if (SQLconnection.connectSQL()) {
			// send the string
			searchResult = SQLconnection.stateSQL(searchString, searchResult);

			request.setAttribute("searchResult", searchResult);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.forward(request, response);
		} else {
			request.setAttribute("searchResult", searchResult);
			RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
			rd.include(request, response);
		}

	}*/

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);

	}

}