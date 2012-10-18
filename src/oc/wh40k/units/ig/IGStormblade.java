package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IGStormblade extends Eintrag {

        OptionsEinzelUpgrade o1;
        OptionsEinzelUpgrade o3;
        OptionsUpgradeGruppe o4;

	public IGStormblade() {
		name = "Stormblade";
		grundkosten = 450;


		add(ico = new oc.Picture("oc/wh40k/images/Stormblade.gif"));
		


                add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Maschinengewehr", 10));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "improved comms", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "minesweeper", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "searchlight", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "smoke launchers", 0));

                seperator();

		ogE.addElement(new OptionsGruppeEintrag("zwei Seitenkuppeln", 0));
		ogE.addElement(new OptionsGruppeEintrag("zusätzliche Panzerplatten", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
		complete();

	}

	public void refreshen() {
            if (!o4.isSelected()) o4.setSelected(0,true);
	}
}
