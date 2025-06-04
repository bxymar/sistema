package com.example.sistema_inventario_back.dto.proveedor;

import lombok.Data;

@Data
public class CiudadResponseDTO {
    private Integer id_ciudad;
    private String nombre_ciudad;
    private Boolean estado_ciudad;
    private Integer id_pais;
    private String nombre_pais;
}