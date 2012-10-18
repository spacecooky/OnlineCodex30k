package oc.wh40k.units.ty;

import oc.AnzahlPanel;
import oc.Eintrag;

public class TYHarridan extends Eintrag {

        AnzahlPanel o1;

        public TYHarridan() {

            name = "Harridan";
            grundkosten = 900;

            add(ico = new oc.Picture("oc/wh40k/images/TYHarridan.gif"));
            
            //add(o1 = new AnzahlPanel(ID, randAbstand, cnt, "Gargoyles", 8, 20, 12));
            //o1.setNichtDieErsteOption(true);

            complete();

        }

	//@OVERRIDE
	public void refreshen() {
	}
}
