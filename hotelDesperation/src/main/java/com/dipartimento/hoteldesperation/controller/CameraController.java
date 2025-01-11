package com.dipartimento.hoteldesperation.controller;

import com.dipartimento.hoteldesperation.model.Camera;
import com.dipartimento.hoteldesperation.repository.CameraRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/camere")
public class CameraController {

    @Autowired
    private CameraRepository cameraRepository;

    @PostMapping("/add")
    public String addCamera(@RequestBody Camera camera) {
        cameraRepository.save(camera);
        return "Camera aggiunta con successo!";
    }

    @GetMapping("/all")
    public List<Camera> getAllCamere() {
        return cameraRepository.findAll();
    }
}
