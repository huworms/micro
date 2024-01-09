package com.example.demo.reserva.model;



import java.sql.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Getter @Setter @ToString
public class Reservation {
	
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="reservation_id")
	private long reservationId;
	
	@Column(name="room_id")
	private long roomId;
	
	public long getReservationId() {
		return reservationId;
	}

	public void setReservationId(long reservationId) {
		this.reservationId = reservationId;
	}

	public long getRoomId() {
		return roomId;
	}

	public void setRoomId(long roomId) {
		this.roomId = roomId;
	}

	public Date getStartDt() {
		return startDt;
	}

	public void setStartDt(Date startDt) {
		this.startDt = startDt;
	}

	public Date getFinishDt() {
		return finishDt;
	}

	public void setFinishDt(Date finishDt) {
		this.finishDt = finishDt;
	}

	@Column(name="start_dt")
	private Date startDt;
	
	@Column(name="finish_dt")
	private Date finishDt;
}
