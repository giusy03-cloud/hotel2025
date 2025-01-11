package com.dipartimento.hoteldesperation.repository;


import com.dipartimento.hoteldesperation.model.Camera;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CameraRepository extends JpaRepository<Camera, Long> {
}