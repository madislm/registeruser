package com.madislm.registeruser.dao;

import com.madislm.registeruser.model.Sector;

import java.util.List;

public interface SectorDAO {

    List<Sector> findAll();

    Sector findById(Integer id);
}
