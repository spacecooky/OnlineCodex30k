package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;

public class TYJagdhierodule extends Eintrag {
        
        public TYJagdhierodule() {

            name = "Jagdhierodule";
            grundkosten = 700;

            add(ico = new oc.Picture("oc/wh40k/images/TYJagdhierodule.gif"));
            
            complete();

        }

	//@OVERRIDE
	public void refreshen() {
	}
}
