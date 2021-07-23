package ernadas_zaliavos;

import java.util.ArrayList;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

@Entity
public class ZaliavuSaltiniai {
	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;		
    
	public Integer id_zaliavos;
	public String  pav;	
	public Double platuma_centrines_dalies;	
	public Double ilguma_centrines_dalies;
	public Double kiekis_zaliavos_vertinamas;
	
	@ManyToOne
	@JoinColumn(name = "id_zaliavos", insertable=false, updatable=false)
	private Zaliavos zaliavos;
	
	@Transient
	private ArrayList<String> errors;	
	
	public ZaliavuSaltiniai() {
		super();
	}	
	
	public ZaliavuSaltiniai(Integer id, Integer id_zaliavos, String pav, Double platuma_centrines_dalies,
			Double ilguma_centrines_dalies, Double kiekis_zaliavos_vertinamas) {
		super();
		this.id = id;
		this.id_zaliavos = id_zaliavos;
		this.pav = pav;
		this.platuma_centrines_dalies = platuma_centrines_dalies;
		this.ilguma_centrines_dalies = ilguma_centrines_dalies;
		this.kiekis_zaliavos_vertinamas = kiekis_zaliavos_vertinamas;
	}	

	public ZaliavuSaltiniai(String id, String id_zaliavos, String pav, String platuma_centrines_dalies,
			String ilguma_centrines_dalies, String kiekis_zaliavos_vertinamas) {
		super();
		this.errors = new ArrayList<String>();
		
		try {
				this.id = null;
			
				if ( id != null ) {
		
					this.id = Integer.parseInt ( id );
					
					if ( this.id == 0 ) {
						
						this.id = null;
					}
				}
				
				this.id_zaliavos = Integer.parseInt(id_zaliavos);
				this.platuma_centrines_dalies = Double.parseDouble(platuma_centrines_dalies);
				this.ilguma_centrines_dalies = Double.parseDouble(ilguma_centrines_dalies);
				this.kiekis_zaliavos_vertinamas = Double.parseDouble(kiekis_zaliavos_vertinamas);
		
		} catch ( Exception e ) {
			
			this.errors.add( e.getMessage() );
		}
	
		this.pav = pav;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_zaliavos() {
		return id_zaliavos;
	}

	public void setId_zaliavos(Integer id_zaliavos) {
		this.id_zaliavos = id_zaliavos;
	}

	public String getPav() {
		return pav;
	}

	public void setPav(String pav) {
		this.pav = pav;
	}

	public Double getPlatuma_centrines_dalies() {
		return platuma_centrines_dalies;
	}

	public void setPlatuma_centrines_dalies(Double platuma_centrines_dalies) {
		this.platuma_centrines_dalies = platuma_centrines_dalies;
	}

	public Double getIlguma_centrines_dalies() {
		return ilguma_centrines_dalies;
	}

	public void setIlguma_centrines_dalies(Double ilguma_centrines_dalies) {
		this.ilguma_centrines_dalies = ilguma_centrines_dalies;
	}

	public Double getKiekis_zaliavos_vertinamas() {
		return kiekis_zaliavos_vertinamas;
	}

	public void setKiekis_zaliavos_vertinamas(Double kiekis_zaliavos_vertinamas) {
		this.kiekis_zaliavos_vertinamas = kiekis_zaliavos_vertinamas;
	}

	public ArrayList<String> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}
	
	public Zaliavos getZaliavos() {
		return zaliavos;
	}

	public void setZaliavos(Zaliavos zaliava) {
		this.zaliavos = zaliava;
	}

	@Override
	public String toString() {
		return "ZaliavuSaltiniai [id=" + id + ", id_zaliavos=" + id_zaliavos + ", pav=" + pav
				+ ", platuma_centrines_dalies=" + platuma_centrines_dalies + ", ilguma_centrines_dalies="
				+ ilguma_centrines_dalies + ", kiekis_zaliavos_vertinamas=" + kiekis_zaliavos_vertinamas + ", errors="
				+ errors + "]";
	}
}
