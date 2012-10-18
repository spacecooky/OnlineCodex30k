package oc.whfb.units.de;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DESchwarzeGardevonNaggarond extends Eintrag {

	AnzahlPanel squad;
	OptionsUpgradeGruppe o1;
	OptionsEinzelUpgrade oeM;
	OptionsEinzelUpgrade oeS;
	RuestkammerStarter rkBoss;
	RuestkammerStarter rkBanner;
	
	public DESchwarzeGardevonNaggarond() {
		name = BuildaHQ.translate("Schwarze Garde von Naggarond");
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, BuildaHQ.translate("Schwarze Gardisten"), 5, 20, 13);
		squad.setGrundkosten(0);
		add(squad);

		add(ico = new oc.Picture("oc/images/DESchwarzeGardevonNaggarond.jpg"));

		seperator();

		add(oeM = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Musiker"), 7));
		add(oeS = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", BuildaHQ.translate("Standartenträger"), 14));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Champion"), 14));
		ogE.addElement(new OptionsGruppeEintrag(BuildaHQ.translate("Kouran"), 75));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DEMagicItems", "");
		rkBoss.initKammer(false, true, false, false);
		rkBoss.setButtonText(BuildaHQ.translate("Magische Gegenstände"));
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);

		seperator();

		rkBanner = new RuestkammerStarter(ID, randAbstand, cnt, "DEBanner", "");
		rkBanner.initKammer(false, true, false, false);
		rkBanner.setButtonText(BuildaHQ.translate("Magische Standarte"));
		rkBanner.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBanner);

		complete();
	}

	@Override
	public void refreshen() {
		rkBoss.setAktiv(o1.isSelected(BuildaHQ.translate("Champion")));
		rkBanner.setAktiv(oeS.isSelected());
	}
}
