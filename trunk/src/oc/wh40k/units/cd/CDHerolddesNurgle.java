package oc.wh40k.units.cd;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class CDHerolddesNurgle extends CDHerold {

	public CDHerolddesNurgle() {

		name = "Herold des Nurgle";

		grundkosten = 50;

		this.setEintragsCNT(0.5);

		add(ico = new oc.Picture("oc/wh40k/images/CDHerolddesNurgle.gif"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sänfte des Nurgle", 15));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Ätzende Berührung", 10));
		ogE.addElement(new OptionsGruppeEintrag("Chaosikone", 25));
		ogE.addElement(new OptionsGruppeEintrag("Fliegenwolke", 5));
		ogE.addElement(new OptionsGruppeEintrag("Aura des Verfalls", 15));
		ogE.addElement(new OptionsGruppeEintrag("Odem des Chaos", 30));
		ogE.addElement(new OptionsGruppeEintrag("Unheilige Stärke", 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 3));

		complete();

	}

	@Override
	public void refreshen() {
        super.refreshen();
	}
}
