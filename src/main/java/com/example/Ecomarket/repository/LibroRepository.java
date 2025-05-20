package com.hospital_vm.cl.hospital_vm.repository;


import com.hospital_vm.cl.hospital_vm.model.Libros;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LibroRepository extends JpaRepository<Libros, Long> {
}
