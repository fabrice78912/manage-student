package com.school.mapper;

import com.school.dto.EtudiantRequestDto;
import com.school.model.Etudiant;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


import java.util.List;

@Mapper(componentModel = "spring")
public interface EtudiantMapper {

    //    @Mapping(target = "categoryId", source = "category.id ")
//    @Mapping(target = "categoryName", source = "category.name ")
    EtudiantRequestDto entityToDto(Etudiant entity);

    List<EtudiantRequestDto> listEntityToListDto(List<Etudiant> entities);


   // @Mapping(target = "ignore", source = "*")
    Etudiant dtoToEntity(EtudiantRequestDto dto);

    List<Etudiant> listDtoToEntities(List<EtudiantRequestDto> listDto);
}
