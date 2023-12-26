package net.javaguides.Project.service;

import net.javaguides.Project.model.Medication;
import org.springframework.stereotype.Service;

@Service
public interface MedicationService {
    void saveMedication(Medication medication);
    Medication getMedicationById(long id);
}
