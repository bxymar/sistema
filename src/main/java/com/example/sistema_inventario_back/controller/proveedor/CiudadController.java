package com.example.sistema_inventario_back.controller.proveedor;

import com.example.sistema_inventario_back.dto.proveedor.CiudadDTO;
import com.example.sistema_inventario_back.dto.proveedor.CiudadResponseDTO;
import com.example.sistema_inventario_back.entity.proveedor.Ciudad;
import com.example.sistema_inventario_back.service.proveedor.proveedor_interface.CiudadService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

    //Controlador para actualizar el estado de la ciudad
    @PutMapping("/actualizar/{id}/estado")
    public ResponseEntity<Ciudad> updateEstadoCiudad(
            @PathVariable Integer id
    ){
        Ciudad ciudadActualizada = ciudadService.updateEstadoCiudad(id, false);
        return ResponseEntity.ok(ciudadActualizada);
    }

    //Controlador para listar a todas las ciudades activos
    @GetMapping("/listar_ciudades")
    public ResponseEntity<?> getAllCiudadesController(){
        try{
            List<CiudadResponseDTO> ciudades = ciudadService.getAllCiudades();
            return ResponseEntity.ok(ciudades);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    @GetMapping("/listar_ciudades_inactivos")
    public ResponseEntity<?> getAllCiudadesEstadoFalseController(){
        try{
            List<CiudadResponseDTO> ciudades = ciudadService.getAllCiudadesEstadoFalse();
            return ResponseEntity.ok(ciudades);
        }catch (RuntimeException e){
            return ResponseEntity.badRequest().body(e.getMessage());
        }
    }

    //Controlador para llamar una ciudad segun el id
    @GetMapping("/buscar/{id}")
    public ResponseEntity<CiudadResponseDTO> getCiudadById(@PathVariable Integer id){
        CiudadResponseDTO ciudadResponseDTO = ciudadService.getCiudadById(id);
        return ResponseEntity.ok(ciudadResponseDTO);
    }

    //Controlador para actualizar la ciudad
    @PutMapping("/actualizar/{id}")
    public ResponseEntity<CiudadResponseDTO> updateCiudad(@PathVariable Integer id, @RequestBody CiudadDTO ciudadDTO){
        CiudadResponseDTO ciudad = ciudadService.updateCiudad(id, ciudadDTO);
        return ResponseEntity.ok(ciudad);
    }
}
