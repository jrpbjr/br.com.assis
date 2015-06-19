/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package climed;
//import br.com.assis.background.PainelClimed;
import br.com.assis.view.ClimedMDIApplication;
import javax.swing.JFrame;


/**
 *
 * @author Jose
 */
public class Climed {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        ClimedMDIApplication frm=new ClimedMDIApplication();
       // PainelClimed painelclimed = new PainelClimed();
        
        frm.setExtendedState(JFrame.MAXIMIZED_BOTH);
       // frm.add(painelclimed);
        frm.setVisible(true);
        
    }
    
}
