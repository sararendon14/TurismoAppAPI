package com.example.turismoApp.repositorio;

import com.example.turismoApp.modelos.Oferta;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface OfertaRepositorio extends JpaRepository<Oferta,Integer>
{


}
