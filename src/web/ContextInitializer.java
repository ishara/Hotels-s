package web;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import model.Hotel;


import com.googlecode.objectify.ObjectifyService;
import model.HotelKeywords;


/**
 */
public final class ContextInitializer implements ServletContextListener {
    @Override
    public void contextInitialized(final ServletContextEvent sce) {
        ObjectifyService.register(Hotel.class);
        ObjectifyService.register(HotelKeywords.class);
    }

    @Override
    public void contextDestroyed(final ServletContextEvent sce) {
        // empty
    }
}
