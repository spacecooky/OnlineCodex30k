package oc.wh40k.units.cd;

import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CDHerolddesSlaanesh extends CDHerold {

	public CDHerolddesSlaanesh() {

		name = "Herold des Slaanesh";

		grundkosten = 50;

		this.setEintragsCNT(0.5);

		add(ico = new oc.Picture("oc/wh40k/images/CDHerolddesSlaanesh.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Slaaneshpferd", 15));
		ogE.addElement(new OptionsGruppeEintrag("Jagdstreitwagen","Jagdstreitwagen des Slaanesh", 30));
		ogE.addElement(new OptionsGruppeEintrag("Erhabener Jagdstreitwagen","Erhabener Jagdstreitwagen des Slaanesh", 80));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Lähmender Blick", 5));
		ogE.addElement(new OptionsGruppeEintrag("Einlullender Duft", 15));
		ogE.addElement(new OptionsGruppeEintrag("Chaosikone", 25));
		ogE.addElement(new OptionsGruppeEintrag("Pavane des Slaanesh", 20));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenblick", 15));
		ogE.addElement(new OptionsGruppeEintrag("Unheilige Stärke", 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

		complete();
	}

	@Override
	public void refreshen() {
        super.refreshen();
	}
}
