package web;

import java.io.IOException;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


import model.Hotel;


import server.HotelRepository;


/**
 */
public class IndexServlet extends HttpServlet {
    private static final long serialVersionUID = 1L;

    private static final Logger log = Logger.getLogger(IndexServlet.class.getName());

    private final HotelRepository hotelRepository = new HotelRepository();

    @Override
    protected void doGet(final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException,
            IOException {

            log.info("doGet");
        final String text = request.getParameter("text");
        if (text != null && text.length() > 0)
        {
            Collection<Hotel> hotels = this.hotelRepository.searchHotel(text);
            request.setAttribute("hotels", hotels);
        }
        forward(request, response, "index.jsp");
    }

    @Override
    protected void doPost(final HttpServletRequest request,
            final HttpServletResponse response) throws ServletException,
            IOException {

            log.info("doPost");
    }


    /**
     * Forwards request and response to given path. Handles any
     * exceptions caused by forward target by printing them to logger.
     * 
     * @param request
     * @param response
     * @param path
     */
    protected void forward(final HttpServletRequest request,
            final HttpServletResponse response, final String path) {
        try {
            final RequestDispatcher rd = request.getRequestDispatcher(path);
            rd.forward(request, response);
        }
        catch (final Throwable tr) {
                log.severe("Cought Exception: " + tr.getMessage());
                log.log(Level.SEVERE,"StackTrace:", tr);
        }
    }
}
