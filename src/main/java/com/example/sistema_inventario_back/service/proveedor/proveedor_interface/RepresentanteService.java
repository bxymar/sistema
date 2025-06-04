package com.example.sistema_inventario_back.service.proveedor.proveedor_interface;

import com.example.sistema_inventario_back.dto.proveedor.RepresentanteDTO;
import com.example.sistema_inventario_back.entity.proveedor.Representante;

public interface RepresentanteService {
    Representante createRepresentante(RepresentanteDTO representanteDTO);
}