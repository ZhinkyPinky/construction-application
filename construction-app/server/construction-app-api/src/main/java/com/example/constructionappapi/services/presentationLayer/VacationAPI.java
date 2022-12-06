package com.example.constructionappapi.services.presentationLayer;

import com.example.constructionappapi.services.businessLogicLayer.repositories.VacationRepository;
import com.example.constructionappapi.services.dataAccessLayer.entities.VacationEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/v1")
public class VacationAPI {

    @Autowired
    private VacationRepository vacationRepository;

    @PostMapping("/semester")
    public VacationEntity saveVacation(@RequestBody VacationEntity vacationEntity) {
        return vacationRepository.saveVacation(vacationEntity);
    }

    @DeleteMapping("/semester/{id}/edit")
    public void editVacation(@PathVariable final Long id, @RequestBody VacationEntity vacationEntity) {
        vacationRepository.deleteVacation(id);
        vacationRepository.saveVacation(vacationEntity);
    }

    @GetMapping("/semester/{id}")
    public Optional<VacationEntity> getVacation(@PathVariable final Long id) {
        return vacationRepository.getVacation(id);
    }

    @GetMapping("/semester")
    public List<VacationEntity> getAllVacations() {
        return vacationRepository.getAllVacationEntities();
    }

    @DeleteMapping("/semester/{id}/remove")
    public void deleteVacation(@PathVariable final Long id) {
        vacationRepository.deleteVacation(id);
    }
}
