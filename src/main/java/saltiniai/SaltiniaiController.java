package saltiniai;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

// import ernadas_zaliavos.Zaliavos;

@Controller
public class SaltiniaiController {

	@RequestMapping(path="/salt", method={ RequestMethod.GET, RequestMethod.POST })
	public @ResponseBody String salt(@RequestParam(name="id", required=true, defaultValue="0") Integer id, Model model) {
		
		return "bla bla";
	}	
}
