package entity;

	import java.io.Serializable;
	import javax.xml.bind.annotation.XmlRootElement;

	@XmlRootElement
	public class Persona implements Serializable {

		private static final long serialVersionUID = 1L;

	    private int idPersona;

	    private String nombrePersona;

	    private String apellidoPersona;

	    private String rutPersona;

	    public Persona() {
	    }

	    public Persona(int idPersona) {
	        this.idPersona = idPersona;
	    }
	    
	    public Integer getIdPersona() {
			return idPersona;
		}

		public void setIdPersona(Integer idPersona) {
			this.idPersona = idPersona;
		}

		public String getNombrePersona() {
			return nombrePersona;
		}

		public void setNombrePersona(String nombrePersona) {
			this.nombrePersona = nombrePersona;
		}

		public String getApellidoPersona() {
			return apellidoPersona;
		}

		public void setApellidoPersona(String apellidoPersona) {
			this.apellidoPersona = apellidoPersona;
		}

		public String getRutPersona() {
			return rutPersona;
		}

		public void setRutPersona(String rutPersona) {
			this.rutPersona = rutPersona;
		}

		@Override
	    public String toString() {
	        return "Persona [idPersona=" + idPersona + ", nombrePersona=" + nombrePersona
	                + ", apellidoPersona=" + apellidoPersona + ", rutPersona=" + rutPersona + "]";
	    }
	}
