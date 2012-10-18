package oc.wh40k.units.sm;

import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class SMScoutSergeant extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;
	OptionsZaehlerGruppe bolter;
	OptionsZaehlerGruppe boltpistole;

	public SMScoutSergeant() {
		grundkosten = 10;
	}

	@Override
	public void initButtons(boolean... defaults) {
		
		
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 0));
		add(bolter = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 0));
		add(boltpistole = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		bolter.setAnzahl(0, 1);
		boltpistole.setAnzahl(0, 1);
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kampfmesser", 0));
		ogE.addElement(new OptionsGruppeEintrag("Scharfschützengew.", "Scharfschützengewehr", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flamer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasma", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiewaffe", 15));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 25));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 1));
		
		seperator();
		
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Teleport-Peilsender", 15));

		sizeSetzen();
	}

	@Override
	public void refreshen() {
		o1.setMaxAnzahl(1-bolter.getAnzahl()-(boltpistole.isSelected()?o2.getAnzahl():0));
		o2.setMaxAnzahl(2-boltpistole.getAnzahl()-(bolter.getAnzahl()>o1.getAnzahl()?bolter.getAnzahl():o1.getAnzahl()));
		
		boolean legal=o1.getAnzahl()+o2.getAnzahl()+bolter.getAnzahl()+boltpistole.getAnzahl()==2;
		boltpistole.setLegal(legal);
		bolter.setLegal(legal);
		o1.setLegal(legal);
		o2.setLegal(legal);
		
	}
}
