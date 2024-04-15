package ee.mainor.demo.mapper;

import ee.mainor.demo.dto.CreateJobRequest;
import ee.mainor.demo.dto.JobDTO;
import ee.mainor.demo.model.Job;

public class JobMapper {
    public static Job updateEntity(JobDTO source, Job target) {
        target.setAge(source.getAge());
        target.setName(source.getName());
        target.setSalary(source.getSalary());
        return target;
    }

    public static JobDTO toDTO(Job request) {
        JobDTO jobDTO = new JobDTO();
        jobDTO.setId(request.getId());
        jobDTO.setName(request.getName());
        jobDTO.setSalary(request.getSalary());
        jobDTO.setAge(request.getAge());
        return jobDTO;
    }


    public static Job toEntity(CreateJobRequest request) {
        Job job = new Job();
        job.setName(request.getName());
        job.setSalary(request.getSalary());
        job.setAge(request.getAge());
        return job;
    }
}
