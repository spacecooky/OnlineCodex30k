package oc.wh40k.units.ta;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class TAShasoRmyr extends Eintrag {

	OptionsZaehlerGruppe o1;

	public TAShasoRmyr() {
		name = "Shas'o R'myr";
		grundkosten = 160;

		add(ico = new oc.Picture("oc/wh40k/images/TAShasORMyr.jpg"));
		

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Angriffsdrohne", 10));
		ogE.addElement(new OptionsGruppeEintrag("Schilddrohne", 15));
		ogE.addElement(new OptionsGruppeEintrag("Markerdrohne", 30));
		add(o1 = new OptionsZaehlerGruppe(0, randAbstand, cnt, "", ogE, 2));

		complete();
	}

	@Override
	public void refreshen() {
        setUnikat(true);
		o1.setLegal(o1.getAnzahl() > 0);
	}

}
