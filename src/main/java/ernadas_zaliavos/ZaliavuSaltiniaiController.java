package ernadas_zaliavos;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// import ernadas_zaliavos.Zaliavos;

@Controller
public class ZaliavuSaltiniaiController {
	
	@Autowired
	private ZaliavuSaltiniaiRepository zaliavu_saltiniai_repository;		

	@RequestMapping(path="/saltiniai", method={ RequestMethod.GET, RequestMethod.POST })
	public String saltiniai(
			// id	id_zaliavos	pav	platuma_centrines_dalies	ilguma_centrines_dalies	kiekis_zaliavos_vertinamas
			@RequestParam(name="id", required=false, defaultValue="0") String id
			, @RequestParam(name="id_zaliavos", required=false, defaultValue="0") String id_zaliavos
			, @RequestParam(name="pav", required=false, defaultValue="-") String pav
			
			, @RequestParam(name="platuma_centrines_dalies", required=false, defaultValue="0") String platuma_centrines_dalies
			, @RequestParam(name="ilguma_centrines_dalies", required=false, defaultValue="") String ilguma_centrines_dalies	
			, @RequestParam(name="kiekis_zaliavos_vertinamas", required=false, defaultValue="2") String kiekis_zaliavos_vertinamas
			
			, @RequestParam(name="saugoti", required=false, defaultValue="nesaugoti") String saugoti
			, Model model
			) {
		
		if ( ( saugoti != null ) && saugoti.equals ("saugoti") ) {
			
			ZaliavuSaltiniai zaliavu_saltinis = new ZaliavuSaltiniai (
					id
					, id_zaliavos
					, pav						
					, platuma_centrines_dalies
					, ilguma_centrines_dalies
					, kiekis_zaliavos_vertinamas
			);
			
			System.out.println ( zaliavu_saltinis.toString() );			
			
			if ( zaliavu_saltinis.getErrors().size() > 0) {
			

				model.addAttribute("errors", zaliavu_saltinis.getErrors() );
				
			} else {
				
				zaliavu_saltiniai_repository.save( zaliavu_saltinis );
			}
		}
		
		model.addAttribute("zaliavu_saltiniai", zaliavu_saltiniai_repository.findAll() );
		
		return "zaliavu_saltiniai";
	}	
}
