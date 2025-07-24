package com.madislm.registeruser.converter;

import com.madislm.registeruser.dao.SectorDAO;
import com.madislm.registeruser.model.Sector;
import jakarta.annotation.Nullable;
import lombok.AllArgsConstructor;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
@AllArgsConstructor
public class StringToSectorConverter implements Converter<String, Sector> {

    private final SectorDAO sectorDAO;

    @Override
    public Sector convert(@Nullable String source) {
        if (source == null || source.isBlank()) return null;
        return sectorDAO.findById(Integer.valueOf(source));
    }
}
