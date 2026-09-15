package com.footbooking.reservation;

import com.footbooking.common.BaseEntity;
import com.footbooking.stadium.Stadium;
import com.footbooking.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;
import java.time.LocalTime;


@Entity
@Table(name = "reservations")
@Getter
@Setter
@NoArgsConstructor
public class Reservation extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id",nullable = false)
    private User user;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "stadium_id",nullable = false)
    private Stadium stadium;
    @Column(nullable = false)
    private LocalDate date;
    @Column(name = "start_time", nullable = false)
    private LocalTime startTime;
    @Column(name = "end_time",nullable = false)
    private LocalTime endTime;
    @Column(nullable = false,precision = 10,scale = 2)
    private BigDecimal price;
    @Enumerated(EnumType.STRING)
    private ReservationStatus status = ReservationStatus.PENDING;

    @Version
    private Integer version;
}
