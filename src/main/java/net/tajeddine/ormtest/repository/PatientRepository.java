package net.tajeddine.ormtest.repository;

import net.tajeddine.ormtest.entities.Patient;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByMalade(boolean malade);
    List<Patient> findByNameContainsIgnoreCase(String keyword);
}
