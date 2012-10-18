package oc.wh40k.units.ba;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class BAFuriosoCybot extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	RuestkammerStarter rkPod;

	public BAFuriosoCybot() {
		name = "Furioso-Cybot";
		grundkosten = 125;

		add(ico = new oc.Picture("oc/wh40k/images/BAFuriosoCybot.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Paar Blutfäuste", 0));
		ogE.addElement(new OptionsGruppeEintrag("Paar Blutklauen", 0));
		ogE.addElement(new OptionsGruppeEintrag("Blutfaust & Schrapnell", "Blutfaust & Schrapnell-Kanone", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter & Melter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schw. Flamer & Melter","Schwerer Flammenwerfer & Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flammenwerfer", 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Magna-Greifer", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));

		seperator();

		rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "BATransporterKammer", "Landungskapsel");
		rkPod.initKammer(false, true, false, false);
		rkPod.setButtonText("Landungskapsel");
		rkPod.setSeperator(0);
		add(rkPod);

		complete();
	}

	@Override
	public void refreshen() {
        o2.setAktiv(true);

        boolean twoWeapons = !o1.isSelected("Blutfaust & Schrapnell-Kanone");
        o2.setAktiv("Sturmbolter & Melter", twoWeapons);
        o2.setAktiv("Schwerer Flammenwerfer & Melter", twoWeapons);
        o2.setAktiv("Sturmbolter", !twoWeapons);
        o2.setAktiv("Melter", !twoWeapons);
        o2.setAktiv("Schwerer Flammenwerfer", !twoWeapons);

        if(!o1.isSelected()) o1.setSelected(0, true);

        if(!o2.isSelected() && twoWeapons) {
            o2.setSelected(0, true);
        }

        if(!o2.isSelected() && !twoWeapons) {
            o2.setSelected(2, true);
        }
	}

}
