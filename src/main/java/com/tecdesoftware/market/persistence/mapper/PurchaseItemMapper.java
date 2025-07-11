package com.tecdesoftware.market.persistence.mapper;

import com.tecdesoftware.market.domain.PurchaseItem;
import com.tecdesoftware.market.persistence.entity.CompraProducto;
import com.tecdesoftware.market.persistence.entity.Producto;
import org.mapstruct.InheritInverseConfiguration;
import  org.mapstruct.Mapper;
import  org.mapstruct.Mapping;
import  org.mapstruct.Mappings;

@Mapper(componentModel = "Spring")
public interface PurchaseItemMapper {

    @Mappings({
            @Mapping(source = "id.producto", target = "productid"),
            @Mapping(source = "cantidad", target = "quantity"),
            @Mapping(source = "estado", target = "active"),
    })
    PurchaseItem topurchaseItem(CompraProducto product);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target ="id.idCompra", ignore = true),
            @Mapping(target = "compra", ignore = true),
            @Mapping(target = "producto", ignore = true)
    })
    CompraProducto toCompraProducto(PurchaseItem item);
}
