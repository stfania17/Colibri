///////////DAVID CHEVEZ__M2A__||13||04||2021|| //////// 
package VALIDACIONES;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.JOptionPane;


public class Letras extends KeyAdapter{

    @Override
    public void keyTyped(KeyEvent e){
        super.keyTyped(e);

          char c=e.getKeyChar();
          if(Character.isDigit(c)) {
              e.consume();
              JOptionPane.showMessageDialog(null, "Ingresar solo letras");
          }
    }
}
///////////DAVID CHEVEZ__M2A__||13||04||2021|| ////////