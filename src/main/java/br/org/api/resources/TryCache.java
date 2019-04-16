package br.org.api.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.org.api.service.ExemploCacheService;

@EnableCaching
@RestController
@RequestMapping(value = "/api/v1/cache")
public class TryCache {

	@Autowired
	ExemploCacheService service;
	
	@GetMapping()
    public String cache() {
		return service.exemploCache();
		
	}
	
	
}
