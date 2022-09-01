package com.example.capstone.serviceImpl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.capstone.converter.NewStudentConverter;
import com.example.capstone.dto.NewStudentDTO;
import com.example.capstone.repository.StudentRepository;
import com.example.capstone.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService{

	@Autowired
	StudentRepository  studentRepository;

	@Autowired
	NewStudentConverter sNewStudentConverter;
	
	@Override
	public NewStudentDTO save(NewStudentDTO newStudentDTO) {
		return sNewStudentConverter.toDTO(studentRepository.save( sNewStudentConverter.toEntity(newStudentDTO)));
		
	}

	@Override
	public List<NewStudentDTO> findAll() {
		List<NewStudentDTO> list = new ArrayList<NewStudentDTO>();
		
		studentRepository.findAll().stream().forEach(studen->{
			list.add(sNewStudentConverter.toDTO(studen));
		});
		
		return list;
	}

	@Override
	public NewStudentDTO findByID(Long Id) {
		// TODO Auto-generated method stub
		
		return sNewStudentConverter.toDTO( studentRepository.findById(Id).get());
	}
	
	
}
