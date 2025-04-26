package net.tajeddine.ormtest.web;

import net.tajeddine.ormtest.entities.Patient;
import net.tajeddine.ormtest.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PatientRestController {
    @Autowired
    private PatientRepository patientRepository;

    @GetMapping("/patients")
    public List<Patient> patients() {
        return patientRepository.findAll();
    }

    @GetMapping("/patients/{id}")
    public Patient patient(@PathVariable Long id) {
        return patientRepository.findById(id).orElse(null);
    }
}
