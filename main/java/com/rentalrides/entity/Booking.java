package com.rentalrides.entity;

import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;



@Entity
@Table(name = "Booking")
public class Booking {

	public Booking() {
		// TODO Auto-generated constructor stub
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long bookingId;

	@ManyToOne
	@JoinColumn(name = "userId")
	private User user;

	@ManyToOne
	@JoinColumn(name = "carNumber")
	private String car;

	@OneToOne(mappedBy = "booking")
	private Payment payment;

	@Column(name="StartDate")
	private Date startDate;
	@Column(name="EndDate")
	private Date endDate;
	@Column(name="TotalCost")
	private double totalCost;
	@Column(name="CurrentBookingStatus")
	private String currentBookingStatus;

	public Long getBookingId() {
		return bookingId;
	}

	public void setBookingId(Long bookingId) {
		this.bookingId = bookingId;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	public String getCar() {
		return car;
	}

	public void setCar(String newCarId) {
		this.car = newCarId;
	}

	public Payment getPayment() {
		return payment;
	}

	public void setPayment(Payment payment) {
		this.payment = payment;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(double totalCost) {
		this.totalCost = totalCost;
	}

	public String getCurrentBookingStatus() {
		return currentBookingStatus;
	}

	public void setCurrentBookingStatus(String currentBookingStatus) {
		this.currentBookingStatus = currentBookingStatus;
	}

	@Override
	public String toString() {
		return "Booking [bookingId=" + bookingId + ", user=" + user + ", car=" + car + ", payment=" + payment
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", totalCost=" + totalCost
				+ ", currentBookingStatus=" + currentBookingStatus + "]";
	}

	public Booking(Long bookingId, double totalCost) {
		super();
		this.bookingId = bookingId;
		this.user = user;
		this.car = car;
		this.payment = payment;
		this.startDate = startDate;
		this.endDate = endDate;
		this.totalCost = totalCost;
		this.currentBookingStatus = currentBookingStatus;
	}

}
