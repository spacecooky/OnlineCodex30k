package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class TAAngriffsdrohnenschwarm extends Eintrag {

	AnzahlPanel Angriffsdrohnenschwarm;

	public TAAngriffsdrohnenschwarm() {

		name = "Angriffsdrohnenschwarm";

		grundkosten = 0;



		Angriffsdrohnenschwarm = new AnzahlPanel(ID, randAbstand, cnt, "Angriffsdrohnen", 4, 8, 12);

		add(Angriffsdrohnenschwarm);





		add(ico = new oc.Picture("oc/wh40k/images/Angriffsdrohnenschwarm.gif"));



		complete();

	}

	//@OVERRIDE
	public void refreshen() {
	}
}
