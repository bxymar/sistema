package com.example.sistema_inventario_back.service.proveedor;

import com.example.sistema_inventario_back.dto.proveedor.CiudadDTO;
import com.example.sistema_inventario_back.dto.proveedor.CiudadResponseDTO;
import com.example.sistema_inventario_back.entity.proveedor.Ciudad;
import com.example.sistema_inventario_back.entity.proveedor.Pais;
import com.example.sistema_inventario_back.repository.proveedor.CiudadRepository;
import com.example.sistema_inventario_back.repository.proveedor.PaisRepository;
import com.example.sistema_inventario_back.service.proveedor.proveedor_interface.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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
        ciudad.setEstado_ciudad(true);
        ciudad.setPais(pais);

        return ciudadRepository.save(ciudad);
    }

    //Servicio para listar a todas las ciudades
    @Override
    public List<CiudadResponseDTO> getAllCiudades(){
        List<Ciudad> ciudades = ciudadRepository.findAll();
        return ciudades.stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    //Servicio para actualizar el estado de un ciudad
    @Override
    public Ciudad updateEstadoCiudad(Integer id_ciudad, Boolean nuevoEstado){
        Ciudad ciudad = ciudadRepository.findById(id_ciudad)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada con ID: " +id_ciudad));

        //Validar que el estado actual sea true antes de cambiar a false
        if(!ciudad.getEstado_ciudad()){
            throw new RuntimeException("La ciudad ya se encuentra inactiva");
        }

        //Solo permitir cambiar a false
        if (nuevoEstado.equals(Boolean.FALSE)){
            ciudad.setEstado_ciudad(false);
            return ciudadRepository.save(ciudad);
        } else{
            throw new RuntimeException("Solo se permite desactivar ciudades activas.");
        }
    }

    @Override
    public CiudadResponseDTO getCiudadById(Integer id_ciudad){
        Ciudad ciudad = ciudadRepository.findById(id_ciudad)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada con ID: " +id_ciudad));

        return mapToResponseDTO(ciudad);
    }

    //Metodo para modificar el mapeo Ciudad -> CiudadResponseDTO
    private CiudadResponseDTO mapToResponseDTO(Ciudad ciudad){
        CiudadResponseDTO ciudadResponseDTO = new CiudadResponseDTO();
        ciudadResponseDTO.setId_ciudad(ciudad.getId_cuidad());
        ciudadResponseDTO.setNombre_ciudad(ciudad.getNombre_ciudad());
        ciudadResponseDTO.setEstado_ciudad(ciudad.getEstado_ciudad());

        if (ciudad.getPais() != null){
            ciudadResponseDTO.setId_pais(ciudad.getPais().getId_pais());
            ciudadResponseDTO.setNombre_pais(ciudad.getPais().getNombre_pais());
        }

        return ciudadResponseDTO;
    }
}