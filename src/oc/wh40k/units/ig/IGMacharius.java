package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IGMacharius extends Eintrag {

        OptionsUpgradeGruppe o1;

	public IGMacharius() {
		name = "Macharius";
		grundkosten = 325;


		add(ico = new oc.Picture("oc/wh40k/images/Macharius.gif"));
		


                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "hunter-killer missile", 10));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "improved comms", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "minesweeper", 0));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "heavy stubber", "pintle-mounted heavy stubber", 10));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "searchlight", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "smoke launchers", 0));

                seperator();

		ogE.addElement(new OptionsGruppeEintrag("heavy stubbers", "sponsons with heavy stubbers", 0));
		ogE.addElement(new OptionsGruppeEintrag("heavy bolters", "sponsons with heavy bolters", 10));
		ogE.addElement(new OptionsGruppeEintrag("heavy flamers", "sponsons with heavy flamers", 10));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
		complete();

	}

	public void refreshen() {
            if (!o1.isSelected()) o1.setSelected(0,true);
	}
}
