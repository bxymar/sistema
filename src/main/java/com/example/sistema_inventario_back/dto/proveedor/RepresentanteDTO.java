package com.example.sistema_inventario_back.dto.proveedor;

import lombok.Data;

@Data
public class RepresentanteDTO {
    private String nombres;
    private String apellido_paterno;
    private String apellido_materno;
    private String cedula_identidad_representante;
    private String numero_celular_representante;
}