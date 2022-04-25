/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Block;
import java.util.List ;

/**
 *
 * @author DELL
 */
public class Cadena {
    
    public class CadenaDeBloques {

        private List bloques;

        public CadenaDeBloques() {
        }

        public CadenaDeBloques(List bloques) {
            this.bloques = bloques;
        }

        public List getBloques() {
            return bloques;
        }

        public void setBloques(List bloques) {
            this.bloques = bloques;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }

            CadenaDeBloques cadena = (CadenaDeBloques) o;

            if (bloques.size() != cadena.getBloques().size()) {
                return false;
            }

            for (int i = 0; i < bloques.size(); i++) {
                if (bloques.get(i) != cadena.getBloques().get(i)) {
                    return false;
                }
            }

            return true;
        }

        @Override
        public String toString() {
            return bloques.toString();
        }
    }

}
