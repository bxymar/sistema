package com.example.sistema_inventario_back.entity.proveedor;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Ciudad {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer idCiudad;

    @NonNull
    private String nombreCiudad;

    @NonNull
    private Boolean estadoCiudad;

    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais pais;
}