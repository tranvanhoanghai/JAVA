package com.example.demo.service;

import com.example.demo.entity.Tutorial;

import java.util.List;

public interface TutorialService {
    List<Tutorial> searchTutorial(String term);

    List<Tutorial> getAllTutorial();

    Tutorial getTutorialById(long id);

    Tutorial saveTutorial(Tutorial tutorial);

    Tutorial updateTutorial(long id, Tutorial tutorial);

    void deleteTutorialById(long id);

    void deleteAllTutorial();

    List<Tutorial> findByPublished();
}
