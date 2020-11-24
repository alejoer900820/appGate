package co.com.appgate.util;

/**
 * @author Alejandro Echeverri Restrepo
 *
 */
public enum EnumMessages {
	
	OK("Respuesta correcta"),
	ERROR("Respuesta incorrecta"),
	OPTIONAL_EMPTY("Optional.empty")
	;
	
	private String name;

	private EnumMessages(String namme) {
		this.name = namme;
	}

	public String getName() {
		return name;
	}
	
}
