package com.example.CatalogoBackend.Service;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.example.CatalogoBackend.Config.RabbitMQConfig;

@Service
public class RabbitMQSender {
	
	@Autowired
    private RabbitTemplate rabbitTemplate;

    // Método para enviar el CatalogoTipoPago a RabbitMQ    
    public void sendCatalogs(String catalogJson) {
    	 try {
    		 rabbitTemplate.convertAndSend(RabbitMQConfig.CATALOG_EXCHANGE, "catalog.clave", catalogJson);
    		 System.out.println("Mensaje enviado al Exchange en RabbitMQ: " + catalogJson); 
         } catch (Exception e) {
             System.err.println("Error al convertir el catálogo a JSON: " + e.getMessage());
         }
    }

}
