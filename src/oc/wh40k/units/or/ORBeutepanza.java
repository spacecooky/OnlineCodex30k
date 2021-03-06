package oc.wh40k.units.or;


import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORBeutepanza extends Eintrag {

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

	public ORBeutepanza() {

		name = "Beutepanza";
		grundkosten = 35;

		add(ico = new oc.Picture("oc/wh40k/images/Beutepanza.gif"));
		

		ogE.addElement(new OptionsGruppeEintrag("Donnarohr", 70));
		ogE.addElement(new OptionsGruppeEintrag("Gitbrenna", 15));
		add(FK2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Fette Wumme", 5));
		ogE.addElement(new OptionsGruppeEintrag("Bazzukka", 10));
		add(BeutepanzaFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(Zugetakkat = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zugetakkat", 10));
		add(rotäFarbä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rotä Farbä", 5));
		add(Grothälfaz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grothälfaz", 5));
		add(Stikkbombschlueda = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbombschleuda", 5));
		add(Panzaplattenz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzaplattenz", 10));
		add(Entaplankä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Entaplankä", 5));
		add(Abrizzbirnä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Abrizzbirnä", 10));
		add(VastärktäRammä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vastärktä Rammä", 5));
		add(Megagreifa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Megagreifa", 5));

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
	}
}
