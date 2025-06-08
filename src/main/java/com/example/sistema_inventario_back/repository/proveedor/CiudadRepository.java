package com.example.sistema_inventario_back.repository.proveedor;

import com.example.sistema_inventario_back.entity.proveedor.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.List;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

    List<Ciudad> findByEstadoCiudad(Boolean estadoCiudad);
}