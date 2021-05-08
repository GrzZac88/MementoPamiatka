
// Test programu, prosty notatnik

import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import javax.swing.*;


public class TestMemento extends JFrame {
    public static void main(String[] args) {
        new TestMemento();
    }

    private JButton Zapisz, Cofaj, Przywracaj;

    private JTextArea NaszeZapiski = new JTextArea(40, 60);

    Caretaker caretaker = new Caretaker();

    Originator originator = new Originator();
    int saveFiles = 0, currentArticle = 0;

    public TestMemento() {
        this.setSize(750, 780);
        this.setTitle("Memento Pokaz Testowy");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        JPanel panel1 = new JPanel();
        panel1.add(new JLabel("Wpisz, a potem cofnij lub przewiń w przód, co wolisz"));
        panel1.add(NaszeZapiski);

        ButtonListener saveListener = new ButtonListener();
        ButtonListener undoListener = new ButtonListener();
        ButtonListener redoListener = new ButtonListener();

        Zapisz = new JButton("Zapisz");
        Zapisz.addActionListener(saveListener);

        Cofaj = new JButton("Cofnij");
        Cofaj.addActionListener(undoListener);

        Przywracaj = new JButton("Przywróć");
        Przywracaj.addActionListener(redoListener);

        panel1.add(Zapisz);
        panel1.add(Cofaj);
        panel1.add(Przywracaj);

        this.add(panel1);
        this.setVisible(true);

    }

    class ButtonListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {

            if (e.getSource() == Zapisz) {
                String textInTextArea = NaszeZapiski.getText();
                originator.set(textInTextArea);
                caretaker.addMemento(originator.storeInMemento());
                saveFiles++;
                currentArticle++;
                System.out.println("Zapisano migawkę: " + saveFiles);
                System.out.println("Ilość zapisanych pamiątek: " + saveFiles);
                Cofaj.setEnabled(true);


            } else if (e.getSource() == Cofaj) {
                if (currentArticle >= 1) {
                    currentArticle--;
                    String textBoxString = originator.restoreFromMemento(caretaker.getMemento(currentArticle));
                    NaszeZapiski.setText(textBoxString);
                    Przywracaj.setEnabled(true);

                } else {
                    Cofaj.setEnabled(false);

                }
            } else if (e.getSource() == Przywracaj) {
                if ((saveFiles - 1) > currentArticle) {
                    currentArticle++;
                    String textBoxString = originator.restoreFromMemento(caretaker.getMemento(currentArticle));
                    NaszeZapiski.setText(textBoxString);
                    Cofaj.setEnabled(true);

                } else {

                    Przywracaj.setEnabled(false);

                }
            }
        }
    }
}






