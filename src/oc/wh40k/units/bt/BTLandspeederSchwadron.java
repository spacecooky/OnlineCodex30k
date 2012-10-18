package oc.wh40k.units.bt;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class BTLandspeederSchwadron extends Eintrag {

	OptionsZaehlerGruppe o1;

	public BTLandspeederSchwadron() {
		name = "Landspeeder Schwadron";
		grundkosten = 0;
		überschriftSetzen = true;

		add(ico = new oc.Picture("oc/wh40k/images/BTLandspeeder Schwadron.jpg"));

		ogE.addElement(new OptionsGruppeEintrag("LS mit Schwerem Bolter", "Landspeeder mit Schwerem Bolter", 50));
		ogE.addElement(new OptionsGruppeEintrag("LS mit Multimelter", "Landspeeder mit Multimelter", 65));
		ogE.addElement(new OptionsGruppeEintrag("Tornado (Sturmkanone)", "Tornado Landspeeder mit Schwerem Bolter und Sturmkanone", 80));
		ogE.addElement(new OptionsGruppeEintrag("Tornado (Multimelter)", "Tornado Landspeeder mit Multimelter und Schwerem Flammenwerfer", 75));
		ogE.addElement(new OptionsGruppeEintrag("Typhoon (Schw. Bolter)", "Typhoon Landspeeder mit Schwerem Bolter", 70));
		ogE.addElement(new OptionsGruppeEintrag("Typhoon (Multimelter)", "Typhoon Landspeeder mit Multimelter", 85));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

		complete();
	}

	@Override
	public void refreshen() {
		o1.setLegal(o1.isSelected());
	}

}
