package oc.whfb.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class BTRitterdesKoenigs extends Eintrag {

	AnzahlPanel squad;
	 
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	
	RuestkammerStarter rkBanner;

	public BTRitterdesKoenigs() {
		name = BuildaHQ.translate("Ritter des Königs");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Ritter des Königs"), 5, 15, 24);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEDunkelelfenkrieger.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 8));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 16));
		
		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "BTBanner", "");
		rkBanner.initKammer(true, false, false, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		rkBanner.setAktiv(oeS.isSelected());		
	}
}
