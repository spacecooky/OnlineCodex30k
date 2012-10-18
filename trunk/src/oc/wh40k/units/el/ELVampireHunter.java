package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;

public class ELVampireHunter extends Eintrag {

        public ELVampireHunter() {

            name = "Vampire Hunter";
            grundkosten = 730;

            add(ico = new oc.Picture("oc/wh40k/images/ELVampireHunter.gif"));
                        complete();

        }

	//@OVERRIDE
	public void refreshen() {
	}
}
