package oc.wh40k.units.sf;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SFIroncladCybotKammer  extends RuestkammerVater {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;

	public SFIroncladCybotKammer () {
            grundkosten = 135;
	}

	public void initButtons(boolean... defaults) {

            add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderGross.jpg"));


            ogE.addElement(new OptionsGruppeEintrag("CNKW & Sturmbolter", "Cybot-Nahkampfwaffe und Sturmbolter", 0));
            ogE.addElement(new OptionsGruppeEintrag("CNKW & Schwerer Flamer", "Cybot-Nahkampfwaffe und Schwerer Flammenwerfer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Hurricane-Bolter", 0));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();
            
            ogE.addElement(new OptionsGruppeEintrag("Hammer + Melter", "Seismischer Hammer und Melter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Hammer + Schw. Flamer", "Seismischer Hammer und Schwerer Flammenwerfer", 5));
            ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + Melter", "Kettenfaust und Melter", 0));
            ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + Schw. Flamer", "Kettenfaust und Schwerer Flammenwerfer", 5));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            
            seperator();

            add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Radar-Suchkopfrakete", 2, 10));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmgranatwerfer", "Ironclad-Sturmgranatwerfer", 15));

            sizeSetzen();
	}

	@Override
	public void refreshen() {
            o1.alwaysSelected();
            o2.alwaysSelected();
	}
        
}