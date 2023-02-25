package com.skillathon.backend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.skillathon.backend.model.JobModel;
import com.skillathon.backend.repository.JobRepository;
import lombok.RequiredArgsConstructor;


@Service
@RequiredArgsConstructor
public class JobService {
	
	@Autowired
	private final JobRepository jobRepository ;
	public JobService(JobRepository jobRepository) {
		this.jobRepository = jobRepository;
	}
	
	public List<JobModel> getAllJob(){
		System.out.println(jobRepository.findAll().toString());
		return jobRepository.findAll();
		
	}

	
	public JobModel getJobById(long id) {
		return jobRepository.findById(id).orElseThrow(()->new RuntimeException("Not Found" + id));
	}
	
	public JobModel addJob(JobModel job) {
		return jobRepository.save(job);
	}
	
	public void deleteJob(long id) {
		JobModel job = getJobById(id);
		jobRepository.delete(job);
	}
	
	public JobModel updateJob(JobModel job) {
		return jobRepository.save(job);
	}
}