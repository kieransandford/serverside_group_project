package com.example.PokemonBackEndProject;

public enum GenerationList {

    KANTO(1, "I"),
    JOHTO(2, "II"),
    HOENN(3, "III"),
    SINNOH(4, "IV"),
    UNOVA(5, "V"),
    KALOS(6, "VI"),
    ALOLA(7, "VII"),
    GALAR(8, "VIII");


    GenerationList(int generationNumber, String numeral){
        this.generationNumber = generationNumber;
        this.numeral = numeral;
    }
    private final int generationNumber;

    public int getGenerationNumber() {
        return generationNumber;
    }

    private final String numeral;

    public String getNumeral(){
        return numeral;
    }

}
