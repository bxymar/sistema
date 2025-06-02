package com.example.sistema_inventario_back.service.proveedor;

import com.example.sistema_inventario_back.dto.proveedor.CiudadDTO;
import com.example.sistema_inventario_back.entity.proveedor.Ciudad;
import com.example.sistema_inventario_back.entity.proveedor.Pais;
import com.example.sistema_inventario_back.repository.proveedor.CiudadRepository;
import com.example.sistema_inventario_back.repository.proveedor.PaisRepository;
import com.example.sistema_inventario_back.service.proveedor.proveedor_interface.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CiudadServicelmpl implements CiudadService {

    @Autowired
    private CiudadRepository ciudadRepository;

    @Autowired
    private PaisRepository paisRepository;

    //Servicio para crear una nueva Ciudad
    @Override
    public Ciudad createCiudad(CiudadDTO ciudadDTO){
        Pais pais = paisRepository.findById(ciudadDTO.getId_pais())
                .orElseThrow(() -> new RuntimeException("País no encontrado: " +ciudadDTO.getId_pais()));

        Ciudad ciudad = new Ciudad();
        ciudad.setNombre_ciudad(ciudadDTO.getNombre_ciudad());
        ciudad.setPais(pais);

        return ciudadRepository.save(ciudad);
    }

    //Servicio para registrar una nueva Ciudad
    public Ciudad createCiudadService(Ciudad ciudad){
        return ciudadRepository.save(ciudad);
    }

    //Servicio para crear una nueva Ciudad
    public Iterable<Ciudad> getAllCiudadService(){
        return ciudadRepository.findAll();
    }
}