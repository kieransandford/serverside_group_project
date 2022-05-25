package com.example.PokemonBackEndProject;

public enum GenerationList {

    Kanto(1, "I"),
    Johto(2, "II"),
    Hoenn(3, "III"),
    Sinnoh(4, "IV"),
    Unova(5, "V"),
    Kalos(6, "VI"),
    Alola(7, "VII"),
    Galar(8, "VIII");


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
