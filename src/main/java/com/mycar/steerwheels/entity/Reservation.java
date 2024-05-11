package com.mycar.steerwheels.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import com.mycar.steerwheels.constants.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "reservation")
public class Reservation implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 6831680613877657595L;

	@Id
	@GeneratedValue
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	@Column(name = "reservation_id")
	private UUID reservationId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "pickup_date")
	private Date pickupDate;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "return_date")
	private Date returnDate;
	
	@OneToOne(targetEntity = Car.class)
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	@JoinColumn(name = "car_id")
	private Car car;
	
	@Column(name = "no_of_days")
	private int noOfdays;
	
	@Column(name = "total_rent")
	private BigDecimal totalRent;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_status")
	private PaymentStatus paymentStatus;
	
	@ManyToOne(targetEntity = User.class)
	@JoinColumn(name = "user_id")
	@JdbcTypeCode(java.sql.Types.VARCHAR)
	private User user;
	
	@OneToOne(targetEntity = ReservationPayment.class)
	@JoinColumn(name = "reservation_payment_id")
	@JdbcTypeCode(Types.VARCHAR)
	private ReservationPayment reservationPayment;

	public UUID getReservationId() {
		return reservationId;
	}

	public void setReservationId(UUID reservationId) {
		this.reservationId = reservationId;
	}

	public Date getPickupDate() {
		return pickupDate;
	}

	public void setPickupDate(Date pickupDate) {
		this.pickupDate = pickupDate;
	}

	public Date getReturnDate() {
		return returnDate;
	}

	public void setReturnDate(Date returnDate) {
		this.returnDate = returnDate;
	}

	public Car getCar() {
		return car;
	}

	public void setCar(Car car) {
		this.car = car;
	}

	public int getNoOfdays() {
		return noOfdays;
	}

	public void setNoOfdays(int noOfdays) {
		this.noOfdays = noOfdays;
	}

	public BigDecimal getTotalRent() {
		return totalRent;
	}

	public void setTotalRent(BigDecimal totalRent) {
		this.totalRent = totalRent;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

	
}
