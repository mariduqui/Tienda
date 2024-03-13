
package com.tienda.controller;

import com.tienda.domain.Producto;
import com.tienda.service.CategoriaService;
import com.tienda.service.ProductoService;
import com.tienda.service.impl.FirebaseStorageServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;


@Controller
@RequestMapping("/producto")
public class ProductoController {
    
    @Autowired
    private ProductoService productoService;
    @Autowired
    private CategoriaService categoriaService;

    @GetMapping("/listado")
    public String listado(Model model) {
        var lista = productoService.getProductos(false);
        model.addAttribute("productos", lista);
        model.addAttribute("totalProductos", lista.size());

        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        return "/producto/listado";
    }

    @Autowired
    private FirebaseStorageServiceImpl firebaseStorageServiceImpl;
    
    @PostMapping("/guardar")
    public String guardar(Producto producto, 
            @RequestParam ("imagenFile")MultipartFile imagenFile) {
        
        if(!imagenFile.isEmpty()){
            //Se debe subir la imagen
            productoService.save(producto);
            String rutaImagen=firebaseStorageServiceImpl.cargaImagen(imagenFile, "producto", producto.getIdProducto());
            producto.setRutaImagen(rutaImagen);
        }
        
        productoService.save(producto);
        return"redirect:/producto/listado";
           }
    
        @GetMapping("/modificar/{idProducto}")
    public String modifica(Producto producto, Model model) {
        var categorias = categoriaService.getCategorias(true);
        model.addAttribute("categorias", categorias);
        producto = productoService.getProducto(producto);
        model.addAttribute("producto", producto);

        return "/producto/modifica";
    }
        
        @GetMapping("/eliminar/{idProducto}")
        public String elimina (Producto producto){
            productoService.delete(producto);
                return "redirect:/producto/listado";
            }
        
    
}
