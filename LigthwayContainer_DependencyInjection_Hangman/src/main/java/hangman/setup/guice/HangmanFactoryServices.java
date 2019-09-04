/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hangman.setup.guice;

/**
 *
 * @author 2106913
 */
import hangman.model.Spanish;
import hangman.model.French;
import hangman.model.GameScore;
import hangman.model.Language;
import hangman.model.OriginalScore;
import hangman.model.BonusScore;
import hangman.model.PowerScore;
import hangman.model.dictionary.*;
import hangman.model.dictionary.FrenchDictionaryDataSource;
import hangman.view.HangmanColoridoPanel;
import hangman.view.HangmanNoviolentoPanel;
import hangman.view.HangmanPanel;
import hangman.setup.factoryMethod.*;

public class HangmanFactoryServices extends com.google.inject.AbstractModule {

    @Override
    protected void configure() {
        /* Guice dependency injection */
        // bind(Interface.class).to(Concrete.class);
    	bind(GameScore.class).to(PowerScore.class);
    	bind(Language.class).to(Spanish.class);
    	bind(HangmanDictionary.class).to(SpanishDictionaryDataSource.class);
        bind(HangmanFactoryMethod.class).to(HangmanDefaultFactoryMethod.class);
        bind(HangmanPanel.class).to(HangmanColoridoPanel.class);
    }

}
