package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ELVampireRaider extends Eintrag {

        OptionsUpgradeGruppe o1;
        
        public ELVampireRaider() {

            name = "Vampire Raider";
            grundkosten = 730;

            add(ico = new oc.Picture("oc/wh40k/images/ELVampireRaider.gif"));
            
            seperator();

            ogE.addElement(new OptionsGruppeEintrag("pulse lasers", "two twin-linked pulse lasers", 0));
            ogE.addElement(new OptionsGruppeEintrag("missile launcher", "two twin-linked Phoenix missile launchers", 0));
            ogE.addElement(new OptionsGruppeEintrag("pulsar", 0));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            complete();

        }

	//@OVERRIDE
	public void refreshen() {
        if(!o1.isSelected()) o1.setSelected(0,true);
	}
}
