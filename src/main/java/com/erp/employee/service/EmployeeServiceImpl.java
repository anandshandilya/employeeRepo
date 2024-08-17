package com.erp.employee.service;

import com.erp.employee.dto.EmployeeDto;
import com.erp.employee.entity.Employee;
import com.erp.employee.repository.EmployeeRepository;
import jakarta.transaction.Transactional;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Transactional
@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(EmployeeDto employeeDto) {
        Employee employee =
                Employee.builder()
                        .name(employeeDto.getName())
                        .email(employeeDto.getEmail())
                        .build();
         return employeeRepository.save(employee);
    }

    @Override
    public Page<Employee> fetchAllEmployees(int pageNo, int pageSize) {
        Pageable pageable = PageRequest.of(pageNo, pageSize);
        return employeeRepository.findAll(pageable);
    }

}
