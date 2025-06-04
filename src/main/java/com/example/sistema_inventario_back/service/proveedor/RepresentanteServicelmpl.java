package com.example.sistema_inventario_back.service.proveedor;

import com.example.sistema_inventario_back.dto.proveedor.RepresentanteDTO;
import com.example.sistema_inventario_back.entity.proveedor.Representante;
import com.example.sistema_inventario_back.repository.proveedor.RepresentanteRepository;
import com.example.sistema_inventario_back.service.proveedor.proveedor_interface.RepresentanteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RepresentanteServicelmpl implements RepresentanteService {
    @Autowired
    private RepresentanteRepository representanteRepository;

    //Servicio para crear un nuevo representante
    public Representante createRepresentante(RepresentanteDTO representanteDTO){
        Representante representante = new Representante();
        representante.setNombres(representanteDTO.getNombres());
        representante.setApellido_paterno(representanteDTO.getApellido_paterno());
        representante.setApellido_materno(representanteDTO.getApellido_materno());
        representante.setCedula_identidad_representante(representanteDTO.getCedula_identidad_representante());
        representante.setNumero_celular_representante(representanteDTO.getNumero_celular_representante());

        return representanteRepository.save(representante);
    }
}