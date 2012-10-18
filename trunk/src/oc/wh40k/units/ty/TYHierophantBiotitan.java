package oc.wh40k.units.ty;

import oc.BuildaHQ;
import oc.Eintrag;

public class TYHierophantBiotitan extends Eintrag {
        
        public TYHierophantBiotitan() {

            name = "Hierophant-Biotitan";
            grundkosten = 1250;

            add(ico = new oc.Picture("oc/wh40k/images/TYHierophantBiotitan.gif"));
            
            complete();

        }

	//@OVERRIDE
	public void refreshen() {
	}
}
