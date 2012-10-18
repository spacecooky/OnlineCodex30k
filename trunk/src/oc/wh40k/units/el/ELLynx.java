package oc.wh40k.units.el;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;

public class ELLynx extends Eintrag {

        OptionsUpgradeGruppe o1;
        OptionsUpgradeGruppe o2;
        
        public ELLynx() {

            name = "Lynx";
            grundkosten = 320;

            add(ico = new oc.Picture("oc/wh40k/images/ELCobra.gif"));
            
            ogE.addElement(new OptionsGruppeEintrag("pulsar", 0));
            ogE.addElement(new OptionsGruppeEintrag("sonic lance", 0));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("shuriken cannon", 0));
            ogE.addElement(new OptionsGruppeEintrag("scatter laser", 10));
            ogE.addElement(new OptionsGruppeEintrag("star cannon", 25));
            ogE.addElement(new OptionsGruppeEintrag("bright lance", 30));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Star engines", 30));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vectored engines", 40));


            complete();

        }

	//@OVERRIDE
	public void refreshen() {
            o1.alwaysSelected();
            o2.alwaysSelected();

	}
}
