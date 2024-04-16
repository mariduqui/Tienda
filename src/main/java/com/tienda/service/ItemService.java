
package com.tienda.service;

import com.tienda.domain.Item;
import java.util.ArrayList;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface ItemService {
    //Esta estructura almacena en memoria la lista de productos que deseo comprar
    List<Item> listaItems = new ArrayList<>();
    
    public List<Item> gets();
    public Item get(Item item);
    
    public void delete(Item item);
    
    public void save(Item item);
    
    public void update(Item item);
    
    public void facturar();
    
}
