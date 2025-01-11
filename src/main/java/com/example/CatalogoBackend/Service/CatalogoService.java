package com.example.CatalogoBackend.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CatalogoBackend.Model.Catalogo;
import com.example.CatalogoBackend.Model.TipoCuenta;
import com.example.CatalogoBackend.Model.TipoOperacion;
import com.example.CatalogoBackend.Model.TipoPago;
import com.google.gson.Gson;

@Service
public class CatalogoService {
	@Autowired
    private RabbitMQSender rabbitMQSender;
	
	private final Gson gson = new Gson();
	
	private final List<Object> tipoPagoCatalog = new ArrayList<>();
    private final List<Object> tipoCuentaCatalog = new ArrayList<>();
	
	 // Constructor para inicializar los catálogos simulados
    public CatalogoService() {
    	initCatalogs();
    }
    
    // Método para enviar catálogos automáticamente
    public void sendCatalogs() {
        Catalogo catalogo = getCatalogos();
        String catalogoJson = gson.toJson(catalogo);
        rabbitMQSender.sendCatalogs(catalogoJson);
    }
    
    // Método para obtener catálogos simulados
    private Catalogo getCatalogos() {
        Map<String, List<Object>> catalogos = new HashMap<>();
        catalogos.put("TipoPago", tipoPagoCatalog);
        catalogos.put("TipoCuenta", tipoCuentaCatalog);
        return new Catalogo(new ArrayList<>(catalogos.values()), new Date(), new Date());
    }
    
    // Agregar un nuevo catálogo
    public void addCatalog() {
    	TipoPago newPago = new TipoPago(37, "Pago Prueba", "O");
        tipoPagoCatalog.add(newPago);
        sendCatalogs();

    }
    
    // Eliminar un catálogo
    public void removeCatalog() {
        tipoCuentaCatalog.removeIf(catalogo -> 
            catalogo instanceof TipoCuenta && ((TipoCuenta) catalogo).getTipoCuentaId() == 3);
        sendCatalogs();
    }
    
    private void initCatalogs() {
   	 //Tipo de Pago
   	 tipoPagoCatalog.add(new TipoPago(0, "Devoluciones", "O"));
        tipoPagoCatalog.add(new TipoPago(1, "Tercero a Tercero", "O"));
        tipoPagoCatalog.add(new TipoPago(2, "Tercero a Ventanilla", "P"));
        tipoPagoCatalog.add(new TipoPago(3, "Tercero a Tercero Vostro", "O"));
        tipoPagoCatalog.add(new TipoPago(4, "Tercero a Participante", "P"));
        tipoPagoCatalog.add(new TipoPago(5, "Participante a Tercero", "P"));
        tipoPagoCatalog.add(new TipoPago(6, "Participante a Tercero Vostro", "P"));
        tipoPagoCatalog.add(new TipoPago(7, "Participante a Participante", "O"));
        tipoPagoCatalog.add(new TipoPago(8, "Tercero a Tercero FSW", "P"));
        tipoPagoCatalog.add(new TipoPago(9, "Tercero a Tercero Vostro FSW", "P"));
        tipoPagoCatalog.add(new TipoPago(10, "Participante a Tercero FSW", "P"));
        tipoPagoCatalog.add(new TipoPago(11, "Participante a Tercero Vostro FSW", "P"));
        tipoPagoCatalog.add(new TipoPago(12, "Nomina", "O"));
        tipoPagoCatalog.add(new TipoPago(14, "Pago por Celular", "P"));
        tipoPagoCatalog.add(new TipoPago(15, "Factura", "P"));
        tipoPagoCatalog.add(new TipoPago(16, "Devolución Extemporánea", "O"));
        tipoPagoCatalog.add(new TipoPago(17, "Retorno", "O"));
        tipoPagoCatalog.add(new TipoPago(18, "Retorno Extemporáneo", "O"));
        tipoPagoCatalog.add(new TipoPago(19, "Cobros presenciales de una ocasión", "P"));
        tipoPagoCatalog.add(new TipoPago(20, "Cobros no presenciales de una ocasión", "P"));
        tipoPagoCatalog.add(new TipoPago(21, "Cobros no presenciales recurrentes", "P"));
        tipoPagoCatalog.add(new TipoPago(22, "Cobros no presenciales recurrentes y no recurrentes a nombre de un tercero", "P"));
        tipoPagoCatalog.add(new TipoPago(23, "Retorno especial", "O"));
        tipoPagoCatalog.add(new TipoPago(24, "Retorno Extemporáneo especial", "O"));
        tipoPagoCatalog.add(new TipoPago(25, "Tercero a Tercero FSW CLS", "P"));
        tipoPagoCatalog.add(new TipoPago(26, "Tercero a tercero vostro FSW CLS", "P"));
        tipoPagoCatalog.add(new TipoPago(27, "Participante a tercero FSW CLS", "P"));
        tipoPagoCatalog.add(new TipoPago(28, "Participante a tercero vostro FSW CLS", "P"));
        tipoPagoCatalog.add(new TipoPago(29, "Participante a Participante FSW CLS", "P"));
        tipoPagoCatalog.add(new TipoPago(30, "Tercero indirecto a tercero", "O"));
        tipoPagoCatalog.add(new TipoPago(31, "Tercero indirecto a participante", "O"));
        tipoPagoCatalog.add(new TipoPago(32, "Presencial de una ocasión indirecta", "O"));
        tipoPagoCatalog.add(new TipoPago(33, "No presencial de una ocasión indirecta", "O"));
        tipoPagoCatalog.add(new TipoPago(34, "No presencial recurrente indirecta", "O"));
        tipoPagoCatalog.add(new TipoPago(35, "Remesa saliente", "O"));
        tipoPagoCatalog.add(new TipoPago(36, "Remesa entrante", "O"));
        //Tipo de Cuenta
        tipoCuentaCatalog.add(new TipoCuenta(3, "Tarjeta de Débito"));
        tipoCuentaCatalog.add(new TipoCuenta(4, "Cuenta Vostro"));
        tipoCuentaCatalog.add(new TipoCuenta(5, "Custodia de valores"));
        tipoCuentaCatalog.add(new TipoCuenta(6, "Cuenta Vostro 1"));
        tipoCuentaCatalog.add(new TipoCuenta(7, "Cuenta Vostro 2"));
        tipoCuentaCatalog.add(new TipoCuenta(8, "Cuenta Vostro 3"));
        tipoCuentaCatalog.add(new TipoCuenta(9, "Cuenta Vostro 4"));
        tipoCuentaCatalog.add(new TipoCuenta(10, "Teléfono celular"));
        tipoCuentaCatalog.add(new TipoCuenta(40, "CLABE"));
   }
    
}
