package com.example.sistema_inventario_back.service.proveedor.proveedor_interface;

import com.example.sistema_inventario_back.dto.proveedor.CiudadDTO;
import com.example.sistema_inventario_back.dto.proveedor.CiudadResponseDTO;
import com.example.sistema_inventario_back.entity.proveedor.Ciudad;

import java.util.List;

public interface CiudadService {

    //Crear una nueva Ciudad
    Ciudad createCiudad(CiudadDTO ciudadDTO);

    //Iterar todas las ciudades
    List<CiudadResponseDTO> getAllCiudadesPorEstado(Boolean estadoCiudad);

    //Actualizar el estado de una ciudad
    Ciudad updateEstadoCiudad(Integer id_ciudad, Boolean nuevoEstado);

    //Llamar una ciudad mediante id
    CiudadResponseDTO getCiudadById(Integer id_ciudad);

    //Actualizar los datos de una ciudad
    CiudadResponseDTO updateCiudad(Integer idCiudad, CiudadDTO ciudadDTO);
}