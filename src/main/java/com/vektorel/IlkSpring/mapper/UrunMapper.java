package com.vektorel.IlkSpring.mapper;

import com.vektorel.IlkSpring.dto.request.UrunRequestDto;
import com.vektorel.IlkSpring.dto.response.UrunResponseDto;
import com.vektorel.IlkSpring.repository.entity.Urun;
import org.mapstruct.Mapper;
import org.mapstruct.ReportingPolicy;

@Mapper(unmappedTargetPolicy = ReportingPolicy.IGNORE, componentModel = "spring")
public interface UrunMapper {

    Urun toUrun(final UrunRequestDto urunRequestDto);
    UrunResponseDto toResponseDto(final Urun urun);

}
