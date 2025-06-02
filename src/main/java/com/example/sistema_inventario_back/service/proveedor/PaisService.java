package com.example.sistema_inventario_back.service.proveedor;

import com.example.sistema_inventario_back.entity.proveedor.Pais;
import com.example.sistema_inventario_back.repository.proveedor.PaisRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PaisService {

    @Autowired
    private PaisRepository paisRepository;

    //Servicio para crear un nuevo País
    public Pais createPaisService(Pais pais){
        return paisRepository.save(pais);
    }

    //Servicio para listar a todos los Países registrados
    public Iterable<Pais> getAllPaisesService(){
        return paisRepository.findAll();
    }
}
