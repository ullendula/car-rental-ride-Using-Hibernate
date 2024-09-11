package com.rentalrides.service;

import java.util.List;

import com.rentalrides.entity.Booking;

public interface BookingService {

	 void saveBooking(Booking booking);
	    Booking getBookingById(Long bookingId);
	    List<Booking> getAllBookings();
	    void updateBooking(Booking booking);
	    void deleteBooking(Long bookingId);
	
}
