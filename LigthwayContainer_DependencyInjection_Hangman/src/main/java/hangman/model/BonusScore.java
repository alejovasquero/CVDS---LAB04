package hangman.model;

public class BonusScore implements GameScore{
	/**
	 * @pre Las cuentas de palabras correctas e incorrectas son mayores o iguales a 0. Se inicia con 0 puntos
	 * @pos El puntaje es 10 veces el número de letras correctas menos 5 veces el número de letras incorrectas. El puntaje mínimo es 0.
	 * @param correctCount Número de letras correctas de la palabra
	 * @param incorrectCount Número de letras incorrectas de la palabra
	 * @throws GameScoreExcepcion Si cualquiera de los dos números es negativo
	**/
	public int calculateScore(int correctCount, int incorrectCount) throws GameScoreExcepcion{
		if(correctCount<0 || incorrectCount <0){
			throw new GameScoreExcepcion(GameScoreExcepcion.INVALID);
		}
		int score = 0;
		if(score+(10*correctCount)-(5*incorrectCount)<0){score=0;}
		else{
			score = (10*correctCount)-(5*incorrectCount);
		}
		return score;
	}
}