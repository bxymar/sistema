package com.example.sistema_inventario_back.service.proveedor;

import com.example.sistema_inventario_back.dto.proveedor.CiudadDTO;
import com.example.sistema_inventario_back.dto.proveedor.CiudadResponseDTO;
import com.example.sistema_inventario_back.entity.proveedor.Ciudad;
import com.example.sistema_inventario_back.entity.proveedor.Pais;
import com.example.sistema_inventario_back.repository.proveedor.CiudadRepository;
import com.example.sistema_inventario_back.repository.proveedor.PaisRepository;
import com.example.sistema_inventario_back.service.proveedor.proveedor_interface.CiudadService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.header.writers.StaticHeadersWriter;
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
        Pais pais = paisRepository.findById(ciudadDTO.getIdPais())
                .orElseThrow(() -> new RuntimeException("País no encontrado: " +ciudadDTO.getIdPais()));

        Ciudad ciudad = new Ciudad();
        ciudad.setNombreCiudad(ciudadDTO.getNombreCiudad());
        ciudad.setEstadoCiudad(true);
        ciudad.setPais(pais);

        return ciudadRepository.save(ciudad);
    }

    //Servicio para listar a todas las ciudades con estado activo -> true
    public List<CiudadResponseDTO> getAllCiudadesPorEstado(Boolean estadoCiudad){
        List<Ciudad> ciudades;

        if (estadoCiudad == null){
            ciudades = ciudadRepository.findAll();
        }else{
            ciudades = ciudadRepository.findByEstadoCiudad(estadoCiudad);
        }

        return ciudades.stream()
                .map(this::mapToResponseDTO)
                .toList();
    }

    //Servicio para actualizar el estado de un ciudad
    @Override
    public Ciudad updateEstadoCiudad(Integer id_ciudad, Boolean nuevoEstado){
        Ciudad ciudad = ciudadRepository.findById(id_ciudad)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada con ID: " +id_ciudad));

        //Verificar si realmente hay un cambio
        if(ciudad.getEstadoCiudad().equals(nuevoEstado)){
            throw new RuntimeException("La ciudad ya se encuentra en el estado solicitado");
        }

        ciudad.setEstadoCiudad(nuevoEstado);
        return ciudadRepository.save(ciudad);
    }

    //Servicio para buscar la ciudad por el id
    @Override
    public CiudadResponseDTO getCiudadById(Integer idCiudad){
        Ciudad ciudad = ciudadRepository.findById(idCiudad)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada con ID: " +idCiudad));

        return mapToResponseDTO(ciudad);
    }

    //Servicio para actualizar la ciudad
    @Override
    public CiudadResponseDTO updateCiudad(Integer idCiudad, CiudadDTO ciudadDTO){

        Ciudad ciudad = ciudadRepository.findById(idCiudad)
                .orElseThrow(() -> new RuntimeException("Ciudad no encontrada con ID: " +idCiudad));

        if (ciudadDTO.getNombreCiudad() != null && !ciudadDTO.getNombreCiudad().equals(ciudad.getNombreCiudad())){
            ciudad.setNombreCiudad(ciudadDTO.getNombreCiudad());
        }

        if(ciudadDTO.getIdPais() != null && !ciudadDTO.getIdPais().equals(ciudad.getPais().getIdPais())){
            Pais pais = paisRepository.findById(ciudadDTO.getIdPais())
                    .orElseThrow(() -> new RuntimeException("Pais no encontrado con ID: " +ciudadDTO.getIdPais()));

            ciudad.setPais(pais);
        }

        Ciudad ciudadActualizada = ciudadRepository.save(ciudad);
        return mapToResponseDTO(ciudadActualizada);
    }

    //Metodo para modificar el mapeo Ciudad -> CiudadResponseDTO
    private CiudadResponseDTO mapToResponseDTO(Ciudad ciudad){
        CiudadResponseDTO ciudadResponseDTO = new CiudadResponseDTO();
        ciudadResponseDTO.setIdCiudad(ciudad.getIdCiudad());
        ciudadResponseDTO.setNombreCiudad(ciudad.getNombreCiudad());
        ciudadResponseDTO.setEstadoCiudad(ciudad.getEstadoCiudad());

        if (ciudad.getPais() != null){
            ciudadResponseDTO.setIdPais(ciudad.getPais().getIdPais());
            ciudadResponseDTO.setNombrePais(ciudad.getPais().getNombrePais());
        }

        return ciudadResponseDTO;
    }
}