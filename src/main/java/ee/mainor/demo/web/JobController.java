package ee.mainor.demo.web;

import ee.mainor.demo.dto.CreateJobRequest;
import ee.mainor.demo.dto.UpdateJobRequest;
import ee.mainor.demo.dto.JobDTO;
import ee.mainor.demo.service.JobService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("job")
public class JobController {

    private final JobService jobService;

    @PostMapping
    public JobDTO create(@RequestBody CreateJobRequest request) {
        return jobService.create(request);
    }

    @PutMapping("{id}")
    public JobDTO update(@PathVariable Long id, @RequestBody JobDTO request) {
        return jobService.update(id ,request);
    }

    @GetMapping("{id}")
    public JobDTO findById(@PathVariable Long id) {
        return jobService.findById(id);
    }

    @GetMapping("search")
    public List<JobDTO> findById(@RequestParam String name) {
        return jobService.findByAllByName(name);
    }

    @GetMapping
    public List<JobDTO> getAll() {
        return jobService.getAll();
    }
    

    @PutMapping
    public JobDTO update(@RequestBody UpdateJobRequest request) {
        return null;
    }

    @DeleteMapping
    public JobDTO update() {
        return null;
    }

}
