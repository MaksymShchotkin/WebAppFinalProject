package ee.mainor.demo.service;

import ee.mainor.demo.dto.CreateEmployeeRequest;
import ee.mainor.demo.dto.EmployeeDTO;
import ee.mainor.demo.mapper.EmployeeMapper;
import ee.mainor.demo.model.Employee;
import ee.mainor.demo.model.Job;
import ee.mainor.demo.repository.EmployeeRepository;
import ee.mainor.demo.repository.JobRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jdbc.repository.config.EnableJdbcRepositories;
import org.springframework.data.relational.core.sql.In;
import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;


@Service
@RequiredArgsConstructor
@ComponentScan
public class EmployeeService {


    private final EmployeeRepository employeeRepository;
    private final JobRepository jobRepository;

    public EmployeeDTO create(CreateEmployeeRequest createEmployeeRequest) {
        Employee employee = EmployeeMapper.toEntity(createEmployeeRequest);
        Employee saved = employeeRepository.save(employee);
        return EmployeeMapper.toDTO(saved);
    }

    public EmployeeDTO update(Long id, EmployeeDTO employeeDTO) {
        Employee employee = EmployeeMapper.updateEntity(employeeDTO, requireEmployee(id));

        return EmployeeMapper.toDTO(employeeRepository.save(employee));
    }

    public List<EmployeeDTO> getAll() {
        return employeeRepository.findAll()
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();
    }

    public EmployeeDTO findById(Long id) {
        Employee employee = requireEmployee(id);
        return EmployeeMapper.toDTO(employee);
    }

    public List<EmployeeDTO> findByAllByName(String name) {
        List<Employee> employees = employeeRepository.findAllByName(name);
        return employees
                .stream()
                .map(EmployeeMapper::toDTO)
                .toList();

    }

    public Double calculate_salary(Long id){
        Optional<Employee> optionalEmployee = employeeRepository.findById(id);


        if (optionalEmployee.isPresent()) {
            Employee employee = optionalEmployee.get();
            Job job = jobRepository.findByName(employee.getPosition());


            return ((employee.getAge()*0.01) +1)*job.getSalary(); // Handle case where position is not found
        } else {
            throw new RuntimeException("Employee not found with id: " + id);
        }
    }


    private Employee requireEmployee(Long id) {
        return employeeRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("employee not dount"));
    }

}
