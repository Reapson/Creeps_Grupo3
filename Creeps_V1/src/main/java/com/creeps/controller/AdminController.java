package com.creeps.controller;

import com.creeps.domain.Producto;
import com.creeps.service.ProductoService;
import com.creeps.service.impl.FirebaseStorageServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

@Controller
@Slf4j
@RequestMapping("/admin")
public class AdminController {
    
    @Autowired
    private ProductoService productoService;
    
    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;
    
    @GetMapping("admin")
    public String inicio(Model model) {
        var productos = productoService.getProductos();
        model.addAttribute("productos", productos);
        return "/admin/admin";
    }
    
    
    @PostMapping("/registrarProducto")
    public String productoRegistrar(Producto producto,            
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setUrlImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "producto",
                            producto.getIdProducto()
                    )
            );
        }
        productoService.save(producto);
        return "redirect:/admin/admin";   
    }
    
    @GetMapping("/modificarProducto/{idProducto}")
    public String categoriaModificar(Producto producto, Model model) {
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);
        return "/producto/modificar";
    }
    
    @PostMapping("/guardarProducto")
    public String productoGuardar(Producto producto,
            @RequestParam("imagenFile") MultipartFile imagenFile) {        
        if (!imagenFile.isEmpty()) {
            productoService.save(producto);
            producto.setUrlImagen(
                    firebaseStorageService.cargaImagen(
                            imagenFile,
                            "producto",
                            producto.getIdProducto()
                    )
            );
        }
        productoService.save(producto);
        return "redirect:/admin/admin";
    }
}
