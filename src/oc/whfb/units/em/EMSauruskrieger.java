package oc.whfb.units.em;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class EMSauruskrieger extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;

	public EMSauruskrieger() {
		name = BuildaHQ.translate("Sauruskrieger");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Sauruskrieger"), 10, 100, 11);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/EMSauruskrieger.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Speere"), 2));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 6));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 12));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 12));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
	}
}
