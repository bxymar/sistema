package com.example.sistema_inventario_back.dto.proveedor;

import lombok.Data;

@Data
public class CiudadResponseDTO {
    private Integer idCiudad;
    private String nombreCiudad;
    private Boolean estadoCiudad;
    private Integer idPais;
    private String nombrePais;
}