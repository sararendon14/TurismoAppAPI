package com.example.turismoApp.servicio;

import com.example.turismoApp.modelos.Empresa;
import com.example.turismoApp.repositorio.EmpresaRepositorio;
import com.example.turismoApp.validaciones.EmpresaValidacion;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmpresaServicio
{
    @Autowired
    EmpresaRepositorio empresaRepositorio;
    EmpresaValidacion empresaValidacion;
    @Autowired
    public Empresa registrarEmpresa(Empresa datosARegistrar) throws Exception {
        try {
            //validaciones
            if (!this.empresaValidacion.validarNombre(datosARegistrar.getNombre())) {
                throw new Exception("fallo en el servicio");
            }
            //flta validar el nit
            //Si paso todos los filtros estoy listo para llamar al repositorio
            return(this.empresaRepositorio.save(datosARegistrar));

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }
    public Empresa modificarEmpresa(Integer id, Empresa datosAModificar) throws Exception{
        try {
            if (!this.empresaValidacion.validarNombre(datosAModificar.getNombre())) {
                throw new Exception("error en el dato entregado");

            }
            Optional<Empresa> empresaEncontrada=this.empresaRepositorio.findById(id);
            if(empresaEncontrada.isEmpty()){
                throw new Exception ("empresa no encontrada");
            }
            Empresa empresaQueExiste= empresaEncontrada.get();
            empresaQueExiste.setNombre(datosAModificar.getNombre());

            return(this.empresaRepositorio.save(empresaQueExiste));

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }

    }
    public Empresa buscarEmpresaPorId(Integer id) throws Exception{
        try {

            Optional<Empresa> empresaOpcional= this.empresaRepositorio.findById(id);
            if (empresaOpcional.isEmpty()){
                throw new Exception("empresa no encontrada");
            }
            return empresaOpcional.get();
        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }
    public List<Empresa> buscarTodasEmpresas() throws Exception{
        try{

            List<Empresa> listaEmpresa = this.empresaRepositorio.findAll();
            return listaEmpresa;

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }

    public boolean eliminarEmpresa(Integer id) throws Exception {
        try {
            Optional <Empresa> empresaOpcional=this.empresaRepositorio.findById(id);
            if (empresaOpcional.isPresent()){
                this.empresaRepositorio.deleteById(id);
                return true;
            }else{
                throw new Exception("Empresa no existente");
            }

        } catch (Exception error) {
            throw new Exception(error.getMessage());
        }
    }

}
