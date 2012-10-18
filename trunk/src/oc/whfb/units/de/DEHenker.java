package oc.whfb.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DEHenker extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	RuestkammerStarter rkBanner;
	
	public DEHenker() {
		name = BuildaHQ.translate("Henker");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Henker"), 5, 100, 12);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DEHenker.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 6));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 12));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Champion"), 12));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Tullaris"), 95));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "DEBanner", "");
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
