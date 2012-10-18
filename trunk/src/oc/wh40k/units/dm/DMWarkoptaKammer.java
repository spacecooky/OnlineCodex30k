package oc.wh40k.units.dm;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class DMWarkoptaKammer extends RuestkammerVater {

	public DMWarkoptaKammer() {
		grundkosten = 65;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/Warkopta.gif"));
		

        ogE.addElement(new OptionsGruppeEintrag("Skorcha", 0));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kustom Mega Blasta", 15));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "twin Rattler Kannon", 10));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red Paint Job", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb Chukkas", 5));
        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Bigbombs", 2,15));


		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
       
	}

}
