package oc.wh40k.units.rh;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class RHHeavyWeaponsSquadKammer extends RuestkammerVater {

	OptionsZaehlerGruppe o1;

	public RHHeavyWeaponsSquadKammer() {
		grundkosten = 60;
	}

    @Override
	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/IGHeavyWeaponsSquad.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Mortar team", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy stubber team", 0));
		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter team", 5));
		ogE.addElement(new OptionsGruppeEintrag("Autocannon team", 5));
		ogE.addElement(new OptionsGruppeEintrag("Missile launcher team", 10));
		ogE.addElement(new OptionsGruppeEintrag("Lascannon team", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Krak grenades", 5));

		sizeSetzen();
	}

    @Override
	public void refreshen() {
		o1.setLegal(o1.getAnzahl() == 3);
	}

}
