package com.madislm.registeruser.service;

import com.madislm.registeruser.dao.SectorDAO;
import com.madislm.registeruser.model.Sector;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@AllArgsConstructor
public class SectorService {

    private final SectorDAO sectorDAO;

    public List<Sector> findAll() {
        return sectorDAO.findAll();
    }

    public List<Sector> findAllAndGroup() {
        List<Sector> rootSectors = sectorDAO.findAll()
                .stream().filter(sector -> sector.getParent() == null)
                .toList();

        return flattenSectors(rootSectors);
    }

    private List<Sector> flattenSectors(List<Sector> sectors) {
        List<Sector> flatList = new ArrayList<>();
        flattenRecursive(sectors, 0, flatList);
        return flatList;
    }

    private void flattenRecursive(List<Sector> sectors, int depth, List<Sector> result) {
        for (Sector sector : sectors) {
            sector.setDepth(depth);
            result.add(sector);
            flattenRecursive(sector.getSubSectors(), depth + 1, result);
        }
    }
}
