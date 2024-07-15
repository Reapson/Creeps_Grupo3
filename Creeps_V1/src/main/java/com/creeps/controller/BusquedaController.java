
package com.creeps.controller;

import com.creeps.service.ProductoService;
import com.creeps.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping("/busqueda")
public class BusquedaController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("busqueda")
    public String inicio(Model model) {
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        return "/busqueda/busqueda";
    }
}
