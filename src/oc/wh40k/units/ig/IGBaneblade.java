package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class IGBaneblade extends Eintrag {

        OptionsEinzelUpgrade o1;
        OptionsEinzelUpgrade o2;
        OptionsEinzelUpgrade o3;
        OptionsUpgradeGruppe o4;
        OptionsUpgradeGruppe o5;

	public IGBaneblade() {
		name = "Baneblade";
		grundkosten = 500;


		add(ico = new oc.Picture("oc/wh40k/images/Baneblade.gif"));
		


                add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
		add(o2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zus�tzlicher Sturmbolter", 10));
		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zus�tzliches Maschinengewehr", 10));

                seperator();

		ogE.addElement(new OptionsGruppeEintrag("zwei Seitenkuppeln", 0));
		ogE.addElement(new OptionsGruppeEintrag("vier Seitenkuppeln", 100));
		ogE.addElement(new OptionsGruppeEintrag("zus�tzliche Panzerplatten", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

                seperator();

                ogE.addElement(new OptionsGruppeEintrag("Kommissar","Kommissariats-Besatzung", 25));
		ogE.addElement(new OptionsGruppeEintrag("Befehlspanzer",25));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();

	}

	public void refreshen() {
            o3.setAktiv(!o2.isSelected());
            o2.setAktiv(!o3.isSelected());
            if (!o4.isSelected()) o4.setSelected(0,true);
	}
}
