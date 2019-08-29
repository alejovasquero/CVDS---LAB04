package hangman.model;


public class PowerScore implements GameScore{
	/**
	 * @pre Las cuentas de palabras correctas e incorrectas son mayores o iguales a 0. Se inicia con 0 puntos
	 * @pos El puntaje es (+i| 0<=i<=correctCount : 5^i) menos 8 veces el número de letras incorrectas. El puntaje mínimo es 0 y el máximo es 500.
	 * @param correctCount Número de letras correctas de la palabra
	 * @param incorrectCount Número de letras incorrectas de la palabra
	 * @throws GameScoreExcepcion Si cualquiera de los dos números es negativo
	**/
	public int calculateScore(int correctCount, int incorrectCount) throws GameScoreExcepcion{
		if(correctCount<0 || incorrectCount <0){
			throw new GameScoreExcepcion(GameScoreExcepcion.INVALID);
		}
		int score = 0;
		int count = 0;
		for(int i=0;i<correctCount;i++){
			count += Math.pow(5,(i+1));
		}
		if(score+count-(8*incorrectCount)<0){score=0;}
		else if(score+count-(8*incorrectCount)>500){score=500;}
		else{
			score = count-(8*incorrectCount);
		}
		return score;
	}
}