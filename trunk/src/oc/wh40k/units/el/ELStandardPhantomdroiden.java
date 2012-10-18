package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class ELStandardPhantomdroiden extends Eintrag {

	AnzahlPanel StandardPhantomdroiden;
	OptionsEinzelUpgrade boss;
	RuestkammerStarter rüstkammer;

	public ELStandardPhantomdroiden() {

		name = "StandardPhantomdroiden";

		grundkosten = 0;



		StandardPhantomdroiden = new AnzahlPanel(ID, randAbstand, cnt, "Phantomdroiden", 10, 10, 35);

		add(StandardPhantomdroiden);

		seperator();



		add(ico = new oc.Picture("oc/wh40k/images/StandardPhantomdroiden.gif"));





		rüstkammer = new RuestkammerStarter(ID, randAbstand, cnt, "ELRunenleserKammer", "Runenleser");

		rüstkammer.initKammer(false, true);

		add(rüstkammer);

		seperator(10);









		rüstkammer.setAbwaehlbar(false); // nur mit runenleser UND 10 Phantomdroiden als Standard...

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
	}
}
