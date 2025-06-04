package com.example.sistema_inventario_back.repository.proveedor;

import com.example.sistema_inventario_back.entity.proveedor.Ciudad;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CiudadRepository extends JpaRepository<Ciudad, Integer> {

}