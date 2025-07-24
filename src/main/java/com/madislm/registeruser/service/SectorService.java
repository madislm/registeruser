package com.madislm.registeruser.service;

import com.madislm.registeruser.dao.SectorDAO;
import com.madislm.registeruser.model.Sector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class SectorService {

    private final SectorDAO sectorDAO;

    public List<Sector> findAll() {
        return sectorDAO.findAll();
    }
}
