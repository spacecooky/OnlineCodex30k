package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class ORFlakpanza extends Eintrag {

	public ORFlakpanza() {
		name = "Flakpanza";
		grundkosten = 60;


		add(ico = new oc.Picture("oc/wh40k/images/Flakpanza.gif"));
		


        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Leuchtspurwumme", "Grot-Leuchtspurwumme", 15));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rot� Farb�", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot H�lfaz", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzaplattenz", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Abrizzbirn�", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vast�rkt� Ramm�", 5));

		complete();

	}

	public void refreshen() {
	}
}
