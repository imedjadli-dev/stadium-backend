package com.footbooking.equipment;

import org.springframework.data.jpa.repository.JpaRepository;

public interface EquipmentRepository extends JpaRepository<Equipment , Long> {
    boolean existsByName(String name);
}
