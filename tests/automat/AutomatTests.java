package automat;

import exceptions.StatusException;
import exceptions.SymbolException;
import org.junit.Assert;
import org.junit.Test;

public class AutomatTests {

    @Test
    public void goodChangeStatusTest() throws StatusException, SymbolException {

        Automat automat = new AutomatImpl();

        automat.readSymbol("B");

        automat.readSymbol("C");


    }
    @Test
    public void goodReachedFinalStatus() throws StatusException, SymbolException {

        Automat automat = new AutomatImpl();

        automat.readSymbol("B");

        automat.readSymbol("Z");

        Assert.assertTrue(automat.checkIfFinalStatusWasReached());

        Assert.assertEquals("BZ", automat.returnsTheAcceptedWord());

    }

    @Test
    public void goodReachedFinalStatus2() throws StatusException, SymbolException {

        Automat automat = new AutomatImpl();

        automat.readSymbol( "A");

        Assert.assertTrue(automat.checkIfFinalStatusWasReached());

        Assert.assertEquals("A", automat.returnsTheAcceptedWord());

    }

    @Test
    public void goodReachedFinalStatus5() throws StatusException, SymbolException {

        Automat automat = new AutomatImpl();

        automat.readSymbol( "B");

        automat.readSymbol( "C");

        automat.readSymbol( "B");

        automat.readSymbol( "C");


        Assert.assertTrue(automat.checkIfFinalStatusWasReached());

        Assert.assertEquals("BCBC", automat.returnsTheAcceptedWord());

    }

    @Test
    public void goodReachedFinalStatus3() throws StatusException, SymbolException {

        Automat automat = new AutomatImpl();

        automat.readSymbol( "Z");

        Assert.assertTrue(automat.checkIfFinalStatusWasReached());

        Assert.assertEquals("Z", automat.returnsTheAcceptedWord());

    }
    @Test
    public void goodReachedFinalStatus4() throws StatusException, SymbolException {

        Automat automat = new AutomatImpl();

        automat.readSymbol( "C");

        Assert.assertTrue(automat.checkIfFinalStatusWasReached());

        Assert.assertEquals("C", automat.returnsTheAcceptedWord());

    }

    @Test
    public void goodCheckIfAutomatCanReadMoreSymbols() throws StatusException, SymbolException {

        Automat automat = new AutomatImpl();

        automat.readSymbol("B");

        Assert.assertTrue(automat.CheckIfCanReadMoreSymbols());

    }

    @Test
    public void badCheckIfAutomatCanReadMoreSymbols() throws StatusException, SymbolException {

        Automat automat = new AutomatImpl();

        automat.readSymbol("A");

       Assert.assertFalse(automat.CheckIfCanReadMoreSymbols());

    }

    @Test (expected = SymbolException.class)
    public void badReadWrongSymbol() throws StatusException, SymbolException {

        Automat automat = new AutomatImpl();

        automat.readSymbol("L");

    }

    @Test (expected = SymbolException.class)
    public void badReadWrongSymbol2() throws StatusException, SymbolException {

        Automat automat = new AutomatImpl();

        automat.readSymbol("B");

        automat.readSymbol("A");

    }

    @Test (expected = StatusException.class)
    public void badTryToReadSymbolAfterEndzustand() throws StatusException, SymbolException {

        Automat automat = new AutomatImpl();

        automat.readSymbol("B");

        automat.readSymbol("Z");

        automat.readSymbol("B");

    }

    @Test (expected = StatusException.class)
    public void badTryToGetAcepptedWordWithoutBeingInEndZustand() throws StatusException, SymbolException {

        Automat automat = new AutomatImpl();

        automat.readSymbol("B");

        automat.readSymbol("C");

        automat.readSymbol("A");


        automat.returnsTheAcceptedWord();

    }

    @Test (expected = StatusException.class)
    public void badReachedFinalStatus() throws StatusException, SymbolException {

        Automat automat = new AutomatImpl();

        automat.readSymbol( "C");

        automat.readSymbol( "A");

    }



}
