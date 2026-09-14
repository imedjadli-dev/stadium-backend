package com.footbooking.stadium;

import com.footbooking.common.BaseEntity;
import com.footbooking.equipment.Equipment;
import com.footbooking.user.User;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.HashSet;
import java.util.Set;

@Entity
@Table(name = "stadiums")
@Getter
@Setter
@NoArgsConstructor
public class Stadium extends BaseEntity {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "owner_id", nullable = false)
    private User owner;

    @Column(nullable = false,length = 255)
    private String title;
    @Column(nullable = false, length = 255)
    private String location;
    @Column(nullable = false, precision = 10,scale = 2)
    private BigDecimal price;
    @Column(columnDefinition = "TEXT")
    private String description;
    @Column(name = "opening_time", nullable = false)
    private LocalTime openingTime;
    @Column(name = "closing_time", nullable = false)
    private LocalTime closingTime;
    @Column(name = "slot_duration",nullable = false)
    private Integer slotDuration = 60;
    @Column(name = "deleted_at")
    private LocalDateTime deletedAt;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
         name = "stadium_equipments",
            joinColumns = @JoinColumn(name = "stadium_id"),
            inverseJoinColumns = @JoinColumn(name ="equipment_id")
    )
    private Set<Equipment> equipments = new HashSet<>();
}
