package oc.wh40k.units.sf;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;

public class SFLandRaiderAchilles extends Eintrag {

	public SFLandRaiderAchilles() {
            name = "Land Raider Achilles";
            grundkosten = 325;

            add(ico = new oc.Picture("oc/wh40k/images/SMLandRaiderHelios.jpg"));
            

            seperator();

            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Bulldozerschaufel", 5));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Sturmbolter", 10));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Radarsuchkopfrakete", 10));
            add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Siege shield", 10));

            complete();
	}

	@Override
	public void refreshen() {
	}

}
