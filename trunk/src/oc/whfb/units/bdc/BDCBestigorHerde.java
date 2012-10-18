package oc.whfb.units.bdc;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.RuestkammerStarter;

public class BDCBestigorHerde extends Eintrag {

	OptionsEinzelUpgrade oe;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkBanner;
	AnzahlPanel squad;
	OptionsEinzelUpgrade oeC;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeM;

	public BDCBestigorHerde() {
		name = BuildaHQ.translate("Bestigor Herde");
		grundkosten = 0;
		
		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Bestigor Herde"), 10, 100, 12);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEAdliger.jpg"));
		
		seperator();
		
		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 6));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 12));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 12));
		
		seperator();
		
		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "BDCGabe", "");
		rkBoss.initKammer(true);
		rkBoss.setButtonText(BuildaHQ.translate("Gaben des Chaos"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		
		seperator();
		
		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "BDCBanner", "");
		rkBanner.initKammer(true, true, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		rkBanner.setAktiv(oeS.isSelected());
		rkBoss.setAktiv(oeC.isSelected());
	}
}
