package com.example.CatalogoBackend.Controller;
import com.example.CatalogoBackend.Service.CatalogoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/catalogs")
public class CatalogoController {
	 @Autowired
	 private CatalogoService catalogoService;
	 
 
	 @GetMapping("/send")
	 public ResponseEntity<String> sendCatalogsAutomatically() {
		 try {
	            catalogoService.sendCatalogs();
	            return ResponseEntity.status(HttpStatus.OK).body("Catálogos enviados a RabbitMQ correctamente.");
	     } catch (Exception e) {
	    	 return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                 .body("Ocurrió un error al enviar los catálogos: " + e.getMessage());
	     }
	 } 
	 
	 @GetMapping("/add")
	 public ResponseEntity<String> addCatalogAutomatically() {
		 try {
			 catalogoService.addCatalog();
	         return ResponseEntity.status(HttpStatus.OK).body("Catálogo nuevo añadido y enviado correctamente.");
	     } catch (Exception e) {
	         return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                .body("Ocurrió un error al añadir el catálogo: " + e.getMessage());
	     }
	 }
	 
	 @GetMapping("/remove")
	 public ResponseEntity<String> removeCatalogAutomatically() {
		 try {
	            catalogoService.removeCatalog();
	            return ResponseEntity.status(HttpStatus.OK).body("Catálogo eliminado y lista actualizada.");
	     } catch (Exception e) {
	            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
	                    .body("Ocurrió un error al eliminar el catálogo: " + e.getMessage());
	     }
	 }
	 
	
	 
	
}
