package com.example.sistema_inventario_back.service.proveedor.proveedor_interface;

import com.example.sistema_inventario_back.dto.proveedor.CiudadDTO;
import com.example.sistema_inventario_back.entity.proveedor.Ciudad;

public interface CiudadService {
    Ciudad createCiudad(CiudadDTO ciudadDTO);
}