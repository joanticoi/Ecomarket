package com.hospital_vm.cl.hospital_vm.repository;


import com.hospital_vm.cl.hospital_vm.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
}
