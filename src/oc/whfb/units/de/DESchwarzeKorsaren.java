package oc.whfb.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DESchwarzeKorsaren extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	OptionsEinzelUpgrade oeC;
	RuestkammerStarter rkBanner;
	
	public DESchwarzeKorsaren() {
		name = BuildaHQ.translate("Schwarze Korsaren");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Schwarze Korsaren"), 10, 100, 10);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DESchwarzeKorsaren.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Zwei Handwaffen"), 0));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("HW & Handarmbrust"), BuildaHQ.translate("Handwaffe und Repetier-Handarmbrust"), 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 5));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 10));
		add(oeC = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Champion"), 10));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", BuildaHQ.translate("2 Repetier-Handarmbrüste"), 3));

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "DEBanner", "");
		rkBanner.initKammer(true, false, false, true);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);
		oe1.setAktiv(oeC.isSelected());
		rkBanner.setAktiv(oeS.isSelected());
	}

}
