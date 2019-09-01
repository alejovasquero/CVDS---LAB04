package hangman;


import org.junit.Assert;
import org.junit.Test;

import hangman.model.*;

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

	@Test
	public void deberiaDarExcepcion(){
		GameScore a;
		try{
			a = new OriginalScore();
			a.calculateScore(-1,-1);
		} catch(GameScoreExcepcion e){
			Assert.assertTrue(true);
		}
		try{
			a = new BonusScore();
			a.calculateScore(-1,0);
		} catch(GameScoreExcepcion e){
			Assert.assertTrue(true);
		}
		try{
			a = new PowerScore();
			a.calculateScore(0,-1);
		} catch(GameScoreExcepcion e){
			Assert.assertTrue(true);
		}
	}
	@Test
	public void deberiaSerPuntajeMinimo() throws GameScoreExcepcion{
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
	
	
	
	
	
	
	
	@Test
	public void originalScoreDeberiaDarInicio()  throws GameScoreExcepcion{
		GameScore a;
		a = new OriginalScore();
		Assert.assertEquals(a.calculateScore(0,0),100);
	}
	
	@Test 
	public void originalDeberiaCalcularBien()  throws GameScoreExcepcion{
		GameScore a;
		a = new OriginalScore();
		int b = a.calculateScore(1,0);
		Assert.assertTrue(b==100);
		
		b = a.calculateScore(0,9);
		Assert.assertTrue(b==10);
		
	}
	
	
	
	
	@Test
	public void bonusScoreDeberiaDarInicio()  throws GameScoreExcepcion{
		GameScore a;
		a = new BonusScore();
		Assert.assertEquals(a.calculateScore(0,0),0);
	}
	
	@Test 
	public void bonusDeberiaCalcularBien()  throws GameScoreExcepcion{
		GameScore a;
		a = new BonusScore();
		int b = a.calculateScore(1,1);
		Assert.assertTrue(b==5);
		
		b = a.calculateScore(10,1);
		Assert.assertTrue(b==95);
		
		b = a.calculateScore(6,2);
		Assert.assertTrue(b==50);
	}
	
	
	
	
	@Test
	public void powerScoreDeberiaDarInicio()  throws GameScoreExcepcion{
		GameScore a;
		a = new PowerScore();
		Assert.assertEquals(a.calculateScore(0,0),0);
	}
	
	@Test 
	public void powerDeberiaCalcularBien()  throws GameScoreExcepcion{
		GameScore a;
		a = new PowerScore();
		int b = a.calculateScore(2,3);
		Assert.assertTrue(b==6);
		
		b = a.calculateScore(3,7);
		Assert.assertTrue(b==99);
		
		b = a.calculateScore(1,0);
		Assert.assertTrue(b==5);
	}
	
	@Test 
	public void powerDeberiaDarMaximo()  throws GameScoreExcepcion{
		GameScore a;
		a = new PowerScore();
		int b = a.calculateScore(4,0);
		Assert.assertTrue(b==500);
		
	}
	
}