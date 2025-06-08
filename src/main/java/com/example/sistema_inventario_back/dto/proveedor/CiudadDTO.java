package com.example.sistema_inventario_back.dto.proveedor;

import lombok.Data;

@Data
public class CiudadDTO {
    private String nombreCiudad;
    private Boolean estadoCiudad;
    private Integer idPais;
}