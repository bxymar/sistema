package com.example.sistema_inventario_back.controller.proveedor;

import com.example.sistema_inventario_back.dto.proveedor.CiudadDTO;
import com.example.sistema_inventario_back.entity.proveedor.Ciudad;
import com.example.sistema_inventario_back.service.proveedor.proveedor_interface.CiudadService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/ciudad")
public class CiudadController {

    @Autowired
    private CiudadService ciudadService;

    //Controlador para crear una nueva Ciudad
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crear_ciudad")
    public ResponseEntity<?> createCiudadController(@RequestBody CiudadDTO ciudadDTO){
        try{
            Ciudad ciudadCreada = ciudadService.createCiudad(ciudadDTO);
            return ResponseEntity.ok(ciudadCreada);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}
