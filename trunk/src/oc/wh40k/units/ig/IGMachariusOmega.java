package oc.wh40k.units.ig;

import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IGMachariusOmega extends Eintrag {


	public IGMachariusOmega() {
		name = "Macharius Omega";
		grundkosten = 355;


		add(ico = new oc.Picture("oc/wh40k/images/Macharius.gif"));
		


		ogE.addElement(new OptionsGruppeEintrag("Hunter-killer Missile", 10));
		ogE.addElement(new OptionsGruppeEintrag("Storm Bolter", "Pintle-mounted Storm Bolter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Stubber", "Pintle-mounted Heavy Stubber", 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
                seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy Stubbers", "Side Sponsons with Heavy Stubbers", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Bolters", "Side Sponsons with Heavy Bolters", 10));
		ogE.addElement(new OptionsGruppeEintrag("Heavy Flamers", "Side Sponsons with Heavy Flamers", 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
		complete();

	}

	public void refreshen() {
	}
}
