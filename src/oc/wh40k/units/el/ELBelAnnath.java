/* Experimentelle Regeln zu finden unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/w/wraithseer.pdf
*/

package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;

public class ELBelAnnath extends Eintrag {
        
        public ELBelAnnath() {
            name = "Bel-Annath";
            grundkosten = 175;

            add(ico = new oc.Picture("oc/wh40k/images/ELBelAnnath.gif"));

            BuildaHQ.addToInformationVector("ELBelAnnath", 1);
            
            complete();

        }

    public void deleteYourself() {
    	BuildaHQ.addToInformationVector("ELBelAnnath", -1);
        super.deleteYourself();
    }
    
	//@OVERRIDE
	public void refreshen() {
	}
}
