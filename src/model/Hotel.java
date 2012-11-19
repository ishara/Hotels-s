package model;

import com.google.appengine.api.datastore.GeoPt;
import com.google.appengine.api.datastore.Link;
import com.google.appengine.api.datastore.Text;
import com.googlecode.objectify.Key;
import com.googlecode.objectify.annotation.Cached;
import com.googlecode.objectify.annotation.Entity;

import javax.persistence.Id;
import javax.persistence.Transient;

/**
 * Created with IntelliJ IDEA.
 * User: ishara
 * Date: 11/16/12
 * Time: 7:32 PM
 * To change this template use File | Settings | File Templates.
 */
@Cached
@Entity
public class Hotel<Key> extends com.googlecode.objectify.Key<Hotel>
{
    @Id
    private Long id;
    private Long chain_id;
    private Long hotel_id;
    private String chain_name;
    private Long brand_id;
    private String brand_name;
    private String hotel_name;
    private String hotel_formerly_name;
    private String hotel_translated_name;
    private String addressline1;
    private String addressline2;
    private String zipcode;
    private String city;
    private String state;
    private String country;
    private String countryisocode;
    private float star_rating;
    private GeoPt geoPt;
    private String url;
    private String checkin;
    private String checkout;
    private int numberrooms = -1;
    private int numberfloors = -1;
    private String yearopened;
    private String yearrenovated;
    private Link photo1;
    private Link photo2;
    private Link photo3;
    private Link photo4;
    private Link photo5;
    private Text overview;
    private double rates_from;
    private String rates_currency;
    private Long continent_id;
    private String continent_name;
    private Long city_id;
    private Long country_id;
    private Long number_of_reviews;
    private double rating_average;

    public Hotel()
    {
    }

    @Override
    public long getId()
    {
        return id;
    }

    public Long getHotel_id()
    {
        return hotel_id;
    }

    public void setHotel_id(Long hotel_id)
    {
        this.hotel_id = hotel_id;
    }

    public Long getChain_id()
    {
        return chain_id;
    }

    public void setChain_id(Long chain_id)
    {
        this.chain_id = chain_id;
    }

    public String getChain_name()
    {
        return chain_name;
    }

    public void setChain_name(String chain_name)
    {
        this.chain_name = chain_name;
    }

    public Long getBrand_id()
    {
        return brand_id;
    }

    public void setBrand_id(Long brand_id)
    {
        this.brand_id = brand_id;
    }

    public String getBrand_name()
    {
        return brand_name;
    }

    public void setBrand_name(String brand_name)
    {
        this.brand_name = brand_name;
    }

    public String getHotel_name()
    {
        return hotel_name;
    }

    public void setHotel_name(String hotel_name)
    {
        this.hotel_name = hotel_name;
    }

    public String getHotel_formerly_name()
    {
        return hotel_formerly_name;
    }

    public void setHotel_formerly_name(String hotel_formerly_name)
    {
        this.hotel_formerly_name = hotel_formerly_name;
    }

    public String getHotel_translated_name()
    {
        return hotel_translated_name;
    }

    public void setHotel_translated_name(String hotel_translated_name)
    {
        this.hotel_translated_name = hotel_translated_name;
    }

    public String getAddressline1()
    {
        return addressline1;
    }

    public void setAddressline1(String addressline1)
    {
        this.addressline1 = addressline1;
    }

    public String getAddressline2()
    {
        return addressline2;
    }

    public void setAddressline2(String addressline2)
    {
        this.addressline2 = addressline2;
    }

    public String getZipcode()
    {
        return zipcode;
    }

    public void setZipcode(String zipcode)
    {
        this.zipcode = zipcode;
    }

    public String getCity()
    {
        return city;
    }

    public void setCity(String city)
    {
        this.city = city;
    }

    public String getState()
    {
        return state;
    }

    public void setState(String state)
    {
        this.state = state;
    }

