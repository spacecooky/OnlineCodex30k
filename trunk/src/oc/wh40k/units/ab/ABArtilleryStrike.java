package oc.wh40k.units.ab;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ABArtilleryStrike extends Eintrag {

    OptionsUpgradeGruppe o1;

	public ABArtilleryStrike() {
		name = "Artillery Strike";
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/ABArtilleryStrike.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("Bombard Strike", 100));
		ogE.addElement(new OptionsGruppeEintrag("Manticore Strike", 90));
		ogE.addElement(new OptionsGruppeEintrag("Basilisk Strike", 70));
		ogE.addElement(new OptionsGruppeEintrag("Griffon Strike", 50));
		ogE.addElement(new OptionsGruppeEintrag("Motrar Battery Strike", 50));
		ogE.addElement(new OptionsGruppeEintrag("Colossus Strike", 60));
		ogE.addElement(new OptionsGruppeEintrag("Medusa Strike", 60));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
        o1.alwaysSelected();
	}

}
