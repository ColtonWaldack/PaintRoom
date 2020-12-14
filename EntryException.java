import javax.swing.*;

public class EntryException extends Exception {
    public EntryException(){
        super("Error: You must enter a value in all information boxes");
        JOptionPane.showMessageDialog(null, "You must enter a value into all of the information boxes");
    }
    public EntryException(String message){
        super(message);
        JOptionPane.showMessageDialog(null, message);
    }
}
