package oc.wh40k.units.as;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerStarter;


public class ASJuengerderEkklesiarchie extends Eintrag {

	OptionsZaehlerGruppe o1;
	RuestkammerStarter rkTransport;

	boolean added = false;

	public ASJuengerderEkklesiarchie() {
		name = "Jünger der Ekklesiarchie";
		grundkosten = 0;
		this.setEintragsCNT(0);
		überschriftSetzen = true;

		BuildaHQ.addToInformationVector("ASJuengerderEkklesiarchie", 1);

		add(ico = new oc.Picture("oc/wh40k/images/ASCelestiatrupp.jpg"));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Arco-Flagellant", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kreuzritter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Todeskultassassine", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 10));

		seperator();

		rkTransport = new RuestkammerStarter(ID, randAbstand, cnt, "ASTransporterKammer", "Transporter");
		rkTransport.initKammer(true, true);
		rkTransport.setButtonText("Transporter");
		add(rkTransport);

		complete();
	}

	@Override
	public void refreshen() {
        o1.setLegal(o1.getAnzahl() >= 3);
        
		int selectedSquads = BuildaHQ.getCountFromInformationVector("ASJuengerderEkklesiarchie");
		int possibleSquads = BuildaHQ.getCountFromInformationVector("ASKonfessor");
		if(selectedSquads > possibleSquads) {
			setFehlermeldung("Jünger > " + possibleSquads + "!");
		} else {
			setFehlermeldung("");
		}
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
		BuildaHQ.addToInformationVector("ASJuengerderEkklesiarchie", -1);
	}

}
