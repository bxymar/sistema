package com.example.sistema_inventario_back.controller.proveedor;

import com.example.sistema_inventario_back.dto.proveedor.RepresentanteDTO;
import com.example.sistema_inventario_back.entity.proveedor.Representante;
import com.example.sistema_inventario_back.service.proveedor.proveedor_interface.RepresentanteService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/representante")
public class RepresentanteController {
    @Autowired
    private RepresentanteService representanteService;

    //Controlador para crear una nueva ciudad
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crear_representante")
    public ResponseEntity<?> createRepresentanteController(@RequestBody RepresentanteDTO representanteDTO){
        try{
            Representante representanteCreada = representanteService.createRepresentante(representanteDTO);
            return ResponseEntity.ok(representanteCreada);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }
}