
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
public class GaminiaiZaliavos {

	
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer id;	
    
    private Integer id_gaminio;
    private Integer id_zaliavos;	
    private Double kiekis_zaliavos;
    private Double kiekis_gaminiu;
    
    @ManyToOne
    @JoinColumn(name="id_gaminio", insertable=false, updatable=false)
    private Gaminiai gaminiai;
    
    
	@Transient
	private ArrayList<String> errors;    
    
	public GaminiaiZaliavos() {
		super();
	}    
    
	public GaminiaiZaliavos(Integer id, Integer id_gaminiai, Integer id_zaliavos, Double kiekis_zaliavos,
			Double kiekis_gaminiu) {
		super();
		this.id = id;
		this.id_gaminio = id_gaminiai;
		this.id_zaliavos = id_zaliavos;
		this.kiekis_zaliavos = kiekis_zaliavos;
		this.kiekis_gaminiu = kiekis_gaminiu;
	}
	
	public GaminiaiZaliavos(String id, String id_gaminio, String id_zaliavos, String kiekis_zaliavos,
			String kiekis_gaminiu) {
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
				this.id_gaminio = Integer.parseInt( id_gaminio );
				this.id_zaliavos = Integer.parseInt( id_zaliavos );				
				this.kiekis_zaliavos = Double.parseDouble( kiekis_zaliavos );		
				this.kiekis_gaminiu = Double.parseDouble( kiekis_gaminiu );
		
		} catch ( Exception e ) {
			
			this.errors.add( e.getMessage() );
		}
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getId_gaminio() {
		return id_gaminio;
	}

	public void setId_gaminio(Integer id_gaminio) {
		this.id_gaminio = id_gaminio;
	}

	public Integer getId_zaliavos() {
		return id_zaliavos;
	}

	public void setId_zaliavos(Integer id_zaliavos) {
		this.id_zaliavos = id_zaliavos;
	}

	public Double getKiekis_zaliavos() {
		return kiekis_zaliavos;
	}

	public void setKiekis_zaliavos(Double kiekis_zaliavos) {
		this.kiekis_zaliavos = kiekis_zaliavos;
	}

	public Double getKiekis_gaminiu() {
		return kiekis_gaminiu;
	}

	public void setKiekis_gaminiu(Double kiekis_gaminiu) {
		this.kiekis_gaminiu = kiekis_gaminiu;
	}

	public ArrayList<String> getErrors() {
		return errors;
	}

	public void setErrors(ArrayList<String> errors) {
		this.errors = errors;
	}

	
	
	public Gaminiai getGaminiai() {
		return gaminiai;
	}

	public void setGaminiai(Gaminiai gaminiai) {
		this.gaminiai = gaminiai;
	}

	@Override
	public String toString() {
		return "GaminiaiZaliavos [id=" + id + ", id_gaminio=" + id_gaminio + ", id_zaliavos=" + id_zaliavos
				+ ", kiekis_zaliavos=" + kiekis_zaliavos + ", kiekis_gaminiu=" + kiekis_gaminiu + ", errors=" + errors
				+ "]";
	}	
    
    

}
