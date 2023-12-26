package net.javaguides.Project.service;

import net.javaguides.Project.model.Medication;
import net.javaguides.Project.repository.MedicationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;
@Service
public class MedicationServiceImpl implements MedicationService{
    @Autowired
    private MedicationRepository medicationRepository;
    @Override
    public void saveMedication(Medication medication){
        this.medicationRepository.save(medication);
    }
    @Override
    public Medication getMedicationById(long id){
        Optional<Medication> optional = medicationRepository.findById(id);
        Medication medication = null;
        if(optional.isPresent()){
            medication = optional.get();
        }else {
            throw new RuntimeException("Animal not found for id :: " + id);
        }
        return medication;
    }
}
