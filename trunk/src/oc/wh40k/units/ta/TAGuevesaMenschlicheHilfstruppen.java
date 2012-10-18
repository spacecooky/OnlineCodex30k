package oc.wh40k.units.ta;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class TAGuevesaMenschlicheHilfstruppen extends Eintrag {

	AnzahlPanel GueVesaTeam;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;
	OptionsEinzelUpgrade o4;

	public TAGuevesaMenschlicheHilfstruppen() {
		name = "Gue'vesa Menschliche Hilfstruppen";
		grundkosten = 0;

		GueVesaTeam = new AnzahlPanel(ID, randAbstand, cnt, "Gue'vesa'la", 6, 12, 6);
		add(GueVesaTeam);

		add(ico = new oc.Picture("oc/wh40k/images/GueVesa.jpg"));
		

		seperator();

		o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Fragmentgranaten", 1);
		add(o2);

		seperator();

		o4 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Gue'vesa'ui", 10);
		add(o4);
		seperator(5);

		o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Pulsgewehr", 3);
		add(o3);
		
		complete();
	}
	
	//@OVERRIDE
	public void refreshen() {
		o2.setModelle(GueVesaTeam.getModelle());

		if (!o4.isSelected()) {
			o3.setAktiv(false);
		} else {
			o3.setAktiv(true);
		}
		
		if(BuildaHQ.getCountFromInformationVector("TAFeuerkrieger") < 1) {
        	setFehlermeldung("1+ Feuerkrieger");
        } else {
        	setFehlermeldung("");
        }
	}
	
}
