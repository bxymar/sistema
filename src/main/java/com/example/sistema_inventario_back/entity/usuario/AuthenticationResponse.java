package com.example.sistema_inventario_back.entity.usuario;

import com.example.sistema_inventario_back.entity.Role;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class AuthenticationResponse {
    private String token;
    private Role role;
}
