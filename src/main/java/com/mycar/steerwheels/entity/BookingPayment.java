package com.mycar.steerwheels.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Types;
import java.util.Date;
import java.util.UUID;

import org.hibernate.annotations.JdbcTypeCode;

import com.mycar.steerwheels.constants.PaymentMethod;
import com.mycar.steerwheels.constants.PaymentStatus;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;

@Entity
@Table(name = "booking_payment")
public class BookingPayment implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8856671903686325702L;
	
	@Id
	@GeneratedValue
	@Column(name = "booking_payment_id")
	@JdbcTypeCode(Types.VARCHAR)
	private UUID bookingPaymentId;
	
	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "payment_date")
	private Date paymentDate;
	
	@JdbcTypeCode(Types.VARCHAR)
	@OneToOne(targetEntity = Booking.class)
	@JoinColumn(name = "booking_id")
	private Booking booking;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_method")
	private PaymentMethod paymentMethod;
	
	@Column(name = "payment_amount")
	private BigDecimal paymentAmount;
	
	@Column(name = "transaction_id")
	private String transactionId;
	
	@Enumerated(EnumType.STRING)
	@Column(name = "payment_status")
	private PaymentStatus paymentStatus;

	public UUID getBookingPaymentId() {
		return bookingPaymentId;
	}

	public void setBookingPaymentId(UUID bookingPaymentId) {
		this.bookingPaymentId = bookingPaymentId;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public Booking getBooking() {
		return booking;
	}

	public void setBooking(Booking booking) {
		this.booking = booking;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	public PaymentMethod getPaymentMethod() {
		return paymentMethod;
	}

	public void setPaymentMethod(PaymentMethod paymentMethod) {
		this.paymentMethod = paymentMethod;
	}

	public BigDecimal getPaymentAmount() {
		return paymentAmount;
	}

	public void setPaymentAmount(BigDecimal paymentAmount) {
		this.paymentAmount = paymentAmount;
	}

	public String getTransactionId() {
		return transactionId;
	}

	public void setTransactionId(String transactionId) {
		this.transactionId = transactionId;
	}

	public PaymentStatus getPaymentStatus() {
		return paymentStatus;
	}

	public void setPaymentStatus(PaymentStatus paymentStatus) {
		this.paymentStatus = paymentStatus;
	}
	
	
	
}
