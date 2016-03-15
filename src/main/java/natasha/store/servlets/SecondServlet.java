package natasha.store.servlets;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class SecondServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("text/html");
        String path = req.getRequestURI();

        if (path.equalsIgnoreCase("/nata")) {
            resp.getWriter().print("<h1>hello, Nata!!</h1>");
        } else if (path.equalsIgnoreCase("/main")){
            resp.getWriter().print("<h1>Main page</h1>");
        }

    }
}
