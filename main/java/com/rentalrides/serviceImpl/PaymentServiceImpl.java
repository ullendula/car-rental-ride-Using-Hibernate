package com.rentalrides.serviceImpl;

import java.util.List;

import com.rentalrides.DaoImpl.PaymentDaoImpl;
import com.rentalrides.entity.Payment;
import com.rentalrides.service.PaymentService;

public class PaymentServiceImpl implements PaymentService{

	private PaymentDaoImpl paymentDao = new PaymentDaoImpl();

    @Override
    public void savePayment(Payment payment) {
        paymentDao.savePayment(payment);
    }

    @Override
    public Payment getPaymentById(Long paymentId) {
        return paymentDao.getPaymentById(paymentId);
    }

    @Override
    public List<Payment> getAllPayments() {
        return paymentDao.getAllPayments();
    }

    @Override
    public void updatePayment(Payment payment) {
        paymentDao.updatePayment(payment);
    }

    @Override
    public void deletePayment(Long paymentId) {
        paymentDao.deletePayment(paymentId);
    }

	@Override
	public void savePayment(Long bookingId) {
		paymentDao.getPaymentById(bookingId);
	}

	@Override
	public void refundPayment(Long paymentIdToRefund) {
    paymentDao.getPaymentById(paymentIdToRefund);
	}

	



}
