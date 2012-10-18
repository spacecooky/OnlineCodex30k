package oc.wh40k.units.ig;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class IGMinotaurArtilleryTank extends Eintrag {

        OptionsEinzelUpgrade o1;
        OptionsEinzelUpgrade o3;

	public IGMinotaurArtilleryTank() {
		name = "Minotaur Artillery Tank";
		grundkosten = 275;


		add(ico = new oc.Picture("oc/wh40k/images/MinotaurArtilleryTank.gif"));
		


		add(o3 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzliches Maschinengewehr", 10));
		add(o1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "zusätzlicher Sturmbolter", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Enclosed Crew Compartment", 15));
                
		complete();

	}

	public void refreshen() {
        o3.setAktiv(!o1.isSelected());
        o1.setAktiv(!o3.isSelected());
	}
}
