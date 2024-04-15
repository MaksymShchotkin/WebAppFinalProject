package ee.mainor.demo.mapper;

import ee.mainor.demo.dto.CreateEmployeeRequest;
import ee.mainor.demo.dto.EmployeeDTO;
import ee.mainor.demo.model.Employee;

public class EmployeeMapper {
    public static Employee updateEntity(EmployeeDTO source, Employee target) {
        target.setAge(source.getAge());
        target.setName(source.getName());
        target.setPosition(source.getPosition());
        target.setSalary(source.getSalary());
        return target;
    }

    public static EmployeeDTO toDTO(Employee request) {
        EmployeeDTO employeeDTO = new EmployeeDTO();
        employeeDTO.setId(request.getId());
        employeeDTO.setPosition(request.getPosition());
        employeeDTO.setName(request.getName());
        employeeDTO.setSalary(request.getSalary());
        employeeDTO.setAge(request.getAge());
        return employeeDTO;
    }


    public static Employee toEntity(CreateEmployeeRequest request) {
        Employee employee = new Employee();
        employee.setName(request.getName());
        employee.setPosition(request.getPosition());
        employee.setSalary(request.getSalary());
        employee.setAge(request.getAge());
        return employee;
    }
}
