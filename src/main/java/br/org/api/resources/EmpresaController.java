package br.org.api.resources;

import java.io.Serializable;
import java.util.List;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.api.responses.Response;
import br.org.api.service.EmpresaService;
import br.org.model.Empresa;
import br.org.model.EmpresaDto;

@RequestMapping(value = "api/v1/empresa")
@RestController
public class EmpresaController implements Serializable{

	private static final long serialVersionUID = 4048738025429860056L;
	
	private final Logger logger = LoggerFactory.getLogger(EmpresaController.class);
	
	@Autowired
	private EmpresaService service;

	/**
	 * GET  /all : get all empressa from database.
	 * 
	 * @return 200 - OK and List<Empresa> empresa
	 */
	@GetMapping("/all")
	public List<Empresa> lista() {
		logger.debug("REST request to get all Empresa");
		return service.findAllEmpresa();
	}
	
	/**
	 * POST  / : register empresa.
	 * 
	 * body: 
	 *  {
	 * 		    "razaoSocial" : value
	 * 			"cnpj": value	
	 * 			"dataCriacao": value			
	 *  }
	 * 
	 * @param empresa - Empresa object
	 * 
	 * @return 200 - OK and Empresa created
	 */
	@PostMapping
	public ResponseEntity<Response<EmpresaDto>> create(@Valid @RequestBody EmpresaDto empresaDto, BindingResult result) {
		logger.debug("REST request to save Tool : {}", empresaDto);

		Response<EmpresaDto> response = new Response<EmpresaDto>();
		
		if (result.hasErrors()) {
			result.getAllErrors().forEach(error -> response.getErrors().add(error.getDefaultMessage()));
			return ResponseEntity.badRequest().body(response);
		}
		
		
		response.setData(empresaDto);
		service.save(empresaDto);
		
		return ResponseEntity.ok(response);
				
	}	

}
