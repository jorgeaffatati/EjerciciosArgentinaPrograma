package Mundial_Qatar;

public enum ResultadoEnum {
    EMPATE(0), PIERDE(1), GANA(2);
	final int nro;
	ResultadoEnum(int nro){
		this.nro = nro;
	}
}