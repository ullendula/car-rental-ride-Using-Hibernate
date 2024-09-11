package com.rentalrides.service;

import java.util.List;

import com.rentalrides.entity.Payment;

public interface PaymentService {

	void savePayment(Payment payment);
    Payment getPaymentById(Long paymentId);
    List<Payment> getAllPayments();
    void updatePayment(Payment payment);
    void deletePayment(Long paymentId);
    void savePayment(Long bookingId);
	void refundPayment(Long paymentIdToRefund);
	
}
