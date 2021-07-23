package ernadas_zaliavos;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Transient;

// id pav flag_skirtas_galutiniam_vartojimui vnt_mato kiekis kaina_uz_kiekio_vnt
@Entity
public class Gaminiai {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;	
    
    private String pav;	
    private Integer flag_skirtas_galutiniam_vartojimui;
    private String vnt_mato;
    private Double kiekis;	
    private Double kaina_uz_kiekio_vnt;
    
	@Transient
	private ArrayList<String> errors;    
    
	public Gaminiai() {
		// super();    
	}
    
	public Gaminiai(Integer id, String pav, Integer flag_skirtas_galutiniam_vartojimui, String vnt_mato, Double kiekis,
			Double kaina_uz_kiekio_vnt) {
		// super();
		id = id;
		this.pav = pav;
		this.flag_skirtas_galutiniam_vartojimui = flag_skirtas_galutiniam_vartojimui;
		this.vnt_mato = vnt_mato;
		this.kiekis = kiekis;
		this.kaina_uz_kiekio_vnt = kaina_uz_kiekio_vnt;
	}
    
	public Gaminiai(String id, String pav, String flag_skirtas_galutiniam_vartojimui, String vnt_mato, String kiekis,
			String kaina_uz_kiekio_vnt) {
		// super();
		this.errors = new ArrayList<String>();
		
		try {
				this.id = null;
			
				if ( id != null ) {
		
					this.id = Integer.parseInt ( id );
					
					if ( this.id == 0 ) {
						
						this.id = null;
					}
				}
				this.flag_skirtas_galutiniam_vartojimui = Integer.parseInt ( flag_skirtas_galutiniam_vartojimui );;
				this.kiekis = Double.parseDouble( kiekis );		
				this.kaina_uz_kiekio_vnt = Double.parseDouble ( kaina_uz_kiekio_vnt );
		
		} catch ( Exception e ) {
			
			this.errors.add( e.getMessage() );
		}
		this.pav = pav;
		this.vnt_mato = vnt_mato;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}

	public Integer getFlag_skirtas_galutiniam_vartojimui() {
		return flag_skirtas_galutiniam_vartojimui;
	}

	public void setFlag_skirtas_galutiniam_vartojimui(Integer flag_skirtas_galutiniam_vartojimui) {
		this.flag_skirtas_galutiniam_vartojimui = flag_skirtas_galutiniam_vartojimui;
	}

	public String getVnt_mato() {
		return vnt_mato;
	}

	public void setVnt_mato(String vnt_mato) {
		this.vnt_mato = vnt_mato;
	}

	public Double getKiekis() {
		return kiekis;
	}

	public void setKiekis(Double kiekis) {
		this.kiekis = kiekis;
	}

	public Double getKaina_uz_kiekio_vnt() {
		return kaina_uz_kiekio_vnt;
	}

	public void setKaina_uz_kiekio_vnt(Double kaina_uz_kiekio_vnt) {
		this.kaina_uz_kiekio_vnt = kaina_uz_kiekio_vnt;
	}

	public ArrayList<String> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}	

}
