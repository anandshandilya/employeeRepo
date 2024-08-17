package com.erp.employee.controller;

import com.erp.employee.dto.EmployeeDto;
import com.erp.employee.entity.Employee;
import com.erp.employee.service.EmployeeService;
import com.erp.employee.service.LocationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Page;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@Slf4j
@RestController
@RequestMapping(path = "/api/v1")
public class EmployeeController {
    private final EmployeeService employeeService;

    private final LocationService locationService;

    public EmployeeController(EmployeeService employeeService,
                              LocationService locationService) {
        this.employeeService = employeeService;
        this.locationService = locationService;
    }

    @PostMapping("/employee")
    public ResponseEntity<Employee> createEmployee(@RequestBody EmployeeDto employeeDto) {

        log.info("create employee api called");
        return ResponseEntity.ok(employeeService.saveEmployee(employeeDto));
    }

    @GetMapping("/employees")
    public ResponseEntity<Page<Employee>> fetchAllEmployees( @RequestParam(defaultValue = "0") int pageNo,
                                                             @RequestParam(defaultValue = "10") int pageSize) {

        log.info("fetch all employees api called");
        return ResponseEntity.ok(employeeService.fetchAllEmployees(pageNo, pageSize));
    }

    @GetMapping("/location")
    private ResponseEntity<String> getLocation()
    {
        log.info("fetch location string");
        return ResponseEntity.ok(locationService.getLocation());
    }

}
