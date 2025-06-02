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
    private Integer id_cuidad;

    @NonNull
    private String nombre_ciudad;

    @ManyToOne
    @JoinColumn(name = "id_pais", nullable = false)
    private Pais pais;
}