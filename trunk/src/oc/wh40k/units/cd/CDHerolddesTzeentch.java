package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CDHerolddesTzeentch extends CDHerold {

	public CDHerolddesTzeentch() {

		name = "Herold des Tzeentch";

		grundkosten = 50;

		this.setEintragsCNT(0.5);

		add(ico = new oc.Picture("oc/wh40k/images/CDHerolddesTzeentch.gif"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flugdämon des Tzeentch", 15));
		ogE.addElement(new OptionsGruppeEintrag("Streitwagen des Tzeentch", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Ich bin Legion!", 10));
		ogE.addElement(new OptionsGruppeEintrag("Meister der Zauberei", 5));
		ogE.addElement(new OptionsGruppeEintrag("Seelenverschlinger", 20));
		ogE.addElement(new OptionsGruppeEintrag("Blitz des Tzeentch", 30));
		ogE.addElement(new OptionsGruppeEintrag("Odem des Chaos", 30));
		ogE.addElement(new OptionsGruppeEintrag("Chaosikone", 25));
		ogE.addElement(new OptionsGruppeEintrag("Wohltat der Mutation", 30));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

		complete();

	}

	@Override
	public void refreshen() {
        super.refreshen();
	}
}
