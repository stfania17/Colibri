///////////DAVID CHEVEZ__M2A__||13||04||2021|| //////// 
package VALIDACIONES;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;

 
public class Decimales extends KeyAdapter{
    
    public void keyTyped(KeyEvent e){
        super.keyTyped(e);
        char validar = e.getKeyChar();
        String b=Character.toString(validar);
        //////////////////
        if (Character.isLetter(validar)){
            e.consume();
            JOptionPane.showMessageDialog(null, "Ingresar solo numeros");
        }
        ///////////////////
        if(b.contains(",")){
        e.consume();
        JOptionPane.showMessageDialog(null, "Sin comas.");    
        }
    }   
}
///////////DAVID CHEVEZ__M2A__||13||04||2021|| ////////