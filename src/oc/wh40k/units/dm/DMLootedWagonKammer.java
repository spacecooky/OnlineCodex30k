package oc.wh40k.units.dm;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class DMLootedWagonKammer extends RuestkammerVater {

	OptionsEinzelUpgrade Zugetakkat;
	OptionsEinzelUpgrade rotäFarbä;
	OptionsEinzelUpgrade Grothälfaz;
	OptionsEinzelUpgrade Stikkbombschlueda;
	OptionsEinzelUpgrade Panzaplattenz;
	OptionsEinzelUpgrade Entaplankä;
	OptionsEinzelUpgrade Abrizzbirnä;
	OptionsEinzelUpgrade VastärktäRammä;
	OptionsEinzelUpgrade Megagreifa;
	OptionsUpgradeGruppe FK2;
	OptionsZaehlerGruppe BeutepanzaFK;

	public DMLootedWagonKammer() {
		grundkosten = 35;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/Beutepanza.gif"));
		

		
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", 15));
		add(FK2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 5));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 10));
		add(BeutepanzaFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(Zugetakkat = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "\'Ard Case", 10));
		add(rotäFarbä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red Paint Job", 5));
		add(Grothälfaz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot Riggers", 5));
		add(Stikkbombschlueda = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb Chukka", 5));
		add(Panzaplattenz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armour Plates", 10));
		add(Entaplankä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boarding Planks", 5));
		add(Abrizzbirnä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wreckin\' Ball", 10));
		add(VastärktäRammä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Reinforced Ram", 5));
		add(Megagreifa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grabbin\' Klaw", 5));
		
		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
	}

}
