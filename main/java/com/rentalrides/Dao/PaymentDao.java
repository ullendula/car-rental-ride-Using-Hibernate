package com.rentalrides.Dao;

import java.util.List;

import com.rentalrides.entity.Payment;

public interface PaymentDao {
	
	void savePayment(Payment payment);
    Payment getPaymentById(Long paymentId);
    List<Payment> getAllPayments();
    void updatePayment(Payment payment);
    void deletePayment(Long paymentId);

}
