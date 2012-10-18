package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CDSchaedelsammler extends CDHerold {

	public CDSchaedelsammler() {

		name = "Schädelsammler";

		grundkosten = 140;

		this.setEintragsCNT(0.5);

		add(ico = new oc.Picture("oc/wh40k/images/CDSchaedelsammler.gif"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Moloch", 35));
		ogE.addElement(new OptionsGruppeEintrag("Streitwagen des Khorne", 20));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();

	}

	@Override
	public void refreshen() {
            super.refreshen();
            setUnikat(true);
	}
}
