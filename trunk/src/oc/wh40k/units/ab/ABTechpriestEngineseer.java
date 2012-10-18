package oc.wh40k.units.ab;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;

public class ABTechpriestEngineseer extends Eintrag {

    OptionsZaehlerGruppe o1;
    OptionsZaehlerGruppe o2;
    RuestkammerStarter rkTransport;

	public ABTechpriestEngineseer() {
		name = "Techpriest Engineseer";
		grundkosten = 45;
		this.setEintragsCNT(0);

		BuildaHQ.addToInformationVector("ABTechpriestEngineseer", 1);

		add(ico = new oc.Picture("oc/wh40k/images/IGMinistrorumPriest.jpg"));

		add(new OptionsEinzelUpgrade(ID, randAbstand + 10, cnt, "", "Melta bombs", 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Servitor", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 5));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Heavy bolter", 20));
		ogE.addElement(new OptionsGruppeEintrag("Multi-melta", 30));
		ogE.addElement(new OptionsGruppeEintrag("Plasma cannon", 30));
		add(o2 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "option", ogE, 0));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ABChimeraKammer", "Chimera Transport");
		rkTransport.initKammer();
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("ABTechpriestEngineseer") > 2) {
			setFehlermeldung("0-2 Auswahl!");
		} else {
			setFehlermeldung("");
		}
        
        o2.setMaxAnzahl(o1.getAnzahl() > 2 ? 2 : o1.getAnzahl());
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("ABTechpriestEngineseer", -1);
	}

}
