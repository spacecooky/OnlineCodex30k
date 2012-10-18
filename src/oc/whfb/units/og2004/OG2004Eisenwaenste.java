package oc.whfb.units.og2004;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;
import oc.whfb.armies.VOLKOgerAB2004;

public class OG2004Eisenwaenste extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;

	public OG2004Eisenwaenste() {
		name = BuildaHQ.translate("Eisenwänste");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Eisenwänste"), 3, 16, 48);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/OGEisenwaenste.jpg"));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Spähgnoblar"), 5));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 10));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 20));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 20));

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "OG2004Banner", "");
		rkBanner.initKammer(true, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);
		
		VOLKOgerAB2004.EISENWAENSTE++;

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setAktiv(oeS.isSelected());
		rkBanner.setAktiv(oeS.isSelected());
	}

	@Override
	public void deleteYourself() {
		VOLKOgerAB2004.EISENWAENSTE--;
		super.deleteYourself();
	}
	
	

}
