package oc.wh40k.units.ba;

import java.util.Vector;

import oc.BuildaHQ;
import oc.Chooser;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class BATodeskompanieCybot extends Eintrag {

	OptionsUpgradeGruppe o1;
	OptionsUpgradeGruppe o2;
	RuestkammerStarter rkPod;

	public BATodeskompanieCybot() {
		name = "Todeskompanie-Cybot";
		grundkosten = 125;

		BuildaHQ.addToInformationVector("BATodeskompanieCybot", 1);

		add(ico = new oc.Picture("oc/wh40k/images/BATodeskompanieCybot.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Paar Blutfäuste", 0));
		ogE.addElement(new OptionsGruppeEintrag("Paar Blutklauen", 0));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter & Melter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Schw. Flamer & Melter", "Schwerer Flammenwerfer & Melter", 10));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o2.setSelected(0, true);

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Magna-Greifer", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Suchscheinwerfer", 1));

		seperator();

		rkPod = new RuestkammerStarter(ID, randAbstand, cnt, "BATransporterKammer", "Landungskapsel");
		rkPod.initKammer(false, true, false, false, true);
		rkPod.setButtonText("Landungskapsel");
		rkPod.setSeperator(0);
		add(rkPod);

		complete();
	}

	@Override
	public void refreshen() {
		if(!o1.isSelected()) o1.setSelected(0, true);
		if(!o2.isSelected()) o2.setSelected(0, true);

		int count = 0;
		Vector<Chooser> allChooser = BuildaHQ.getChooserGruppe(3).getmC();
		for(Chooser chooser : allChooser) {
			if(chooser.getEintrag() instanceof BATodeskompanie) {
				count += ((BATodeskompanie) chooser.getEintrag()).getModelle();
			}
		}
		int maxCybots = new Double(Math.floor(count / 5)).intValue();

		if(BuildaHQ.getCountFromInformationVector("BATodeskompanieCybot") > maxCybots) {
			setFehlermeldung("Max. " + maxCybots + " TK-Cybots");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("BATodeskompanieCybot", -1);
	}

}
