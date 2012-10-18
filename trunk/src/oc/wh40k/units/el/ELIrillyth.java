/* Experimentelle Regeln zu finden unter:
 * http://www.forgeworld.co.uk/Downloads/Product/PDF/w/wraithseer.pdf
*/

package oc.wh40k.units.el;

import oc.Eintrag;

public class ELIrillyth extends Eintrag {
        
        public ELIrillyth() {
            name = "Irillyth";
            grundkosten = 225;

            add(ico = new oc.Picture("oc/wh40k/images/ELIrillyth.gif"));

            complete();

        }

	//@OVERRIDE
	public void refreshen() {

	}
}
