
package com.creeps.controller;

import com.creeps.domain.Genero;
import com.creeps.service.GeneroService;
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

@Controller
@Slf4j
@RequestMapping("/busqueda")
public class BusquedaController {
    
    @Autowired
    private ProductoService productoService;

    @Autowired
    private GeneroService generoService;

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageService;

    @GetMapping("/busqueda")
    public String inicio(Model model) {
        var productos = productoService.getProductos();
        var generos = generoService.getGeneros();
        model.addAttribute("productos", productos);
        model.addAttribute("generos", generos);
        return "/busqueda/busqueda";
    }
    
////    @GetMapping("/filtrada/{genero}")
//    @GetMapping("/filtrada/{idGenero}")
//    public String inicio(Model model, @RequestParam(value = "idGenero", required = false) Genero genero){
//        var productos = generoService.getGenero(genero).getProductos();
//        var generos = generoService.getGeneros();
//        model.addAttribute("productos", productos);
//        model.addAttribute("generos", generos);
//        return "/busqueda/busqueda";        
//    }
    @GetMapping("/filtrada/{idGenero}")
    public String inicio(Model model, @RequestParam(value = "idGenero", required = false) Genero genero){
        var productos = generoService.getGenero(genero).getProductos();
        var generos = generoService.getGeneros();
        model.addAttribute("productos", productos);
        model.addAttribute("generos", generos);
        return "/busqueda/busqueda";        
    }
    
//    @PostMapping("/filtrada")
//    public String consultaQuery1(
//            @RequestParam(value = "idGenero") Long idGenero,
//            Model model) {
//        var productos = productoService.getProductosByGenero(idGenero);
//        model.addAttribute("productos", productos);
//        var generos = generoService.getGeneros();
//        model.addAttribute("productos", productos);
//        model.addAttribute("generos", generos);
//        return "/pruebas/listado2";
//    }
}
