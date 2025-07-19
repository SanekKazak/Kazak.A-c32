package org.rides.service.bet.interfaces;

import org.rides.dto.util.PaginationDto;
import org.rides.entity.BetEntity;

import java.util.List;

public interface BetInfoService {
    List<BetEntity> getAll(PaginationDto dto);
}
