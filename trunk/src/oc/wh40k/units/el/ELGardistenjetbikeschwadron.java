package oc.wh40k.units.el;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.RuestkammerStarter;

public class ELGardistenjetbikeschwadron extends Eintrag {

	AnzahlPanel Gardistenjetbikeschwadron;
	OptionsEinzelUpgrade o1;
	RuestkammerStarter rüstkammer;
	OptionsEinzelZaehler o5;

	public ELGardistenjetbikeschwadron() {

		name = "Gardistenjetbikeschwadron";

		grundkosten = 0;



		Gardistenjetbikeschwadron = new AnzahlPanel(ID, randAbstand, cnt, "Gardistenjetbikes", 3, 12, 22);

		add(Gardistenjetbikeschwadron);

		seperator();





		add(ico = new oc.Picture("oc/wh40k/images/Gardistenjetbikeschwadron.gif"));



		o5 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Shurikenkanone", Gardistenjetbikeschwadron.getModelle() / 3, 10);

		add(o5);

		seperator();



		rüstkammer = new RuestkammerStarter(ID, randAbstand, cnt, "ELRunenleserKammer", "Runenleser auf Jetbike");

		rüstkammer.initKammer(true, false);

		add(rüstkammer);



		complete();

	}

	//@OVERRIDE
	public void refreshen() {

		o5.setMaxAnzahl(Gardistenjetbikeschwadron.getModelle() / 3);

	}
}
