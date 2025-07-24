package com.madislm.registeruser.dao;

import com.madislm.registeruser.model.Sector;
import jakarta.persistence.EntityManager;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class SectorDAOImpl implements SectorDAO {

    private final EntityManager entityManager;

    @Override
    public List<Sector> findAll() {
        return entityManager.createQuery("SELECT s FROM Sector s", Sector.class).getResultList();
    }
}
