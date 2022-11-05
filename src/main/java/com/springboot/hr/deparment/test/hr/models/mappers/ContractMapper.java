package com.springboot.hr.deparment.test.hr.models.mappers;

import com.springboot.hr.deparment.test.hr.models.dtos.ContractInDto;
import com.springboot.hr.deparment.test.hr.models.dtos.ContractOutDto;
import com.springboot.hr.deparment.test.hr.models.entities.Contract;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ContractMapper {

    @Mappings({
            @org.mapstruct.Mapping(source = "contractType.id", target = "contractTypeId"),
            @org.mapstruct.Mapping(source = "employee.id", target = "employeeId"),
            @org.mapstruct.Mapping(source = "common.createdAt", target = "createdAt"),
            @org.mapstruct.Mapping(source = "common.updatedAt", target = "updatedAt"),
            @org.mapstruct.Mapping(source = "common.isActive", target = "isActive")
    })
    ContractOutDto mapToDto(Contract contract);

    @Mappings({
            @org.mapstruct.Mapping(source = "contractTypeId", target = "contractType.id"),
            @org.mapstruct.Mapping(source = "employeeId", target = "employee.id")
    })
    Contract mapToEntity(ContractInDto contractInDto);

}
