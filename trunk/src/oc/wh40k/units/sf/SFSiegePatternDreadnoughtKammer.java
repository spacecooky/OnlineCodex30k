package oc.wh40k.units.sf;

import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class SFSiegePatternDreadnoughtKammer  extends RuestkammerVater {

	OptionsUpgradeGruppe o1;

	public SFSiegePatternDreadnoughtKammer () {
            grundkosten = 120;
	}

        @Override
	public void initButtons(boolean... defaults) {

            add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderGross.jpg"));


            ogE.addElement(new OptionsGruppeEintrag("Flamestorm Cannon", 0));
            ogE.addElement(new OptionsGruppeEintrag("Multimelter", 0));
            add(o1 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));
            
            seperator();

            add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Radar-Suchkopfrakete", 2, 10));

            sizeSetzen();
	}

	@Override
	public void refreshen() {
            o1.alwaysSelected();
	}
        
}