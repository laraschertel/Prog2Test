package automat;

import exceptions.StatusException;
import exceptions.SymbolException;

public class AutomatImpl implements Automat {
    private AutomatStatus automatStatus = AutomatStatus.STARTZUSTAND;
    private String acceptedWord;
    private final String A = "A";
    private final String B = "B";
    private final String C = "C";
    private final String Z = "Z";


    @Override
    public void readSymbol(String symbol) throws StatusException, SymbolException {

        if (this.automatStatus == AutomatStatus.ENDZUSTAND || this.automatStatus == AutomatStatus.BLOCKEDZUSTAND) {
            throw new StatusException("cannot read any more symbols");
        }

        if (this.automatStatus == AutomatStatus.STARTZUSTAND) {
            if (symbol == A) {
                this.automatStatus = AutomatStatus.ENDZUSTAND;
                this.acceptedWord = this.acceptedWord + A;
            } else if (symbol == C) {
                this.automatStatus = AutomatStatus.ENDZUSTAND;
                this.acceptedWord = this.acceptedWord + C;
            } else if (symbol == Z) {
                this.automatStatus = AutomatStatus.ENDZUSTAND;
                this.acceptedWord = this.acceptedWord + Z;
            } else if (symbol == B) {
                this.automatStatus = AutomatStatus.MITTELZUSTAND1;
                this.acceptedWord = this.acceptedWord + B;
            } else {
                this.automatStatus = AutomatStatus.BLOCKEDZUSTAND;
                throw new SymbolException("Not an accepted symbol: " + symbol);
            }
        } else if (this.automatStatus == AutomatStatus.MITTELZUSTAND1) {
            if (symbol == C) {
                this.automatStatus = AutomatStatus.MITTELZUSTAND2;
                this.acceptedWord = this.acceptedWord + C;
            } else if (symbol == Z) {
                this.automatStatus = AutomatStatus.ENDZUSTAND;
                this.acceptedWord = this.acceptedWord + Z;
            } else {
                this.automatStatus = AutomatStatus.BLOCKEDZUSTAND;
                throw new SymbolException("Not an accepted symbol");
            }
        } else if (this.automatStatus == AutomatStatus.MITTELZUSTAND2) {
            if (symbol == B) {
                this.automatStatus = AutomatStatus.STARTZUSTAND;
                this.acceptedWord = this.acceptedWord + B;
            } else if (symbol == A) {
                this.acceptedWord = this.acceptedWord + A;
            } else {
                this.automatStatus = AutomatStatus.BLOCKEDZUSTAND;
                throw new SymbolException("Not an accepted symbol");
            }

        }


    }

    @Override
    public boolean checkIfFinalStatusWasReached() {
        return (this.automatStatus == AutomatStatus.ENDZUSTAND);
    }

    @Override
    public String returnsTheAcceptedWord() throws StatusException {

        if (this.automatStatus != AutomatStatus.ENDZUSTAND) {
            throw new StatusException("can only return accepted word if in Endzustand");
        }
        String acceptedWordFinal = this.acceptedWord.substring(4);

        return acceptedWordFinal;
    }

    @Override
    public boolean CheckIfCanReadMoreSymbols() {

        if (this.automatStatus == AutomatStatus.ENDZUSTAND || this.automatStatus == AutomatStatus.BLOCKEDZUSTAND) {
            return false;
        } else {
            return true;
        }
    }
}
