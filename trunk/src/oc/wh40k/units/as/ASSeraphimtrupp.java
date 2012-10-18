package oc.wh40k.units.as;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ASSeraphimtrupp extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	RuestkammerStarter rkBoss;

	public ASSeraphimtrupp() {
		name = "Seraphimtrupp\n";
		grundkosten = 0;
		�berschriftSetzen = true;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Seraphim", 5, 10, 15);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/ASSeraphimtrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("zwei Flammen-Pistolen", 20));
		ogE.addElement(new OptionsGruppeEintrag("zwei Inferno-Pistolen", 30));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));
        seperator();

		rkBoss = new RuestkammerStarter(ID, randAbstand, cnt, "ASSeraphimPrioris", "Upgrade zur Prioris");
		rkBoss.initKammer();
		add(rkBoss);
		rkBoss.setAbwaehlbar(false);

		complete();
	}

	@Override
	public void refreshen() {
        if(!rkBoss.isSelected()) rkBoss.setSelected(true);
	}

}
