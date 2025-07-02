package com.tecdesoftware.market.persistence;

import com.tecdesoftware.market.persistence.crud.ProductoCrudRepository;
import com.tecdesoftware.market.persistence.entity.Producto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductoRepository {

    @Autowired
    private ProductoCrudRepository productoCrudRepository;

    public List<Producto> getAll() {
        return (List<Producto>) productoCrudRepository.findAll();
    }

    // Obtener productos por categoría ordenados por nombre ascendente
    public List<Producto> findByCategoriaOrderByNombreAsc(int idCategoria) {
        return productoCrudRepository.findByIdCategoriaOrderByNombreAsc(idCategoria);
    }

    // Obtener productos escasos (por debajo de cierta cantidad y estado activo)
    public Optional<List<Producto>> getEscasos(int cantidad) {
        return productoCrudRepository.findByCantidadStockLessThanAndEstado(cantidad, true);
    }

    // Obtener producto por ID
    public Optional<Producto> getProductoById(int idProducto) {
        return productoCrudRepository.findById(idProducto);
    }

    // Guardar producto
    public Producto saveProducto(Producto producto) {
        return productoCrudRepository.save(producto);
    }
}
