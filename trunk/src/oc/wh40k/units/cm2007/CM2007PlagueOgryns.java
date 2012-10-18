package oc.wh40k.units.cm2007;

import oc.AnzahlPanel;
import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class CM2007PlagueOgryns extends Eintrag {

    OptionsEinzelUpgrade o1;

	public CM2007PlagueOgryns() {
//		name = "Plague Ogryns";
		grundkosten = 0;

		add(ico = new oc.Picture("oc/wh40k/images/CMPlagueOgryns.jpg"));

        add(new AnzahlPanel(ID, randAbstand, cnt, "Plague Ogryns", 3, 5, 50));

        seperator();

        add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Filthy Claws", 0));
//      auch wenns sinnlos ist, bitte nicht entfernen, da sonst die Fehlermeldung nicht richtig angezeigt wird

		complete();
	}

	@Override
	public void refreshen() {
        o1.setSelected(true);
	}

}
