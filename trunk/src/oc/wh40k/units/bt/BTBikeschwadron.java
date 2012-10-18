package oc.wh40k.units.bt;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class BTBikeschwadron extends Eintrag {

	AnzahlPanel squad;
	OptionsZaehlerGruppe o1;
	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;

	public BTBikeschwadron() {
		name = "Bikeschwadron";
		grundkosten = 0;

		squad = new AnzahlPanel(ID, randAbstand, cnt, "Biker", 3, 5, 32);
		add(squad);

		add(ico = new oc.Picture("oc/wh40k/images/BTBikeschwadron.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Flammenwerfer", 3));
		ogE.addElement(new OptionsGruppeEintrag("Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmawerfer", 6));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		seperator();

		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sprenggranaten", 0));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Trike (Schwerer Bolter)", "Trike mit Schwerem Bolter", 50));
		ogE.addElement(new OptionsGruppeEintrag("Trike (Multimelter)", "Trike mit Multimelter", 65));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		complete();
	}

	@Override
	public void refreshen() {
		oe1.setPreis(squad.getModelle() * 1);
		
		
	}

}
