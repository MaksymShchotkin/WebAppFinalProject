package ee.mainor.demo.web;

import ee.mainor.demo.dto.CreateEmployeeRequest;
import ee.mainor.demo.dto.UpdateEmployeeRequest;
import ee.mainor.demo.dto.EmployeeDTO;
import ee.mainor.demo.service.EmployeeService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("employee")
public class EmployeeController {

    private final EmployeeService employeeService;

    @PostMapping
    public EmployeeDTO create(@RequestBody CreateEmployeeRequest request) {
        return employeeService.create(request);
    }

    @PutMapping("{id}")
    public EmployeeDTO update(@PathVariable Long id, @RequestBody EmployeeDTO request) {
        return employeeService.update(id ,request);
    }

    @GetMapping("{id}")
    public EmployeeDTO findById(@PathVariable Long id) {
        return employeeService.findById(id);
    }

    @GetMapping("search")
    public List<EmployeeDTO> findById(@RequestParam String name) {
        return employeeService.findByAllByName(name);
    }

    @GetMapping
    public List<EmployeeDTO> getAll() {
        return employeeService.getAll();
    }

    @GetMapping("calc-salary")
    public Double calculateSalary(@RequestParam Long id){
        return employeeService.calculate_salary(id);
    }

    @PutMapping
    public EmployeeDTO update(@RequestBody UpdateEmployeeRequest request) {
        return null;
    }

    @DeleteMapping
    public EmployeeDTO update() {
        return null;
    }

}
