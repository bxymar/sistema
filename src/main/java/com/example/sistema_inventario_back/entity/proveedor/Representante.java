package com.example.sistema_inventario_back.entity.proveedor;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Representante {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_representante;

    @NonNull
    private String nombres;

    @NonNull
    private String apellido_paterno;

    @NonNull
    private String apellido_materno;

    @NonNull
    private String cedula_identidad_representante;

    @NonNull
    private String numero_celular_representante;
}