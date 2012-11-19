package web;

import com.google.appengine.api.datastore.*;
import com.google.appengine.api.taskqueue.Queue;
import com.google.appengine.api.taskqueue.QueueFactory;
import com.google.appengine.api.taskqueue.TaskOptions;
import com.googlecode.objectify.*;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.Query;
import model.Hotel;
import model.HotelKeywords;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;
import java.util.logging.Logger;

/**
 * Created with IntelliJ IDEA.
 * User: ishara
 * Date: 11/17/12
 * Time: 8:24 PM
 * To change this template use File | Settings | File Templates.
 */
public class KeywordBuilderServlet extends HttpServlet
{
    Logger logger = Logger.getLogger("KeywordBuilderServlet");
    public static final long LIMIT_MILLIS = 1000 * 20; // provide a little leeway

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {

    }


    /*protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        Objectify ofy = ObjectifyService.begin();
        QueryResultIterable<Key<Hotel>> lastDate = ofy.query(Hotel.class).fetchKeys();

        for (com.googlecode.objectify.Key<Hotel> hotelKey : lastDate)
        {
            HotelKeywords hotelKeywords = ofy.query(HotelKeywords.class).filter("parentHotelId", hotelKey.getId()).get();
            if (hotelKeywords == null)
            {
                Hotel hotel = ofy.get(hotelKey);
                hotelKeywords = new HotelKeywords(hotelKey);
                hotelKeywords.setParentHotelId(hotelKey.getId());

                List<String> keywords = new ArrayList<String>();
                for (StringTokenizer tokenizer = new StringTokenizer(hotel.getHotel_name(), " "); tokenizer.hasMoreTokens(); )
                {
                    String s = tokenizer.nextToken();
                    keywords.add(s.trim().toUpperCase());
                }
                hotelKeywords.add(keywords);
                hotelKeywords.add(hotel.getCity());
                hotelKeywords.add(hotel.getCountry());
                if (hotel.getState() != null && hotel.getState().length() > 0)
                {
                    hotelKeywords.add(hotel.getState());
                }

                ofy.put(hotelKeywords);
            }
            break;
        }
    }*/


    @Override
    protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        long startTime = System.currentTimeMillis();
        Objectify ofy = ObjectifyService.begin();
        Query<Hotel> query = ofy.query(Hotel.class);

        String cursorStr = request.getParameter("cursor");
        if (cursorStr != null)
            query.startCursor(Cursor.fromWebSafeString(cursorStr));

        QueryResultIterator<Hotel> iterator = query.iterator();
        while (iterator.hasNext())
        {
            Hotel hotel = iterator.next();
            HotelKeywords hotelKeywords;
            hotelKeywords = ofy.query(HotelKeywords.class).filter("parentHotelId", hotel.getId()).get();
            if (hotelKeywords == null)
            {
                QueryResultIterable<Key<Hotel>> lastDate = ofy.query(Hotel.class).filter("id", hotel.getId()).fetchKeys();
                for (com.googlecode.objectify.Key<Hotel> hotelKey : lastDate)
                {
                    hotelKeywords = new HotelKeywords(hotelKey);
                    hotelKeywords.setParentHotelId(hotel.getId());
                }

            } else
            {
                continue;
//                hotelKeywords.clear();
            }

            List<String> keywords = new ArrayList<String>();
            for (StringTokenizer tokenizer = new StringTokenizer(hotel.getHotel_name(), " "); tokenizer.hasMoreTokens(); )
            {
                String s = tokenizer.nextToken();
                keywords.add(s.trim().toUpperCase());
            }
            assert hotelKeywords != null;
            hotelKeywords.add(keywords);
            hotelKeywords.add(hotel.getCity().toUpperCase());
            hotelKeywords.add(hotel.getCountry().toUpperCase());
            if (hotel.getState() != null && hotel.getState().length() > 0)
            {
                hotelKeywords.add(hotel.getState().toUpperCase());
            }
            ofy.put(hotelKeywords);
            if (System.currentTimeMillis() - startTime > LIMIT_MILLIS)
            {
                Cursor cursor = iterator.getCursor();
                Queue queue = QueueFactory.getDefaultQueue();
                queue.add(TaskOptions.Builder.withUrl("/key_builder").param("cursor", cursor.toWebSafeString()));
                break;
            }
        }
    }
}
