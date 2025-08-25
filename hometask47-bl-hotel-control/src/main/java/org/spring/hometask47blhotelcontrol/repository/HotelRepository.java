package org.spring.hometask47blhotelcontrol.repository;

import org.spring.hometask47blhotelcontrol.entity.HotelEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface HotelRepository extends JpaRepository<HotelEntity, UUID> {
}
