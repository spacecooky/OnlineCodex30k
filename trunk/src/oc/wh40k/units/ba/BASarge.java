package oc.wh40k.units.ba;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class BASarge extends RuestkammerVater {

	OptionsZaehlerGruppe o1;

	boolean sturmbolter = false;
	boolean melterbomb = false;
	boolean teleport = false;
	boolean peilsender = false;
	boolean isProtektor = false;

	public BASarge() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {
		if(defaults[0]) isProtektor = true;
		if(defaults[1]) sturmbolter = true;
		if(defaults[2]) melterbomb = true;
		if(defaults[3]) teleport = true;
		if(defaults[4]) peilsender = true;

		if(sturmbolter) ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", isProtektor ? 5 : 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", isProtektor ? 5 : 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", isProtektor ? 5 : 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		if(isProtektor) ogE.addElement(new OptionsGruppeEintrag("Energieklaue", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		if(melterbomb)
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
		if(teleport)
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Teleport-Peilsender", 15));
		if(peilsender)
			add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 25));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
	}

//	@Override
//	public void switchEntry(String name, boolean aktiv) {
//		if(name.equals("ScoutBikeSarge")) {
//			o1.setMaxAnzahl(aktiv ? 1 : 2);
//		}
//		if(name.equals("BikeSarge")) {
//			o1.setMaxAnzahl(aktiv ? 1 : 2);
//		}
//	}

}
