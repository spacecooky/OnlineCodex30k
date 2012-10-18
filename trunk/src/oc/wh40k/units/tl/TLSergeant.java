package oc.wh40k.units.tl;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class TLSergeant extends RuestkammerVater {

	OptionsZaehlerGruppe o1;

	public TLSergeant() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
		if(defaults.length >= 1 && defaults[0]) {
			ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 10));
		}
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		if(defaults.length > 1) {
			seperator();

			if(defaults.length >= 2 && defaults[1]) {
				add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
			}
			if(defaults.length >= 3 && defaults[2]) {
				add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Teleport-Peilsender", 15));
			}
			if(defaults.length >= 4 && defaults[3]) {
				add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 25));
			}
		}

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

	@Override
	public void switchEntry(String name, boolean aktiv) {
		if(name.equals("ScoutBikeSarge")) {
			o1.setMaxAnzahl(aktiv == true ? 1 : 2);
		}
		if(name.equals("BikeSarge")) {
			o1.setMaxAnzahl(aktiv == true ? 1 : 2);
		}
	}
	
}
