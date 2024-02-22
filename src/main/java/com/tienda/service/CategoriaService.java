
package com.tienda.service;

import com.tienda.domain.Categoria;
import java.util.List;

public interface CategoriaService {
    //Se define la firma del metodo para obtener los registros de categoria, en forma de lista
    public List<Categoria> getCategorias(boolean activo);
    
    //Se recupera un registro tomando el idCategoria como clave de busqueda
    public Categoria getCategoria(Categoria categoria);
    
    //Si idCategoria tiene un valor, se modifica ese registro,
    //Si idCategoria no tiene un valor, se inserta un nuevo registro
    
    public void save (Categoria categoria);
    
    //Se elimina el registro que tenga el valor del idCategoria pasado
    public void delete (Categoria categoria);
}
