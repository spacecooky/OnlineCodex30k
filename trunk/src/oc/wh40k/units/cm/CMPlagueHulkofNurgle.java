package oc.wh40k.units.cm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CMPlagueHulkofNurgle extends Eintrag {

	OptionsEinzelUpgrade o1;
	OptionsEinzelUpgrade o2;
	OptionsEinzelUpgrade o3;

	public CMPlagueHulkofNurgle() {
		name = "Plague Hulk of Nurgle";
		grundkosten = 205;

		add(ico = new oc.Picture("oc/wh40k/images/CMPlagueHulkofNurgle.jpg"));

		seperator();

		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zwei Cybot-NKWs", "Zwei Cybot-Nahkampfwaffen", 0));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rancid Vomit Attack", 0));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rot Cannon", 0));
//      auch wenns sinnlos ist, bitte nicht entfernen, da sonst die Fehlermeldung nicht richtig angezeigt wird

		complete();
	}

	@Override
	public void refreshen() {
        o1.setSelected(true);
        o2.setSelected(true);
        o3.setSelected(true);
	}

}
