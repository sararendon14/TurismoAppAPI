package com.example.turismoApp.repositorio;

import com.example.turismoApp.modelos.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository

public interface EmpresaRepositorio extends JpaRepository<Empresa,Integer>
{

}
