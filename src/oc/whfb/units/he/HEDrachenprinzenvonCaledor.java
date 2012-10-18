package oc.whfb.units.he;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class HEDrachenprinzenvonCaledor extends Eintrag {

	AnzahlPanel squad;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkBanner;
	
	public HEDrachenprinzenvonCaledor() {
		name = BuildaHQ.translate("Drachenprinzen von Caledor");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Drachenprinzen von Caledor"), 5, 100, 30);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/HEPhoenixgarde.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 20));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 20));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "HEMagicItems", "");
		rkBoss.initKammer(false, true, false, false);
		rkBoss.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "HEBanner", "");
		rkBanner.initKammer(true, true, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		rkBoss.setAktiv(oeC.isSelected());
		rkBanner.setAktiv(oeS.isSelected());
		rkBoss.getKammer().switchEntry(BuildaHQ.translate("Maske des Meeresfürsten"), false);	
	}
}
