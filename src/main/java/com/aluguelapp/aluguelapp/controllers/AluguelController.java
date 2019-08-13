package com.aluguelapp.aluguelapp.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

//import org.springframework.web.bind.annotation.RestController;
import com.aluguelapp.aluguelapp.models.Aluguel;
import com.aluguelapp.aluguelapp.repository.AluguelRepository;

@Controller
public class AluguelController {
	
	@Autowired
	private AluguelRepository er;
	
	@RequestMapping(value="/cadastrarAluguel", method=RequestMethod.GET)
	public String form() {
		return "aluguel/formAluguel";
	}
	
	@RequestMapping(value="/cadastrarAluguel", method=RequestMethod.POST)
	public String form(Aluguel aluguel) {
		
		er.save(aluguel);
		
		return "redirect:/cadastrarAluguel";
	}	
	
	
	@RequestMapping(value="/alugueis", method=RequestMethod.GET, produces=MediaType.APPLICATION_JSON_VALUE)
	public @ResponseBody Iterable<Aluguel>listaAlugueis(){
		Iterable<Aluguel> alugueis = er.findAll();
		return alugueis;
	}
	
	/*@RequestMapping(value="/{codigo}", method=RequestMethod.GET)
	public ModelAndView detalhesEvento(@PathVariable("codigo") long codigo){
		Aluguel aluguel = er.findByCodigo(codigo);
		return aluguel;
		
	}*/
	
	@RequestMapping(value="/{codigo}", method=RequestMethod.DELETE)
	public String deletarAluguel(@PathVariable("codigo")long codigo){
		Aluguel aluguel = er.findByCodigo(codigo);
		er.delete(aluguel);
		return "redirect:/alugueis";
	}
	

}	
	
	
	
	
	
/*	@RequestMapping(produces="alugueis/json")
	//@GetMapping(produces="/json")
	public ModelAndView listaALugueis(){
		ModelAndView mv = new ModelAndView("index");
		Iterable<Aluguel> alugueis = er.findAll();
		mv.addObject("alugueis", alugueis);
		return mv;
	}*/
	


/*@RestController
@RequestMapping("/alugueis")
public class AluguelController {
	
	@Autowired
	private AluguelRepository er;
	
	@GetMapping(produces="application/json")
	public @ResponseBody Iterable<Aluguel>listaAlugueis(){
		Iterable<Aluguel> alugueis = er.findAll();
		return alugueis;
	}


}*/
