package oc.wh40k.units.tl;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerVater;

public class TLArvusLighter extends RuestkammerVater {

	OptionsUpgradeGruppe o2;
	OptionsEinzelUpgrade oe1;
	OptionsEinzelUpgrade oe2;

	public TLArvusLighter() {
		grundkosten = 75;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/TLArvusLighter.jpg"));
		

		
		ogE.addElement(new OptionsGruppeEintrag("TL multilaser", 20));
		ogE.addElement(new OptionsGruppeEintrag("Hellstrike missiles", 20));
		ogE.addElement(new OptionsGruppeEintrag("TL autocannon", 25));
		ogE.addElement(new OptionsGruppeEintrag("TL heavy stubbers", 25));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Flare/Chaff launcher", 10));
		add(oe1 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Armoured cockpit", 15));
		add(oe2 = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "Illum flares", 5));
		add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "option", "searchlight", 1));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
	}

}
