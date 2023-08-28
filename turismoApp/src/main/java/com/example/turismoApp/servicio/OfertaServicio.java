package com.example.turismoApp.servicio;
import com.example.turismoApp.modelos.Empresa;
import com.example.turismoApp.modelos.Oferta;
import com.example.turismoApp.repositorio.OfertaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class OfertaServicio {
    @Autowired
    OfertaRepositorio ofertaRepositorio;

    public Oferta registrarOferta(Oferta datosARegistrar) throws Exception {


        try {
            return (this.ofertaRepositorio.save(datosARegistrar));

        }catch (Exception error) {
            throw new Exception(error.getMessage());

    }
}
   public Oferta modificarOferta(Integer id, Oferta datosAModificar) throws Exception{
       Optional<Oferta> ofertaEncontrada=this.ofertaRepositorio.findById(id);
       if(ofertaEncontrada.isEmpty()){
           throw new Exception ("Oferta no existente");
       }
       Oferta ofertaExistente= ofertaEncontrada.get();
       ofertaExistente.setTitulo(datosAModificar.getTitulo());
       ofertaExistente.setDescripcion(datosAModificar.getDescripcion());

        try{
            return(this.ofertaRepositorio.save(ofertaExistente));
    } catch (Exception error) {
        throw new Exception(error.getMessage());
    }

}
    public Oferta buscarOfertaPorId(Integer id) throws Exception{
        try {

            Optional<Oferta> ofertaOpcional= this.ofertaRepositorio.findById(id);
            if (ofertaOpcional.isEmpty()){
                throw new Exception("oferta no encontrada");
            }
            return ofertaOpcional.get();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public List<Oferta> buscarTodasLasOfertas() throws Exception{
        try{

            List<Oferta> listaOferta = this.ofertaRepositorio.findAll();
            return listaOferta;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public boolean eliminarOferta(Integer id) throws Exception {
        try {
            Optional <Oferta> ofertaOpcional=this.ofertaRepositorio.findById(id);
            if (ofertaOpcional.isPresent()){
                this.ofertaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Oferta no existente");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}


