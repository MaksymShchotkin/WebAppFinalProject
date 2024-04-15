package ee.mainor.demo.service;

import ee.mainor.demo.dto.CreateJobRequest;
import ee.mainor.demo.dto.JobDTO;
import ee.mainor.demo.mapper.JobMapper;
import ee.mainor.demo.model.Job;
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
public class JobService {


    private final JobRepository jobRepository;

    public JobDTO create(CreateJobRequest createJobRequest) {
        Job job = JobMapper.toEntity(createJobRequest);
        Job saved = jobRepository.save(job);
        return JobMapper.toDTO(saved);
    }

    public JobDTO update(Long id, JobDTO jobDTO) {
        Job job = JobMapper.updateEntity(jobDTO, requireJob(id));

        return JobMapper.toDTO(jobRepository.save(job));
    }

    public List<JobDTO> getAll() {
        return jobRepository.findAll()
                .stream()
                .map(JobMapper::toDTO)
                .toList();
    }

    public JobDTO findById(Long id) {
        Job job = requireJob(id);
        return JobMapper.toDTO(job);
    }

    public List<JobDTO> findByAllByName(String name) {
        List<Job> jobs = jobRepository.findAllByName(name);
        return jobs
                .stream()
                .map(JobMapper::toDTO)
                .toList();

    }

    private Job requireJob(Long id) {
        return jobRepository.findById(id).orElseThrow(() -> new IllegalArgumentException("job not dount"));
    }

}
