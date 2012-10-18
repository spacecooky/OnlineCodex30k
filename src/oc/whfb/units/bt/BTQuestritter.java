package oc.whfb.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class BTQuestritter extends Eintrag {

	AnzahlPanel squad;
	
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	
	RuestkammerStarter rkBanner;

	public BTQuestritter() {
		name = BuildaHQ.translate("Questritter");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Questritter"), 5, 12, 28);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEDunkelelfenkrieger.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 9));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 18));
		
		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "BTBanner", "");
		rkBanner.initKammer(true, true, false, false);
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
