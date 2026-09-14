package com.footbooking.user;

import com.footbooking.common.BaseEntity;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.time.LocalDateTime;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true,length = 255)
    private String email;
    @Column(nullable = false,length = 8)
    private String phone;
    @Column(name = "password_hash",nullable = false,length = 255)
    private String passwordHash;
    @Column(nullable = false,length = 255)
    private String fullname;
    @Enumerated(EnumType.STRING)
    @Column(nullable = false,length = 20)
    @ColumnDefault("'USER'")
    private Role role;
    @Column(name = "is_verified", nullable = false)
    private boolean verified = false;
    @Column(name = "otp_hash",length = 255)
    private String otpHash;
    @Column(name = "otp_expires_at")
    private LocalDateTime otpExpiresAt;
    @Column(name = "otp_attempts",nullable = false)
    private short otpAttempts = 0;
    @Column(name = "reset_password_otp_hash", length = 255)
    private String resetPasswordOtpHash;
    @Column(name = "reset_password_otp_expires_at")
    private LocalDateTime resetPasswordOtpExpiresAt;
    @Column(name = "reset_password_otp_attempts", nullable = false)
    private short resetPasswordOtpAttempts= 0;
}
