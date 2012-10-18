package oc.wh40k.units.cm2007;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CM2007ChaosVindicator extends Eintrag {

	public CM2007ChaosVindicator() {
		name = "Chaos-Vindicator";
		grundkosten = 125;

		add(ico = new oc.Picture("oc/wh40k/images/ChaosVindicator.gif"));
		

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zusätzliche Panzerung", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Dämonenmaschine", 20));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Litanei des Chaos", 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sync. Bolter", "Synchronisierter Bolter", 5));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Inferno-Raketenwerfer", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
	}

}
