package com.springboot.hr.deparment.test.hr.services;

import com.springboot.hr.deparment.test.hr.models.dtos.ContractInDto;
import com.springboot.hr.deparment.test.hr.models.dtos.ContractOutDto;
import com.springboot.hr.deparment.test.hr.models.entities.Contract;
import com.springboot.hr.deparment.test.hr.models.mappers.ContractMapper;
import com.springboot.hr.deparment.test.hr.repositories.ContractRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class ContractService {

    @Autowired
    private ContractRepository contractRepository;

    @Autowired
    private ContractMapper contractMapper;

    public ContractOutDto saveContract(ContractInDto contractInDto) {

        Optional<Contract> existsContract = this.contractRepository.findByActiveAndEmployeeId(contractInDto.getEmployeeId());

        if (existsContract.isPresent()) {
            Contract contract = existsContract.get();
            contract.setDateTo(LocalDate.now());
            contract.getCommon().setIsActive(false);
            this.contractRepository.save(contract);
        }

        Contract newContract = this.contractMapper.mapToEntity(contractInDto);
        this.contractRepository.save(newContract);

        return this.contractMapper.mapToDto(newContract);
    }


}
