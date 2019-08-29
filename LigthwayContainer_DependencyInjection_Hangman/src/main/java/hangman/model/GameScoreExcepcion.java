package hangman.model;

public class GameScoreExcepcion extends Exception{

	public static final String INVALID = "Parametros Incorrectos";

	public GameScoreExcepcion(String message){
		super(message);
	}
}