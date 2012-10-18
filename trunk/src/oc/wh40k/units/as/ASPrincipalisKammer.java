package oc.wh40k.units.as;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ASPrincipalisKammer extends RuestkammerVater {

	OptionsZaehlerGruppe o1;

	public ASPrincipalisKammer() {}

	public void initButtons(boolean... defaults) {
		name = "Principalis\n";
		grundkosten = 65;

		BuildaHQ.addToInformationVector("ASPrincipalis", 1);

		add(ico = new oc.Picture("oc/wh40k/images/ASPrincipalis.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Kettenschwert", 0));
		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 3));
		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Condemnor-Bolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Plasma-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Inferno-Pistole", 15));
		ogE.addElement(new OptionsGruppeEintrag("Eviscerator", 25));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rosarius", 25));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Melterbomben", 5));

		sizeSetzen();
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("ASPrincipalis", -1);
		super.deleteYourself();
	}

	@Override
	public void refreshen() {
	}

}
