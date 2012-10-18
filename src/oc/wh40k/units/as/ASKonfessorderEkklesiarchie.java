package oc.wh40k.units.as;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ASKonfessorderEkklesiarchie extends Eintrag {

	OptionsZaehlerGruppe o1;

	public ASKonfessorderEkklesiarchie() {
		name = "Konfessor der Ekklesiarchie";
		grundkosten = 75;

		BuildaHQ.addToInformationVector("ASKonfessor", 1);

		add(ico = new oc.Picture("oc/wh40k/images/ASKonfessorderEkklesiarchie.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schrotflinte", 2));
		ogE.addElement(new OptionsGruppeEintrag("Boltpistole", 2));
		ogE.addElement(new OptionsGruppeEintrag("Bolter", 2));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Condemnor-Bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Eviscerator", 25));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Plasmawerfer", 15));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

		complete();
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("ASKonfessor", -1);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
	}

}
