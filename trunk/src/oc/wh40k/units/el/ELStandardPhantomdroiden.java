package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ELStandardPhantomdroiden extends Eintrag {

	AnzahlPanel StandardPhantomdroiden;
	OptionsEinzelUpgrade boss;
	RuestkammerStarter r�stkammer;

	public ELStandardPhantomdroiden() {

		name = "StandardPhantomdroiden";

		grundkosten = 0;



		StandardPhantomdroiden = new AnzahlPanel(ID, randAbstand, cnt, "Phantomdroiden", 10, 10, 35);

		add(StandardPhantomdroiden);

		seperator();



		add(ico = new oc.Picture("oc/wh40k/images/StandardPhantomdroiden.gif"));





		r�stkammer = new RuestkammerStarter(ID, randAbstand, cnt, "ELRunenleserKammer", "Runenleser");

		r�stkammer.initKammer(false, true);

		add(r�stkammer);

		seperator(10);









		r�stkammer.setAbwaehlbar(false); // nur mit runenleser UND 10 Phantomdroiden als Standard...

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
	}
}
