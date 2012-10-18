package oc.wh40k.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class BTChampiondesImperators extends Eintrag {

	OptionsUpgradeGruppe o1;

	public BTChampiondesImperators() {
		name = "Champion des Imperators";
		grundkosten = 90;
		setEintragsCNT(0);

		add(ico = new oc.Picture("oc/wh40k/images/BTChampiondesImperators.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("Nimm jede Herausf. an", "Nimm jede Herausforderung an", 50));
		ogE.addElement(new OptionsGruppeEintrag("Wahre die Ehre", "Wahre die Ehre des Imperators", 10));
		ogE.addElement(new OptionsGruppeEintrag("Meide die Unreinen", 35));
		ogE.addElement(new OptionsGruppeEintrag("Zerschmettere die Hexe", 20));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		o1.setSelected(0, true);

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
		if(!o1.isSelected()) o1.setSelected(0, true);

		// Only count Emperor's Champion as a HQ selection if no other HQ is selected
		if( BuildaHQ.getCountFromInformationVector("BTHQ") == 0 ) {
			setEintragsCNT(1);
		} else {
			setEintragsCNT(0);
		}
	}

}
