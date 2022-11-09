package com.ufps.UFPSaberPRO.security.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import com.ufps.UFPSaberPRO.security.entity.Usuario;
import com.ufps.UFPSaberPRO.converter.ConvocatoriaConverter;
import com.ufps.UFPSaberPRO.dto.ConvocatoriaDTO;
import com.ufps.UFPSaberPRO.entity.Convocatoria;
import com.ufps.UFPSaberPRO.security.converter.UsuarioConverter;
import com.ufps.UFPSaberPRO.security.dao.UsuarioRepository;
import com.ufps.UFPSaberPRO.security.dto.UsuarioDTO;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class UsuarioService {
    private final UsuarioRepository usuarioRepository;

    @Autowired
    public UsuarioService(UsuarioRepository usuarioRepository) {
        this.usuarioRepository = usuarioRepository;
    }

    public Usuario getByCodigo_Email(String codigo,String email){
        return usuarioRepository.findByCodigo_Email(codigo,email);
    }
    
    public Usuario getByEmail(String email){
        return usuarioRepository.findByEmail(email);
    }
    
    public boolean existByEmail(String email){
        return usuarioRepository.existsByEmail(email);
    }
    public void save(Usuario user){
        usuarioRepository.save(user);
    }
    
    public Usuario findUserById(Long id){
        return usuarioRepository.findById(id).get();
    }
    
    public List<UsuarioDTO> getAllByUsuPrg(Long id_usuario, Long id_programa){
    	List<UsuarioDTO> usuarios = new ArrayList<>();
		UsuarioConverter converter = new UsuarioConverter();
		for (Usuario user : usuarioRepository.findAllByUsuPrg(id_usuario,id_programa)) {
			usuarios.add(converter.converterToDTO(user));
		}
		return usuarios;
    }
    
}
