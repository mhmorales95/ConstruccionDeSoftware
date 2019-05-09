/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pasteleria;

/**
 *
 * @author Mauricio
 */
public class Pasteleria {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        MySQL m = new MySQL();
        m.getConnection();
        MenuPrincipal mp = new MenuPrincipal();
        mp.setVisible(true);
        
    }
    
}
