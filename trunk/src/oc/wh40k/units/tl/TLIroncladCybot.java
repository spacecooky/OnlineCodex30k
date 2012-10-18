package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class TLIroncladCybot extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsUpgradeGruppe o3;
	RuestkammerStarter rkPod;

	public TLIroncladCybot() {
		name = "Ironclad-Cybot";
		grundkosten = 135;

		BuildaHQ.addToInformationVector("TLElite", 1);
		
		add(ico = new oc.Picture("oc/wh40k/images/SMIroncladCybot.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("CNKW & Sturmbolter", "Cybot-Nahkampfwaffe und Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("CNKW & Schwerer Flamer", "Cybot-Nahkampfwaffe und Schwerer Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Hurricane-Bolter", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator(8);

		ogE.addElement(new OptionsGruppeEintrag("Hammer + Melter", "Seismischer Hammer und Melter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Hammer + Schw. Flamer", "Seismischer Hammer und Schwerer Flammenwerfer", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + Melter", "Kettenfaust und Melter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kettenfaust + Schw. Flamer", "Kettenfaust und Schwerer Flammenwerfer", 5));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator(8);

		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Radar-Suchkopfrakete", 2, 10));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmgranatwerfer", "Ironclad-Sturmgranatwerfer", 15));

		seperator();

		rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "TLDropPodKammer", "Landungskapsel");
		rkPod.initKammer(true);
		rkPod.setButtonText("Landungskapsel");
		rkPod.setSeperator(0);
		add(rkPod);

		complete();
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("TLElite", -1);
		super.deleteYourself();
	}
	
	@Override
	public void refreshen() {
		if (!o1.isSelected()) {
			o1.setSelected(0, true);
		}

		if (!o2.isSelected()) {
			o2.setSelected(0, true);
		}
		
		int selectedSquads = BuildaHQ.getCountFromInformationVector("TLElite");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("TLEnableHonourGuard");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("SM-Eliteauswahlen > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}

}
