package web.jdbc;

import javax.annotation.Resource;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.sql.DataSource;
import java.io.IOException;
import java.util.List;


@WebServlet("/UmowyControllerServlet")
public class UmowyControllerServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	private UmowyDbUtil umowyDbUtil;
	
	@Resource(name="jdbc/umowy")
	private DataSource dataSource;
	
	@Override
	public void init() throws ServletException {
		super.init();

		try {
			umowyDbUtil = new UmowyDbUtil(dataSource);
		}
		catch (Exception exc) {
			throw new ServletException(exc);
		}
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		try {
			listyUmowy(request, response);
		} catch (Exception e) {
			e.printStackTrace();
		}

	}

	private void listyUmowy (HttpServletRequest request, HttpServletResponse response)
		throws Exception {

		List<Umowy> umowy = umowyDbUtil.getUmowy();

		request.setAttribute("UMOWY_LIST", umowy);

		RequestDispatcher dispatcher = request.getRequestDispatcher("/list-umowy.jsp");
		dispatcher.forward(request, response);
	}

}













