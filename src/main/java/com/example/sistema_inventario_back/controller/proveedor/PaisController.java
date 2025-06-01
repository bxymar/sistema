package com.example.sistema_inventario_back.controller.proveedor;

import com.example.sistema_inventario_back.entity.proveedor.Pais;
import com.example.sistema_inventario_back.service.proveedor.PaisService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
@AllArgsConstructor
@RequestMapping("/api/pais")
public class PaisController {

    @Autowired
    private PaisService paisService;

    //Controlador para crear un nuevo Pais
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/crear_pais")
    public Pais createPaisController(@RequestBody Pais pais){
        return paisService.createPaisService(pais);
    }
}