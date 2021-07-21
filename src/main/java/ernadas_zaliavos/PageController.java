package ernadas_zaliavos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import saltiniai.BlaBlaMessenger;

@Controller
public class PageController {
	
	@Autowired
	private ZaliavosRepository zaliavos_repository;		
	
	@RequestMapping(path="/zaliavos", method={ RequestMethod.GET, RequestMethod.POST })
	public String zaliavos(
			// id	pav	flag_skirtas_galutiniam_vartojimui	vnt_mato	kiekis	kaina_uz_kiekio_vnt	aprasymas	
			@RequestParam(name="id", required=false, defaultValue="0") String id
			, @RequestParam(name="pav", required=false, defaultValue="-") String pav
			
			, @RequestParam(name="flag_skirtas_galutiniam_vartojimui", required=false, defaultValue="0") String flag_skirtas_galutiniam_vartojimui
			, @RequestParam(name="vnt_mato", required=false, defaultValue="") String vnt_mato	
			, @RequestParam(name="kiekis", required=false, defaultValue="2") String kiekis
			, @RequestParam(name="kaina_uz_kiekio_vnt", required=false, defaultValue="4") String kaina_uz_kiekio_vnt
			, @RequestParam(name="aprasymas", required=false, defaultValue="4") String aprasymas
			
			, @RequestParam(name="saugoti", required=false, defaultValue="nesaugoti") String saugoti
			, Model model
			) {
		
		if ( ( saugoti != null ) && saugoti.equals ("saugoti") ) {
			
			Zaliavos zaliava = new Zaliavos (
					id
					, pav	
					, flag_skirtas_galutiniam_vartojimui
					, vnt_mato
					, kiekis
					, kaina_uz_kiekio_vnt
					, aprasymas	

			);

			zaliavos_repository.save( zaliava );
		}
		model.addAttribute("zaliavos", zaliavos_repository.findAll() );
		
		return "zaliavos";
	}
	
	@RequestMapping(path="/zaliava", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody Zaliavos zaliava(@RequestParam(name="id", required=true, defaultValue="0") Integer id, Model model) {
		
		Zaliavos zaliava = new Zaliavos();
		
		if ( id > 0 ) {
			
			zaliava = zaliavos_repository.findById( id ).get();
		}
		
		BlaBlaMessenger bla_bla_messenger = new BlaBlaMessenger();
		System.out.println( bla_bla_messenger.sayBlabla() );
		
		return zaliava;
	}
	
	@RequestMapping(path="/salinti-zaliava", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String salintiZaliava(@RequestParam(name="id", required=true, defaultValue="0") Integer id, Model model) {
		
		String res = "0";
		
		if ( id > 0 ) {
			
			zaliavos_repository. deleteById(id);
			
			if ( ! zaliavos_repository.existsById( id ) ) {
			
				res = "1";
			}			
		}
		
		return res;
	}	

}
