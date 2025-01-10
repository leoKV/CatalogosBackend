package com.example.CatalogoBackend.Service;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CatalogoBackend.Model.CatalogoTipoPago;
import com.example.CatalogoBackend.Model.TipoPago;
import com.google.gson.Gson;

@Service
public class CatalogoService {
	@Autowired
    private RabbitMQSender rabbitMQSender;
	
	private final Gson gson = new Gson();
	
    // Método para enviar catálogos automáticamente
    public void sendCatalogs() {
        List<CatalogoTipoPago> catalogos = getCatalogos();
        catalogos.forEach(catalogo -> {
            String catalogoJson = gson.toJson(catalogo);
            rabbitMQSender.sendCatalogs(catalogoJson); 
        });
    }
    
    // Método para obtener catálogos simulados
    private List<CatalogoTipoPago> getCatalogos() {
        List<CatalogoTipoPago> catalogos = new ArrayList<>();
        List<TipoPago> tipoPagoList = new ArrayList<>();

        tipoPagoList.add(new TipoPago(0, "Devoluciones", "O"));
        tipoPagoList.add(new TipoPago(1, "Tercero a Tercero", "O"));
        tipoPagoList.add(new TipoPago(2, "Tercero a Ventanilla", "P"));
        tipoPagoList.add(new TipoPago(3, "Tercero a Tercero Vostro", "O"));
        tipoPagoList.add(new TipoPago(4, "Tercero a Participante", "P"));
        tipoPagoList.add(new TipoPago(5, "Participante a Tercero", "P"));
        tipoPagoList.add(new TipoPago(6, "Participante a Tercero Vostro", "P"));
        tipoPagoList.add(new TipoPago(7, "Participante a Participante", "O"));
        tipoPagoList.add(new TipoPago(8, "Tercero a Tercero FSW", "P"));
        tipoPagoList.add(new TipoPago(9, "Tercero a Tercero Vostro FSW", "P"));
        tipoPagoList.add(new TipoPago(10, "Participante a Tercero FSW", "P"));
        tipoPagoList.add(new TipoPago(11, "Participante a Tercero Vostro FSW", "P"));
        tipoPagoList.add(new TipoPago(12, "Nomina", "O"));
        tipoPagoList.add(new TipoPago(14, "Pago por Celular", "P"));
        tipoPagoList.add(new TipoPago(15, "Factura", "P"));
        tipoPagoList.add(new TipoPago(16, "Devolución Extemporánea", "O"));
        tipoPagoList.add(new TipoPago(17, "Retorno", "O"));
        tipoPagoList.add(new TipoPago(18, "Retorno Extemporáneo", "O"));
        tipoPagoList.add(new TipoPago(19, "Cobros presenciales de una ocasión", "P"));
        tipoPagoList.add(new TipoPago(20, "Cobros no presenciales de una ocasión", "P"));
        tipoPagoList.add(new TipoPago(21, "Cobros no presenciales recurrentes", "P"));
        tipoPagoList.add(new TipoPago(22, "Cobros no presenciales recurrentes y no recurrentes a nombre de un tercero", "P"));
        tipoPagoList.add(new TipoPago(23, "Retorno especial", "O"));
        tipoPagoList.add(new TipoPago(24, "Retorno Extemporáneo especial", "O"));
        tipoPagoList.add(new TipoPago(25, "Tercero a Tercero FSW CLS", "P"));
        tipoPagoList.add(new TipoPago(26, "Tercero a tercero vostro FSW CLS", "P"));
        tipoPagoList.add(new TipoPago(27, "Participante a tercero FSW CLS", "P"));
        tipoPagoList.add(new TipoPago(28, "Participante a tercero vostro FSW CLS", "P"));
        tipoPagoList.add(new TipoPago(29, "Participante a Participante FSW CLS", "P"));
        tipoPagoList.add(new TipoPago(30, "Tercero indirecto a tercero", "O"));
        tipoPagoList.add(new TipoPago(31, "Tercero indirecto a participante", "O"));
        tipoPagoList.add(new TipoPago(32, "Presencial de una ocasión indirecta", "O"));
        tipoPagoList.add(new TipoPago(33, "No presencial de una ocasión indirecta", "O"));
        tipoPagoList.add(new TipoPago(34, "No presencial recurrente indirecta", "O"));
        tipoPagoList.add(new TipoPago(35, "Remesa saliente", "O"));
        tipoPagoList.add(new TipoPago(36, "Remesa entrante", "O"));

        CatalogoTipoPago catalogo = new CatalogoTipoPago(tipoPagoList, new Date());
        catalogos.add(catalogo);
        return catalogos;
    }
    

}
