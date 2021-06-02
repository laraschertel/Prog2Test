package automat;

import exceptions.StatusException;
import exceptions.SymbolException;

public interface Automat {

    /**
     * Reads a symbol and changes the Zustand/Status of the automat
     * @param symbol is the symbol to be read
     * @throws StatusException if the Automat is blocked or reached the final Zustand
     * @throws SymbolException if the given symbol is not accepted and the Automat is blocked
     */
    void readSymbol(String symbol) throws StatusException, SymbolException;

    /**
     *
     * @return true if final Zustand/Status was reached and false if it wasnt
     */
    boolean checkIfFinalStatusWasReached();

    /**
     *
     * @return the word that was created by the automat with the symbols that lead it to the Endzustand
     * @throws StatusException if current Zustand/Status is not Endzustand
     */
    String returnsTheAcceptedWord() throws StatusException;

    /**
     *
     * @return true if the automat is not Blocked or reached the Endzustand
     */
    boolean CheckIfCanReadMoreSymbols();

}
