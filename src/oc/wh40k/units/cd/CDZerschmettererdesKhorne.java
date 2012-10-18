package oc.wh40k.units.cd;


import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CDZerschmettererdesKhorne extends Eintrag {

	AnzahlPanel CDZerschmettererdesKhorne;
	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;

	public CDZerschmettererdesKhorne() {

		name = "Zerschmetterer des Khorne";

		grundkosten = 0;



		CDZerschmettererdesKhorne = new AnzahlPanel(ID, randAbstand, cnt, "Zerschmetterer des Khorne", 1, 8, 40);

		add(CDZerschmettererdesKhorne);





		add(ico = new oc.Picture("oc/wh40k/images/CDZerschmettererdesKhorne.gif"));

		seperator();







		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zorn des Khorne", 10));

		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Chaosikone", 25));

		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Instrument des Chaos", 5));

		seperator();





		complete();

	}

	@Override
	public void refreshen() {



		int summe = o1.getSelectedAsInt() + o2.getSelectedAsInt() + o3.getSelectedAsInt();



		o1.setLegal(summe <= CDZerschmettererdesKhorne.getModelle() || !o1.isSelected());

		o2.setLegal(summe <= CDZerschmettererdesKhorne.getModelle() || !o2.isSelected());

		o3.setLegal(summe <= CDZerschmettererdesKhorne.getModelle() || !o3.isSelected());



	}
}
