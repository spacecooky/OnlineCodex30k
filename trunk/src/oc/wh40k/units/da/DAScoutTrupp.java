package oc.wh40k.units.da;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DAScoutTrupp extends Eintrag {

	OptionsUpgradeGruppe trupp;
	OptionsEinzelZaehler o1;
	OptionsUpgradeGruppe o2;

	RuestkammerStarter rkBoss;

	public DAScoutTrupp() {
		name = "Scout-Trupp";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/DAScoutSquad.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("5 Scouts", 80));
		ogE.addElement(new OptionsGruppeEintrag("10 Scouts", 145));
		add(trupp = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(o1 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Scharfschützengewehre", 0, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 20));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Landungskapsel", 50));

		seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "DASergeant", "Upgrade zum Sergeant");
		rkBoss.initKammer(false, true);
		rkBoss.setUeberschriftTrotzNullKostenAusgeben(true);
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
        
		if (!trupp.isSelected()) {
			trupp.setSelected(0, true);
		}

		int freieModelle = trupp.isSelected("5 Scouts") ? 5 : 10;

		if (o2.isSelected()) {
			--freieModelle;
		}

		o1.setMaxAnzahl(freieModelle);
	}

}
