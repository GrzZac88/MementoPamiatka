public class Originator {

    // Ustala aktualną wartość notatnika, czyli nasze zapisy / twirzy nowe

    private String article;

    public void set(String newArticle) {
        System.out.println("\nOriginator: aktualnie zapisana i dostępna do odczytu wersja dokumentu\n\n" + newArticle + "\n");

        this.article = newArticle;
    }

    // Tworzy nowe memento jako wersję notatnika, wysyła ją do Memento

    public Memento storeInMemento() {

        System.out.println("Originator: zapisano jako pamiątkę\n");
        return new Memento(article);

    }

    // Pobiera zapisany stan notatnika z memento

    public String restoreFromMemento(Memento memento) {

        article = memento.getSavedArticle();
        System.out.println(" \nOriginator: wersja zapisana jako pamiątka\nkrok w przód (Przywróć) / w tył (Cofnij):\n\n"+article + "\n");
        return article;


    }

    }
