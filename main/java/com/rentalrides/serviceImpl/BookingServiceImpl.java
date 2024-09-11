package com.rentalrides.serviceImpl;

import java.util.List;

import com.rentalrides.DaoImpl.BookingDaoImpl;
import com.rentalrides.entity.Booking;
import com.rentalrides.service.BookingService;

public class BookingServiceImpl  implements BookingService{
	
    private BookingDaoImpl bookingDao = new BookingDaoImpl();


    @Override
    public void saveBooking(Booking booking) {
        bookingDao.saveBooking(booking);
    }

    @Override
    public Booking getBookingById(Long bookingId) {
        return bookingDao.getBookingById(bookingId);
    }

    @Override
    public List<Booking> getAllBookings() {
        return bookingDao.getAllBookings();
    }

    @Override
    public void updateBooking(Booking booking) {
        bookingDao.updateBooking(booking);
    }

    @Override
    public void deleteBooking(Long bookingId) {
        bookingDao.deleteBooking(bookingId);
    }
}
