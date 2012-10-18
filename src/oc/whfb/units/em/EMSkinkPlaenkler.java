package oc.whfb.units.em;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class EMSkinkPlaenkler extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;
	
	public EMSkinkPlaenkler() {
		name = BuildaHQ.translate("Skink Pl�nkler");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Skink Pl�nkler"), 10, 20, 7);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/EMSkinkplaenkler.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Wurfspeere und Schilde"), 1));

		seperator();

		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 6));


		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);	
	}
}
