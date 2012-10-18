package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;

public class TAGreatKnarlocBaggageHerd extends Eintrag {
	
	AnzahlPanel boyz;

	public TAGreatKnarlocBaggageHerd() {

		kategorie = 5;

		name = "Great Knarloc Baggage Herd\n";
		grundkosten = 25;
		überschriftSetzen=true;

		add(boyz = new AnzahlPanel(ID, randAbstand, cnt, "Kroot Goads", 1, 2, 10));
		
		add(ico = new oc.Picture("oc/wh40k/images/GreatKnarlocBaggageHerd.gif"));
		
		complete();
	}

	@Override
	public void refreshen() {
		if(BuildaHQ.getCountFromInformationVector("TAFeuerkrieger") < 1) {
        	setFehlermeldung("1+ Feuerkrieger");
        } else {
        	setFehlermeldung("");
        }
	}
}
