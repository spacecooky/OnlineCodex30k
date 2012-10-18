package oc.wh40k.units.ed;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class EDValkyrieSkyTalonTransport extends Eintrag {

    OptionsUpgradeGruppe o1;

	public EDValkyrieSkyTalonTransport() {
		name = "Valkyrie Sky Talon Transport";
		grundkosten = 70;

		add(ico = new oc.Picture("oc/wh40k/images/ABVulture.jpg"));
		

		ogE.addElement(new OptionsGruppeEintrag("2 Hellstrike missiles", 0));
		ogE.addElement(new OptionsGruppeEintrag("2 Rocket pots", "2 Multiple rocket pots", 30));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
		complete();
	}

	@Override
	public void refreshen() {
        setEintragsCNT(0);

        o1.alwaysSelected();
	}

}
