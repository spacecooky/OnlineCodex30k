package oc.wh40k.units.ba;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class BAScoutSarge extends RuestkammerVater {

	OptionsZaehlerGruppe sf;
	OptionsZaehlerGruppe bp;
	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;


	public BAScoutSarge() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {

		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
		add(bp = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 0));
		add(sf = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kampfmesser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Scharfschützengew.", "Scharfschützengewehr", 0));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Peilsender", 25));

		bp.setAnzahl(0, 1);
		sf.setAnzahl(0, 1);
		
		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o2.setMaxAnzahl(1-sf.getAnzahl()-(o2.getAnzahl()>1?1:0));
		o1.setMaxAnzahl(2-sf.getAnzahl()-bp.getAnzahl()-o2.getAnzahl());
		
		boolean b=(o1.getAnzahl()+o2.getAnzahl()+sf.getAnzahl()+bp.getAnzahl()==2);
		
		o1.setLegal(b);
		o2.setLegal(b);
		sf.setLegal(b);
		bp.setLegal(b);
	}

}
