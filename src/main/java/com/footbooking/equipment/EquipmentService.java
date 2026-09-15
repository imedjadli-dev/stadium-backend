package com.footbooking.equipment;

import com.footbooking.common.exception.ResourceNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class EquipmentService {

    private final EquipmentRepository equipmentRepository;

    public EquipmentService(EquipmentRepository equipmentRepository){
        this.equipmentRepository = equipmentRepository;
    }

    public Equipment getById(Long id){
        return equipmentRepository.findById(id).orElseThrow(()-> new ResourceNotFoundException("Equipment not found with id"+id));
    }

    public List<Equipment> getAll(){
        return equipmentRepository.findAll();
    }
}
