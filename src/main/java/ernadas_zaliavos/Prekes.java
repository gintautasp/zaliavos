package ernadas_zaliavos;

import java.util.ArrayList;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;


@Entity
public class Prekes {;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	
	private String pav;
	private String tipas;
	private String kaina;
	private String laikas_galiojimo;
	
	@Transient
	private ArrayList errors;
	
	public Prekes() {
		super();
	}
	public Prekes(
		Integer id, 
		String pav,
		String tipas,
		String kaina,
		String laikas_galiojimo
	
	) {
		super();
		id = id;
		this.pav = pav;
		this.tipas = tipas;
		this.kaina = kaina;
		this.laikas_galiojimo = laikas_galiojimo;
	}
	public Prekes(
		String  id,
		String pav,
		String tipas,
		String kaina,
		String laikas_galiojimo
	
	) {
		super();
	
		this.errors = new ArrayList();
	
		try {
			this.id = null;
	
			if ( id != null ) {
	
				this.id = Integer.parseInt ( id );
	
				if ( this.id == 0 ) {
	
					this.id = null;
				}
			}
					// persikelti parsinamus laukus
	
	
		} catch ( Exception e ) {
	
			this.errors.add( e.getMessage() );
		}
		this.pav = pav;
		this.tipas = tipas;
		this.kaina = kaina;
		this.laikas_galiojimo = laikas_galiojimo;
	
	}

}