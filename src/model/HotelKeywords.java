package model;

import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Entity;
import com.googlecode.objectify.annotation.Parent;

import javax.persistence.Id;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: ishara
 * Date: 11/17/12
 * Time: 8:15 PM
 * To change this template use File | Settings | File Templates.
 */
@Entity
public class HotelKeywords
{
    @Id
    Long id;
    @Parent
    Key<Hotel> hotelKey;
    List<String> keywords = new ArrayList<String>();
    Long parentHotelId;
    private HotelKeywords()
    {
        super();
    }

    public HotelKeywords(Key<Hotel> parent)
    {
        this(parent, Collections.<String>emptyList());
    }

    public HotelKeywords(Key<Hotel> parent, Collection<String> keywords)
    {
        super();

        this.hotelKey = parent;
        this.keywords.addAll(keywords);
    }

    // add single keyword
    public boolean add(String keyword)
    {
        return keywords.add(keyword);
    }

    // add collection of keywords
    public boolean add(Collection<String> keywords)
    {
        return this.keywords.addAll(keywords);
    }
    public void clear()
    {
        this.keywords.clear();
    }

    public Long getParentHotelId()
    {
        return parentHotelId;
    }

    public void setParentHotelId(Long parentHotelId)
    {
        this.parentHotelId = parentHotelId;
    }
}
