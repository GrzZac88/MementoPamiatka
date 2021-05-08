

public class Memento {

    //Tutaj aktualnie zapisany stan notatnika

    private String Zapiski;

    // Zapisz nową część do Memento

    public Memento(String articleSave) { Zapiski = articleSave; }

    // Przywróć zapisany w Memento stan zapisków

    public String getSavedArticle() { return Zapiski; }


}
