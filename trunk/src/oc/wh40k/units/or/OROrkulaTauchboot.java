package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class OROrkulaTauchboot extends Eintrag {

	OptionsZaehlerGruppe FK;

	public OROrkulaTauchboot() {

		name = "Orkula-Tauchboot";
		grundkosten = 350;

		add(ico = new oc.Picture("oc/wh40k/images/OrkulaTauchboot.gif"));

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Schiffskanonä", 120));

		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Fette Wumme", 5));
		ogE.addElement(new OptionsGruppeEintrag("Fette Wumme(FLA)","Fette Wumme mit FLA-System", 10));
		FK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3);

		add(FK);

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
	}
}
