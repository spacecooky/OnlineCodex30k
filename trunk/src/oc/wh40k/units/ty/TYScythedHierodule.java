package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;

public class TYScythedHierodule extends Eintrag {
        
        public TYScythedHierodule() {

            name = "Scythed Hierodule";
            grundkosten = 600;

            add(ico = new oc.Picture("oc/wh40k/images/TYScythedHierodule.gif"));
            
            complete();

        }

	//@OVERRIDE
	public void refreshen() {
	}
}
