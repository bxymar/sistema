package com.example.sistema_inventario_back.entity.proveedor;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@NoArgsConstructor
public class Pais {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id_pais;

    @NonNull
    private String nombre_pais;

    @OneToMany(mappedBy = "pais")
    private List<Ciudad> ciudades;
}