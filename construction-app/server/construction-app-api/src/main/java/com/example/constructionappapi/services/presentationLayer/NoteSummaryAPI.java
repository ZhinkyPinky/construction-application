package com.example.constructionappapi.services.presentationLayer;


import com.example.constructionappapi.services.businessLogicLayer.repositories.CustomerNoteRepository;
import com.example.constructionappapi.services.businessLogicLayer.repositories.NoteSummaryRepository;
import com.example.constructionappapi.services.dataAccessLayer.entities.CustomerEntity;
import com.example.constructionappapi.services.dataAccessLayer.entities.CustomerNoteEntity;
import com.example.constructionappapi.services.dataAccessLayer.entities.NoteSummaryEntity;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/v1")
public class NoteSummaryAPI {

    @Autowired
    private NoteSummaryRepository noteSummaryRepository;


    @PostMapping("/kunder/anteckningar/summary/save/{workId}")
    public NoteSummaryEntity createNoteSummary(@RequestBody NoteSummaryEntity noteSummary, @PathVariable final long workId) {
        return noteSummaryRepository.createNoteSummary(noteSummary, workId);
    }

    @GetMapping("/kunder/anteckningar/summary/{workId}")
    public Optional<NoteSummaryEntity> getSumForWork(@PathVariable final long workId) {
        return noteSummaryRepository.getSumForWork(workId);
    }

    @GetMapping("/kunder/anteckningar/summary/customer/{customerId}")
    public List<NoteSummaryEntity> getSumsForCustomer(@PathVariable final long customerId) {
        return noteSummaryRepository.getSumsForCustomer(customerId);
    }

}
