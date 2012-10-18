package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ELCobra extends Eintrag {

        OptionsUpgradeGruppe o1;
        
        public ELCobra() {

            name = "Cobra";
            grundkosten = 600;

            add(ico = new oc.Picture("oc/wh40k/images/ELCobra.gif"));
            
            ogE.addElement(new OptionsGruppeEintrag("shuriken cannon", 0));
            ogE.addElement(new OptionsGruppeEintrag("scatter laser", 10));
            ogE.addElement(new OptionsGruppeEintrag("missile launcher", "Eldar missile launcher", 15));
            ogE.addElement(new OptionsGruppeEintrag("star cannon", 20));
            ogE.addElement(new OptionsGruppeEintrag("bright lance", 30));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Star engines", 30));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vectored engines", 40));


            complete();

        }

	//@OVERRIDE
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0, true);
	}
}
