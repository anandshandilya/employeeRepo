package com.erp.employee.service;

import com.erp.employee.dto.EmployeeDto;
import com.erp.employee.entity.Employee;
import org.springframework.data.domain.Page;

public interface EmployeeService {


    Employee saveEmployee(EmployeeDto employeeDto);

    Page<Employee> fetchAllEmployees(int pageNo, int pageSize);


}
