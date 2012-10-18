package oc.wh40k.units.as;


import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class ASPredigerderEkklesiarchie extends Eintrag {

	OptionsEinzelUpgrade mb;
	OptionsZaehlerGruppe o1;

	boolean added = false;

	public ASPredigerderEkklesiarchie() {
		name = "Prediger der Ekklesiarchie";
		grundkosten = 45;
        this.setEintragsCNT(0.0);
        
        BuildaHQ.addToInformationVector("ASPrediger", 1);

		add(ico = new oc.Picture("oc/wh40k/images/ASPredigerderEkklesiarchie.jpg"));

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

		add(mb = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

		complete();
	}

	@Override
	public void refreshen() {
		int prediger = BuildaHQ.getCountFromInformationVector("ASPrediger");
		if(prediger > 5) {
			setFehlermeldung("Prediger > 5!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
        BuildaHQ.addToInformationVector("ASPrediger", -1);
	}

}
