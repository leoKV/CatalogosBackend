package com.example.CatalogoBackend.Service;
import java.text.SimpleDateFormat;
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
    private final List<Object> tipoOperacionCatalog = new ArrayList<>();
	
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
    private Catalogo getCatalogos(){
    	List<Map<String, Object>> catalogos = new ArrayList<>();
    	
    	// Agregar el catálogo de TipoCuenta
        Map<String, Object> tipoCuentaMap = new HashMap<>();
        tipoCuentaMap.put("TipoCuenta", tipoCuentaCatalog);
        catalogos.add(tipoCuentaMap);
        // Agregar el catálogo de TipoPago
        Map<String, Object> tipoPagoMap = new HashMap<>();
        tipoPagoMap.put("TipoPago", tipoPagoCatalog);
        catalogos.add(tipoPagoMap);
        // Agregar el catálogo de TipoOperacion
        Map<String, Object> tipoOperacionMap = new HashMap<>();
        tipoOperacionMap.put("TipoOperacion", tipoOperacionCatalog);
        catalogos.add(tipoOperacionMap);
        // Formatear las fechaOperacion
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        String fechaOperacionF = dateFormat.format(new Date());
        //Retornar Catálogos
        return new Catalogo(catalogos,fechaOperacionF, new Date().toString());
    }
    
    // Agregar un nuevo catálogo a cada tipo.
    public void addCatalog() {
    	
    	TipoPago newPago = new TipoPago(37, "Nuevo Pago de Prueba", "O");
    	TipoCuenta newCuenta = new TipoCuenta(41,"Nueva Cuenta de Prueba");
    	TipoOperacion newOperacion = new TipoOperacion(100,"Nueva Operacion de Pruebas");
    	
        tipoPagoCatalog.add(newPago);
        tipoCuentaCatalog.add(newCuenta);
        tipoOperacionCatalog.add(newOperacion);
        
        sendCatalogs();
    }
    
    // Eliminar un catálogo a cada tipo.
    public void removeCatalog() {
    	tipoPagoCatalog.removeIf(catalogo -> 
         	catalogo instanceof TipoPago && ((TipoPago) catalogo).getTipoPagoId() == 0);
    	 
        tipoCuentaCatalog.removeIf(catalogo -> 
            catalogo instanceof TipoCuenta && ((TipoCuenta) catalogo).getTipoCuentaId() == 3);
        
        tipoOperacionCatalog.removeIf(catalogo ->
    		catalogo instanceof TipoOperacion && ((TipoOperacion) catalogo).getTipoOperacionId() == 99);
        
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
        //Tipo de Operación
        tipoOperacionCatalog.add(new TipoOperacion(1, "Iniciodecallmoney"));
        tipoOperacionCatalog.add(new TipoOperacion(2, "Pagodeacumulados"));
        tipoOperacionCatalog.add(new TipoOperacion(3, "Operacionesconmesadedinero"));
        tipoOperacionCatalog.add(new TipoOperacion(4, "Otrosconceptos"));
        tipoOperacionCatalog.add(new TipoOperacion(5, "Vencimientosdecallmoney"));
        tipoOperacionCatalog.add(new TipoOperacion(6, "Compra-ventademonedaextranjera"));
        tipoOperacionCatalog.add(new TipoOperacion(7, "Coberturascambiarias"));
        tipoOperacionCatalog.add(new TipoOperacion(8, "Futurosdepesos"));
        tipoOperacionCatalog.add(new TipoOperacion(9, "Transferenciavalorplaza"));
        tipoOperacionCatalog.add(new TipoOperacion(10, "Ordenesdepagodelexteriorcorresp.aBancosdelPais"));
        tipoOperacionCatalog.add(new TipoOperacion(11, "Aportacion,amortizacionointeresesdeCreditoSindicado"));
        tipoOperacionCatalog.add(new TipoOperacion(12, "TraspasodefondosdeCuentahabientesBanxico"));
        tipoOperacionCatalog.add(new TipoOperacion(13, "CompensacionProsa"));
        tipoOperacionCatalog.add(new TipoOperacion(14, "Liquidacioncompradebilleteymonedapesos"));
        tipoOperacionCatalog.add(new TipoOperacion(15, "LiquidaciondeOALs"));
        tipoOperacionCatalog.add(new TipoOperacion(1, "Cuentainexistente"));
        tipoOperacionCatalog.add(new TipoOperacion(2, "Cuentabloqueada"));
        tipoOperacionCatalog.add(new TipoOperacion(3, "Cuentacancelada"));
        tipoOperacionCatalog.add(new TipoOperacion(5, "Cuentaenotradivisa"));
        tipoOperacionCatalog.add(new TipoOperacion(6, "Cuentanopertenecealbancoreceptor"));
        tipoOperacionCatalog.add(new TipoOperacion(13, "Beneficiarionoreconoceelpago"));
        tipoOperacionCatalog.add(new TipoOperacion(14, "Faltainformacionmandatoriaparacompletarelpago"));
        tipoOperacionCatalog.add(new TipoOperacion(15, "Tipodepagoerroneo"));
        tipoOperacionCatalog.add(new TipoOperacion(16, "Tipodeoperaciónerronea"));
        tipoOperacionCatalog.add(new TipoOperacion(17, "Tipodecuentanocorresponde"));
        tipoOperacionCatalog.add(new TipoOperacion(18, "Asolicituddelemisor"));
        tipoOperacionCatalog.add(new TipoOperacion(19, "CaracterInválido"));
        tipoOperacionCatalog.add(new TipoOperacion(20, "Excedeellímitedesaldoautorizadodelacuenta"));
        tipoOperacionCatalog.add(new TipoOperacion(21, "Excedeellímitedeabonospermitidosenelmesenlacuenta"));
        tipoOperacionCatalog.add(new TipoOperacion(22, "Númerodelíneadetelefoníamóvilnoregistrado"));
        tipoOperacionCatalog.add(new TipoOperacion(23, "CuentaadicionalnorecibepagosquenoprocedendeBanxico"));
        tipoOperacionCatalog.add(new TipoOperacion(24, "Estructuradelainformaciónadicionalincorrecta"));
        tipoOperacionCatalog.add(new TipoOperacion(25, "Faltadeinstrucciónparadispersarrecursosdeclientesporalcanzarellímitealsaldocorrespond"));
        tipoOperacionCatalog.add(new TipoOperacion(26, "ResoluciónresultantedelConveniodeColaboraciónparalaProteccióndelClienteEmisor"));
        tipoOperacionCatalog.add(new TipoOperacion(27, "PagoopcionalnoaceptadoporelParticipanteReceptor"));
        tipoOperacionCatalog.add(new TipoOperacion(28, "TipodepagoCoDisinnotificacióndeabonoentiemporeducido"));
        tipoOperacionCatalog.add(new TipoOperacion(30, "ClavederastreorepetidaporParticipanteEmisorydíadeoperación"));
        tipoOperacionCatalog.add(new TipoOperacion(31, "CertificadodelParticipanteEmisorvencido"));
        tipoOperacionCatalog.add(new TipoOperacion(1, "TraspasoSPEI-SIAC"));
        tipoOperacionCatalog.add(new TipoOperacion(2, "Caracterinválido"));
        tipoOperacionCatalog.add(new TipoOperacion(3, "TraspasoSIAC-SPEI"));
        tipoOperacionCatalog.add(new TipoOperacion(4, "TraspasoSPEI-SIACconinstrucciondetraspasoalSIDV"));
        tipoOperacionCatalog.add(new TipoOperacion(5, "TraspasodesaldoinicialSIAC-SPEIparaIFNB"));
        tipoOperacionCatalog.add(new TipoOperacion(6, "TraspasoSIAC-DALI"));
        tipoOperacionCatalog.add(new TipoOperacion(7, "TraspasoDALIyCLSalSIAC"));
        tipoOperacionCatalog.add(new TipoOperacion(8, "OperaciónAbonoSPEI"));
        tipoOperacionCatalog.add(new TipoOperacion(9, "OperaciónCargoSPEI"));
        tipoOperacionCatalog.add(new TipoOperacion(10, "InyecciondeLiquidezIntradia"));
        tipoOperacionCatalog.add(new TipoOperacion(0, "Éxito."));
        tipoOperacionCatalog.add(new TipoOperacion(1, "Error.AlmenosunaOrdendeTransferenciatienedatoserróneos."));
        tipoOperacionCatalog.add(new TipoOperacion(2, "Error.Fechadeoperaciónincorrecta."));
        tipoOperacionCatalog.add(new TipoOperacion(3, "Error.FallaenelÍndicedelParticipanteEmisor."));
        tipoOperacionCatalog.add(new TipoOperacion(4, "Error.FallaenelÍndicedelParticipanteReceptor."));
        tipoOperacionCatalog.add(new TipoOperacion(5, "Error.ParticipanteEmisoryParticipanteReceptorsoniguales."));
        tipoOperacionCatalog.add(new TipoOperacion(6, "Error.Elnúmerodefoliodelasolicitudnorespetaelordenconsecutivoascendente."));
        tipoOperacionCatalog.add(new TipoOperacion(7, "Error.FallaenelÍndicedelcertificadoutilizado."));
        tipoOperacionCatalog.add(new TipoOperacion(8, "Error.Lafirmadelmensajenoescorrecta."));
        tipoOperacionCatalog.add(new TipoOperacion(9, "Error.Prioridadinválida."));
        tipoOperacionCatalog.add(new TipoOperacion(10, "Error.Certificadodadodebaja."));
        tipoOperacionCatalog.add(new TipoOperacion(11, "Error.ElnúmerodefoliodelaOrdendeTransferencianorespetaelordenascendente."));
        tipoOperacionCatalog.add(new TipoOperacion(12, "Error.Elmontoestáfueraderango."));
        tipoOperacionCatalog.add(new TipoOperacion(13, "Error.Eltipodepagonoesválido."));
        tipoOperacionCatalog.add(new TipoOperacion(14, "Error.NoexistelaOrdendeTransferenciaquesequierecancelardentrodelasestructurasdelservidor.PosiblementeyahasidoliquidadoyelParticipantereceptoravisado."));
        tipoOperacionCatalog.add(new TipoOperacion(15, "Error.Elmontoaestableceresmayoralporcentajepermitido."));
        tipoOperacionCatalog.add(new TipoOperacion(22, "Error.ParticipanteReceptorNOreceptivo."));
        tipoOperacionCatalog.add(new TipoOperacion(24, "Error.ParticipanteReceptorNOreceptivo."));
        tipoOperacionCatalog.add(new TipoOperacion(25, "Error.Valorincorrectoenindicadorotipo."));
        tipoOperacionCatalog.add(new TipoOperacion(26, "Error.Tipodemensajeinválido."));
        tipoOperacionCatalog.add(new TipoOperacion(28, "Alestarenelprocesodesincronización(REENVIO),elclientesolicitadesdeunaposiciónmayoralaenviada."));
        tipoOperacionCatalog.add(new TipoOperacion(29, "Alestarenelprocesodesincronización(REENVIO),elclientesolicitadesdeunaposiciónquenocorrespondealiniciodeunmensaje."));
        tipoOperacionCatalog.add(new TipoOperacion(30, "Elclientenohaterminadoelprocesodesincronización(REENVIO)yenvíaunmensajediferentealesperado."));
        tipoOperacionCatalog.add(new TipoOperacion(31, "Alestarenelprocesodesincronización(REENVIO),elservidordetectaunaincongruenciaparareenviarunmensaje."));
        tipoOperacionCatalog.add(new TipoOperacion(32, "ElclientesolicitaREENVIOyelservidornodetectaqueestáenelprocesodesincronización."));
        tipoOperacionCatalog.add(new TipoOperacion(33, "Elservidorestáesperandounapartedeunmensajepartidoyelclienteenvíaotrotipodemensaje."));
        tipoOperacionCatalog.add(new TipoOperacion(34, "Error.NúmerodeórdenesdeTransferenciaobytesenlaInstrucciónmayoralpermitido."));
        tipoOperacionCatalog.add(new TipoOperacion(35, "Error.CDEdeDevoluciónincorrecto."));
        tipoOperacionCatalog.add(new TipoOperacion(36, "Elservidorrecibeunmensajecuyotipodemensajenocorrespondeaningunodelospresentadosenesteprotocolo."));
        tipoOperacionCatalog.add(new TipoOperacion(37, "Error.FallaenlaclavedeParticipanteEmisor."));
        tipoOperacionCatalog.add(new TipoOperacion(38, "Error.FallaenlaclavedelParticipanteReceptor."));
        tipoOperacionCatalog.add(new TipoOperacion(39, "Error.Operacióndemantenimientoincorrecta."));
        tipoOperacionCatalog.add(new TipoOperacion(40, "ErrorParticipanteEmisorestádadadebaja."));
        tipoOperacionCatalog.add(new TipoOperacion(41, "Error.Receptorestádadadebaja."));
        tipoOperacionCatalog.add(new TipoOperacion(42, "Error.Certificadorevocado."));
        tipoOperacionCatalog.add(new TipoOperacion(43, "Error.Certificadovencido."));
        tipoOperacionCatalog.add(new TipoOperacion(44, "Error.Certificadoconestadoincorrecto."));
        tipoOperacionCatalog.add(new TipoOperacion(45, "Error.RelaciónCertificado-Nivelexistente."));
        tipoOperacionCatalog.add(new TipoOperacion(46, "Error.RelaciónCertificado-Nivelinexistente."));
        tipoOperacionCatalog.add(new TipoOperacion(47, "Error.TamañototaldeCDEsincorrecto."));
        tipoOperacionCatalog.add(new TipoOperacion(48, "Error.CDEincorrecto."));
        tipoOperacionCatalog.add(new TipoOperacion(49, "Error.Nivelinválidodecertificado."));
        tipoOperacionCatalog.add(new TipoOperacion(50, "Error.Eníndiceparaborrarniveldecertificador."));
        tipoOperacionCatalog.add(new TipoOperacion(51, "Error.AlpedircertificadoalaARA."));
        tipoOperacionCatalog.add(new TipoOperacion(52, "Error.Aldardealtacertificado."));
        tipoOperacionCatalog.add(new TipoOperacion(53, "Error.Aldardealtanivelparacertificado."));
        tipoOperacionCatalog.add(new TipoOperacion(54, "Error.Estadosolicitadoeselactual."));
        tipoOperacionCatalog.add(new TipoOperacion(55, "Error.Alcalcularbytesparaformato,porindicadorotipoincorrecto."));
        tipoOperacionCatalog.add(new TipoOperacion(56, "Error.Entamañodeclavederastreo."));
        tipoOperacionCatalog.add(new TipoOperacion(57, "Error.NoesperabaacuseparteCaS."));
        tipoOperacionCatalog.add(new TipoOperacion(58, "Error.Entamañodenúmerodecertificador."));
        tipoOperacionCatalog.add(new TipoOperacion(60, "Error.Cuandoeltamañodelmensajeesmayoraltamañomáximopermitido."));
        tipoOperacionCatalog.add(new TipoOperacion(62, "Error.Alleerformatodeunalista,paravalidarexistenciaencatálogo."));
        tipoOperacionCatalog.add(new TipoOperacion(68, "Error.Formatoincorrectodelmensaje."));
        tipoOperacionCatalog.add(new TipoOperacion(69, "Error.Tamañodefirma."));
        tipoOperacionCatalog.add(new TipoOperacion(74, "Error.Tamañoincorrectodelainformaciónadicional."));
        tipoOperacionCatalog.add(new TipoOperacion(75, "Error.ConexiónconSIACnoestablecida."));
        tipoOperacionCatalog.add(new TipoOperacion(76, "Error.ParticipantenocatalogadoenSIAC."));
        tipoOperacionCatalog.add(new TipoOperacion(98, "Error.Horariodeoperaciónconcluido,enesperadeliquidaciónfinal."));
        tipoOperacionCatalog.add(new TipoOperacion(99, "Error.Tipodepagofueradehorario."));

       
   }
    
}
