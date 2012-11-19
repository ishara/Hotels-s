package server;

import java.util.*;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.Query;
import model.Hotel;


import com.googlecode.objectify.Objectify;
import com.googlecode.objectify.ObjectifyService;
import model.HotelKeywords;


/**
 */
public class HotelRepository
{
    /**
     * @return Collection of Message
     */
//    public List<Hotel> searchHotel(String text) {
//        final Objectify service = getService();
//        return service.query(Hotel.class).filter("hotel_name >=", text).filter("hotel_name <", text + "\uFFFD").list();
//
//    }
    public Collection<Hotel> searchHotel(String text)
    {
        final Objectify ofy = getService();
        List<String> keywords = new ArrayList<String>();
        for (StringTokenizer tokenizer = new StringTokenizer(text, " "); tokenizer.hasMoreTokens(); )
        {
            String s = tokenizer.nextToken();
            keywords.add(s.trim().toUpperCase());
        }
        if (keywords.size() == 0)
        {
            keywords.add(text);
        }

        Query<HotelKeywords> query = ofy.query(HotelKeywords.class);
        for (String keyword : keywords)
        {
            query = query.filter("keywords", keyword);
        }
        query.limit(20);
        Set<Key<Hotel>> keys = query.fetchParentKeys();

        Collection<Hotel> documents = ofy.get(keys).values();
        return documents;

    }

    private Objectify getService()
    {
        return (ObjectifyService.begin());
    }
}
