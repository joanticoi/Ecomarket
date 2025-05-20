package com.hospital_vm.cl.hospital_vm.service;

import com.hospital_vm.cl.hospital_vm.model.Libros;
import com.hospital_vm.cl.hospital_vm.repository.LibroRepository;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class LibroService {

    @Autowired
    private LibroRepository LibroRepository;

    public List<Libros> BuscarTodosLosPacientes() {
        
        return LibroRepository.findAll();
    }

    public Libros BuscarPorId(long id) {
        return LibroRepository.findById(id).get();
    }

    public Libros save(Libros paciente) {
        return LibroRepository.save(paciente);
    }

    public void delete(Long id) {
        LibroRepository.deleteById(id);
    }
}
