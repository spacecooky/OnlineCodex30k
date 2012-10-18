package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;

public class IGMaschinenseher extends Eintrag {

	OptionsZaehlerGruppe o1;
	OptionsZaehlerGruppe o2;

	public IGMaschinenseher() {
		name = "Maschinenseher";
		grundkosten = 45;
		this.setEintragsCNT(0);

		BuildaHQ.addToInformationVector("IGTechpriestEnginseer", 1);

		add(ico = new oc.Picture("oc/wh40k/images/IGTechpriestEnginseer.jpg"));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Melterbomben", 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Servitor", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Schwerer Bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Multimelter", 30));
		ogE.addElement(new OptionsGruppeEintrag("Plasmakanone", 30));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		BuildaHQ.addToInformationVector("IGMaschinenseher", 1);
		
		complete();
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("IGMaschinenseher") > 2) {
			setFehlermeldung("0-2 Auswahl!");
		} else {
			setFehlermeldung("");
		}

		o2.setMaxAnzahl( o1.getAnzahl() > 2 ? 2 : o1.getAnzahl() );
	}

	@Override
	public void deleteYourself() {
		BuildaHQ.addToInformationVector("IGMaschinenseher", -1);
	}

}
