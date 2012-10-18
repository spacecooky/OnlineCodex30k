package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IGMalcador extends Eintrag {

        OptionsUpgradeGruppe o1;
        OptionsUpgradeGruppe o2;

	public IGMalcador() {
		name = "Malcador";
		grundkosten = 275;


		add(ico = new oc.Picture("oc/wh40k/images/Malcador.gif"));
		


                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "camo-netting", 20));
                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "extra armor", 15));
                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "hunter-killer missile", 10));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "improved comms", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "minesweeper", 0));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "heavy stubber", "pintle-mounted heavy stubber", 10));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "rough terrain modification", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "track guards", 0));
//                add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "smoke launchers", 0));

                seperator();
                
                ogE.addElement(new OptionsGruppeEintrag("heavy bolter", 0));
                ogE.addElement(new OptionsGruppeEintrag("autocannon", 5));
                ogE.addElement(new OptionsGruppeEintrag("lascannon", 15));
		add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
                seperator();

		ogE.addElement(new OptionsGruppeEintrag("heavy stubbers", "sponsons with heavy stubbers", 0));
		ogE.addElement(new OptionsGruppeEintrag("autocannons", "sponsons with autocannons", 20));
		ogE.addElement(new OptionsGruppeEintrag("lascannons", "sponsons with lascannons", 30));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));
                
		complete();

	}

	public void refreshen() {
            if (!o1.isSelected()) o1.setSelected(0,true);
            if (!o2.isSelected()) o2.setSelected(0,true);
	}
}