    public String getCountry()
    {
        return country;
    }

    public void setCountry(String country)
    {
        this.country = country;
    }

    public String getCountryisocode()
    {
        return countryisocode;
    }

    public void setCountryisocode(String countryisocode)
    {
        this.countryisocode = countryisocode;
    }

    public float getStar_rating()
    {
        return star_rating;
    }

    public void setStar_rating(float star_rating)
    {
        this.star_rating = star_rating;
    }

    public GeoPt getGeoPt()
    {
        return geoPt;
    }

    public void setGeoPt(GeoPt geoPt)
    {
        this.geoPt = geoPt;
    }

    public String getUrl()
    {
        return url;
    }

    public void setUrl(String url)
    {
        this.url = url;
    }

    public String getCheckin()
    {
        return checkin;
    }

    public void setCheckin(String checkin)
    {
        this.checkin = checkin;
    }

    public String getCheckout()
    {
        return checkout;
    }

    public void setCheckout(String checkout)
    {
        this.checkout = checkout;
    }

    public int getNumberrooms()
    {
        return numberrooms;
    }

    public void setNumberrooms(int numberrooms)
    {
        this.numberrooms = numberrooms;
    }

    public int getNumberfloors()
    {
        return numberfloors;
    }

    public void setNumberfloors(int numberfloors)
    {
        this.numberfloors = numberfloors;
    }

    public String getYearopened()
    {
        return yearopened;
    }

    public void setYearopened(String yearopened)
    {
        this.yearopened = yearopened;
    }

    public String getYearrenovated()
    {
        return yearrenovated;
    }

    public void setYearrenovated(String yearrenovated)
    {
        this.yearrenovated = yearrenovated;
    }

    public Link getPhoto1()
    {
        return photo1;
    }

    public void setPhoto1(Link photo1)
    {
        this.photo1 = photo1;
    }

    public Link getPhoto2()
    {
        return photo2;
    }

    public void setPhoto2(Link photo2)
    {
        this.photo2 = photo2;
    }

    public Link getPhoto3()
    {
        return photo3;
    }

    public void setPhoto3(Link photo3)
    {
        this.photo3 = photo3;
    }

    public Link getPhoto4()
    {
        return photo4;
    }

    public void setPhoto4(Link photo4)
    {
        this.photo4 = photo4;
    }

    public Link getPhoto5()
    {
        return photo5;
    }

    public void setPhoto5(Link photo5)
    {
        this.photo5 = photo5;
    }

    public Text getOverview()
    {
        return overview;
    }

    public void setOverview(Text overview)
    {
        this.overview = overview;
    }

    public double getRates_from()
    {
        return rates_from;
    }

    public void setRates_from(double rates_from)
    {
        this.rates_from = rates_from;
    }

    public String getRates_currency()
    {
        return rates_currency;
    }

    public void setRates_currency(String rates_currency)
    {
        this.rates_currency = rates_currency;
    }

    public Long getContinent_id()
    {
        return continent_id;
    }

    public void setContinent_id(Long continent_id)
    {
        this.continent_id = continent_id;
    }

    public String getContinent_name()
    {
        return continent_name;
    }

    public void setContinent_name(String continent_name)
    {
        this.continent_name = continent_name;
    }

    public Long getCity_id()
    {
        return city_id;
    }

    public void setCity_id(Long city_id)
    {
        this.city_id = city_id;
    }

    public Long getCountry_id()
    {
        return country_id;
    }

    public void setCountry_id(Long country_id)
    {
        this.country_id = country_id;
    }

    public Long getNumber_of_reviews()
    {
        return number_of_reviews;
    }

    public void setNumber_of_reviews(Long number_of_reviews)
    {
        this.number_of_reviews = number_of_reviews;
    }

    public double getRating_average()
    {
        return rating_average;
    }

    public void setRating_average(double rating_average)
    {
        this.rating_average = rating_average;
    }
}
