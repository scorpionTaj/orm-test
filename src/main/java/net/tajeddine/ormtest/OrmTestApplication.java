package net.tajeddine.ormtest;

import net.tajeddine.ormtest.entities.Patient;
import net.tajeddine.ormtest.repository.PatientRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;

@SpringBootApplication
public class OrmTestApplication {

    public static void main(String[] args)
    {
        SpringApplication.run(OrmTestApplication.class, args);
    }
    @Bean
    CommandLineRunner start(PatientRepository patientRepository) {
        return args -> {
            // Ajouter des patients
            patientRepository.save(new Patient(null, "Tajeddine Bourhim", new Date(), false, 75));
            patientRepository.save(new Patient(null, "Ahmed test", new Date(), true, 90));

            // Consulter tous les patients
            patientRepository.findAll().forEach(System.out::println);

            // Consulter un patient
            Patient patient = patientRepository.findById(1L).orElse(null);
            System.out.println(patient);

            // Chercher des patients
            patientRepository.findByMalade(true).forEach(System.out::println);

            // Mettre à jour un patient
            if (patient != null) {
                patient.setScore(85);
                patientRepository.save(patient);
            }

            // Supprimer un patient
            patientRepository.deleteById(2L);
        };
    }
}
