import java.util.ArrayList;


public class Caretaker {

    // Tutaj są zapisywane wszystkie migawki, memento

    // Dodaje memento do listy

    ArrayList<Memento> ZapisaneOpisy = new ArrayList<Memento>();

    public void addMemento(Memento m) {
        ZapisaneOpisy.add(m); }

        // Przywraca żądane memento z listy

    public Memento getMemento(int index) {
        return ZapisaneOpisy.get(index); }


}
