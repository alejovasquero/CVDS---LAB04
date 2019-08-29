
package hangman;

import org.junit.Assert;
import org.junit.Test;
/**
 * Vamos a definir 4 clases de equivalencia:
 * 1) Excepción cada vez que se manden parámetros negativos para cada una de las 3 clases de calculo:
 *    Frontera: ...(-1,-1) (-1, 0) (0,-1)
 * 2) OriginalScore:
 *    2.1 Se inicia con 100 puntos y no hay letras correctas ni incorrectas (0,0)
 *    2.2 Saca el puntaje mínimo (0,10)(0,11)...
 *	  2.3 Saca un puntaje entre 0 y 100 (1,0)...(0,9)
 * 3) BonusScore:
 *    2.1 Se inicia con 0 puntos y no hay letras correctas ni incorrectas (0,0)
 *    2.2 Saca el puntaje mínimo (0,0)(0,1)...
 *	  2.3 Saca un puntaje entre 0 y 100 (1,1)...(10,1)
 * 4) PowerScore:
 *    2.1 Se inicia con 0 puntos y no hay letras correctas ni incorrectas (0,0)
 *    2.2 Saca el puntaje mínimo (0,0)(0,1)...
 *	  2.3 Saca un puntaje entre 0 y 100 (2,3)(3,7)...
 *    2.4 Seca el puntaje maximo (4,0)... 
 */
public class GameScoreTest{

	@test
	public void deberiaDarExcepcion(){
		GameScore a;
		try{
			a = new OriginalScore();
			a.calculateScore(-1,-1)
		} catch(GameScoreExcepcion e){
			Assert.assertTrue(true)
		}
		try{
			a = new BonusScore();
			a.calculateScore(-1,0)
		} catch(GameScoreExcepcion e){
			Assert.assertTrue(true)
		}
		try{
			a = new PowerScore();
			a.calculateScore(0,-1)
		} catch(GameScoreExcepcion e){
			Assert.assertTrue(true)
		}
	}
	@test
	public void deberiaSerPuntajeMinimo(){
		GameScore a;
		a = new OriginalScore();
		Assert.assertEquals(a.calculateScore(0,11),0);
		Assert.assertEquals(a.calculateScore(0,10),0);
		
		a = new BonusScore();
		Assert.assertEquals(a.calculateScore(0,0),0);
		Assert.assertEquals(a.calculateScore(0,1),0);
		
		a = new PowerScore();
		Assert.assertEquals(a.calculateScore(0,1),0);
		Assert.assertEquals(a.calculateScore(0,1),0);
	}
	
	
	
	
	
	
	
	@test
	public void originalScoreDeberiaDarInicio(){
		GameScore a;
		a = new OriginalScore();
		Assert.assertEquals(a.calculateScore(0,0),100);
	}
	
	@test 
	public void originalDeberiaCalcularBien(){
		GameScore a;
		a = new OriginalScore();
		int b = a.calculateScore(1,0);
		Assert.assertTrue(b==100);
		
		b = a.calculateScore(0,9);
		Assert.assertTrue(b==10);
		
	}
	
	
	
	
	@test
	public void bonusScoreDeberiaDarInicio(){
		GameScore a;
		a = new BonusScore();
		Assert.assertEquals(a.calculateScore(0,0),0);
	}
	
	@test 
	public void bonusDeberiaCalcularBien(){
		GameScore a;
		a = new OriginalScore();
		int b = a.calculateScore(1,1);
		Assert.assertTrue(b==5);
		
		b = a.calculateScore(10,1);
		Assert.assertTrue(b==95);
		
		b = a.calculateScore(6,2);
		Assert.assertTrue(b==95);
	}
	
	
	
	
	@test
	public void powerScoreDeberiaDarInicio(){
		GameScore a;
		a = new PowerScore();
		Assert.assertEquals(a.calculateScore(0,0),0);
	}
	
	@test 
	public void powerDeberiaCalcularBien(){
		GameScore a;
		a = new OriginalScore();
		int b = a.calculateScore(2,3);
		Assert.assertTrue(b==6);
		
		b = a.calculateScore(3,7);
		Assert.assertTrue(b==99);
		
		b = a.calculateScore(1,0);
		Assert.assertTrue(b==5);
	}
	
	@test 
	public void powerDeberiaDarMaximo(){
		GameScore a;
		a = new OriginalScore();
		int b = a.calculateScore(4,0);
		Assert.assertTrue(b==500);
		
	}
	
}