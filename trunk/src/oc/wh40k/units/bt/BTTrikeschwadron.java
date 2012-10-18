package oc.wh40k.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class BTTrikeschwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;

	public BTTrikeschwadron() {
		name = "Trikeschwadron";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Trikes", 2, 3, 50);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BTTrikeschwadron.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 0));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(squad.getModelle());
	}

}
