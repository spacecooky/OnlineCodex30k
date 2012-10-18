package oc.wh40k.units.sw;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class SWEhrwuerdigerCybot extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	RuestkammerStarter rkPod;

	public SWEhrwuerdigerCybot() {
		name = "Ehrwürdiger Cybot";
		grundkosten = 165;

		add(ico = new oc.Picture("oc/wh40k/images/SWEhrwuerdigerCybot.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Cybot-Nahkampfwaffe", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Raketenwerfer", 10));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o3.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schwerer Flamer", "Schwerer Flammenwerfer", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmkanone", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Flamer", "Synchronisierter Schwerer Flamer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Schwerer Bolter", "Synchronisierter Schwerer Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Maschinenkanone", "Synchronisierte Maschinenkanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 10));
		ogE.addElement(new OptionsGruppeEintrag("Sync. Laserkanone", "Synchronisierte Laserkanone", 30));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected("multi-melta", true);

		seperator(8);

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wolfszahnkette", 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wolfsschwanz Talisman", 5));

		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Saga des Erhabenen", 15));

		seperator();

		rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "SWDropPodKammer", "Landungskapsel");
		rkPod.initKammer(true);
		rkPod.setButtonText("Landungskapsel");
		rkPod.setSeperator(0);
		add(rkPod);

		complete();
	}

	@Override
	public void refreshen() {
		if (!o1.isSelected()) {
			o1.setSelected("Sturmbolter", true);
		}

		if (!o2.isSelected()) {
			o2.setSelected("Multimelter", true);
		}

		if (!o3.isSelected()) {
			o3.setSelected("Cybot-Nahkampfwaffe", true);
		}

		o1.setAktiv(o3.isSelected("Cybot-Nahkampfwaffe"));
	}

}
