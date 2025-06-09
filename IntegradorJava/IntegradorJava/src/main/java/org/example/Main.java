package org.example;

import org.example.Entities.*;
import org.example.Entities.DAOs.EmpresaDAO;
import org.example.Entities.Enums.FormaPago;
import org.example.Entities.Enums.TipoPromocion;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Main {
    public static void main(String[] args) {

        Imagen imagen = Imagen.builder()
                .denominacion("Foto generica")
                .build();

        Pais pais = Pais.builder()
                .nombre("Argentina")
                .build();

        Provincia provincia = Provincia.builder()
                .nombre("Buenos Aires")
                .pais(pais)
                .build();

        Localidad localidad = Localidad.builder()
                .nombre("La Plata")
                .provincia(provincia)
                .build();

        Domicilio domicilio = Domicilio.builder()
                .calle("Calle Falsa")
                .numero(123)
                .localidad(localidad)
                .build();

        Categoria categoria = Categoria.builder()
                .denominacion("Limpieza")
                .build();

        UnidadMedida unidad = UnidadMedida.builder()
                .denominacion("Litros")
                .build();

        ArticuloInsumo insumo = ArticuloInsumo.builder()
                .denominacion("Lavandina")
                .unidadMedida(unidad)
                .build();

        ArticuloManufacturadoDetalle detalleArt = ArticuloManufacturadoDetalle.builder()
                .cantidad(2)
                .articuloInsumo(insumo)
                .build();

        ArticuloManufacturado articuloMan = ArticuloManufacturado.builder()
                .denominacion("Combo limpieza")
                .unidadMedida(unidad)
                .build();

        articuloMan.agregarArticuloManufacturadoDetalle(detalleArt);

        Promocion promo = Promocion.builder()
                .denominacion("Promo 2x1")
                .tipoPromocion(TipoPromocion.PROMOCION_1)
                .build();

        promo.agregarArticulo(articuloMan);
        promo.agregarImagen(imagen);

        DetallePedido detallePedido = DetallePedido.builder()
                .cantidad(1)
                .subtotal(150)
                .articulo(articuloMan)
                .build();

        Factura factura = Factura.builder()
                .formaPago(FormaPago.EFECTIVO)
                .build();

        Sucursal sucursal = Sucursal.builder()
                .nombre("Sucursal Centro")
                .domicilio(domicilio)
                .build();

        sucursal.agregarCategoria(categoria);
        sucursal.agregarPromocion(promo);

        Pedido pedido = Pedido.builder()
                .sucursal(sucursal)
                .factura(factura)
                .build();

        pedido.agregarDetallePedido(detallePedido);

        Usuario usuarioHard = Usuario.builder()
                .username("admin")
                .build();

        Cliente cliente = Cliente.builder()
                .nombre("Juan")
                .apellido("Pérez")
                .usuario(usuarioHard)
                .imagen(imagen)
                .build();

        cliente.agregarDomicilio(domicilio);
        cliente.agregarPedido(pedido);
        // Datos de conexión
        String url = "jdbc:mysql://localhost:3307/pruebas";
        String usuario = "root"; // o el usuario que tengan
        String clave = "";       // clave de MySQL (por defecto en XAMPP puede estar vacía)
        try(Connection conexion = DriverManager.getConnection(url,usuario,clave)){
            System.out.println("✅ ¡Conexión exitosa!");


            Empresa empresa = Empresa.builder()
                    .nombre("CleanCo")
                    .razonSocial("Clean Company S.A.")
                    .cuil(30123456)
                    .build();

            empresa.agregarSucursal(sucursal);

            //Agregar las demás clases y relaciones

            EmpresaDAO empresaDAO = new EmpresaDAO();
            empresaDAO.save(conexion, empresa);

            System.out.println("🔒 Conexión cerrada.");
        } catch (SQLException e) {
            System.out.println("❌ Error al conectar a la base de datos.");
            e.printStackTrace();
        }
        System.out.println("Datos generados correctamente.");
    }
}
// Imagen imagen = new Imagen("Foto generica");//// Pais pais = new Pais();// pais.setNombre("Argentina");//// Provincia provincia = new Provincia();// provincia.setNombre("Buenos Aires");// provincia.setPais(pais);//// Localidad localidad = new Localidad();// localidad.setNombre("La Plata");// localidad.setProvincia(provincia);//// Domicilio domicilio = new Domicilio();// domicilio.setCalle("Calle Falsa");// domicilio.setNumero(123);// domicilio.setLocalidad(localidad);//// Categoria categoria = new Categoria();// categoria.setDenominacion("Limpieza");//// UnidadMedida unidad = new UnidadMedida();// unidad.setDenominacion("Litros");//// ArticuloInsumo insumo = new ArticuloInsumo();// insumo.setDenominacion("Lavandina");// insumo.setUnidadMedida(unidad);//// ArticuloManufacturadoDetalle detalleArt = new ArticuloManufacturadoDetalle();// detalleArt.setCantidad(2);// detalleArt.setArticuloInsumo(insumo);//// ArticuloManufacturado articuloMan = new ArticuloManufacturado();// articuloMan.setDenominacion("Combo limpieza");// articuloMan.setUnidadMedida(unidad);// articuloMan.agregarArticuloManufacturadoDetalle(detalleArt);//// Promocion promo = new Promocion();// promo.setDenominacion("Promo 2x1");// promo.setTipoPromocion(TipoPromocion.PROMOCION_1);// promo.agregarArticulo(articuloMan);// promo.agregarImagen(imagen);//// Sucursal sucursal = new Sucursal();// sucursal.setNombre("Sucursal Centro");// sucursal.setDomicilio(domicilio);// sucursal.agregarCategoria(categoria);// sucursal.agregarPromocion(promo);//// Empresa empresa = new Empresa();// empresa.setNombre("CleanCo");// empresa.setRazonSocial("Clean Company S.A.");// empresa.setCuil(30-12345678-9);// empresa.agregarSucursal(sucursal);//// DetallePedido detallePedido = new DetallePedido();// detallePedido.setCantidad(1);// detallePedido.setSubtotal(150);// detallePedido.setArticulo(articuloMan);//// Factura factura = new Factura();// factura.setFormaPago(FormaPago.EFECTIVO);//// Pedido pedido = new Pedido();// pedido.setSucursal(sucursal);// pedido.agregarDetallePedido(detallePedido);// pedido.setFactura(factura);//// Usuario usuario = new Usuario();// usuario.setUsername("admin");//// Cliente cliente = new Cliente();// cliente.setNombre("Juan");// cliente.setApellido("Pérez");// cliente.agregarDomicilio(domicilio);// cliente.agregarPedido(pedido);// cliente.setUsuario(usuario);// cliente.setImagen(imagen);