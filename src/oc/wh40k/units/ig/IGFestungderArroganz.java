package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IGFestungderArroganz extends Eintrag {

        OptionsEinzelUpgrade o1;

	public IGFestungderArroganz() {
		name = "Festung der Arroganz";
		grundkosten = 846;


		add(ico = new oc.Picture("oc/wh40k/images/FestungderArroganz.gif"));
		

                add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Yarrick","Kommissar Yarrick", 0));

		complete();

	}

	public void refreshen() {
            o1.setSelected(true);
	}
}
