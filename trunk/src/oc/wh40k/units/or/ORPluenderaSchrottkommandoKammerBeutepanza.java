package oc.wh40k.units.or;


import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ORPluenderaSchrottkommandoKammerBeutepanza extends RuestkammerVater {

	OptionsEinzelUpgrade Zugetakkat;
	OptionsEinzelUpgrade rot‰Farb‰;
	OptionsEinzelUpgrade Groth‰lfaz;
	OptionsEinzelUpgrade Stikkbombschlueda;
	OptionsEinzelUpgrade Panzaplattenz;
	OptionsEinzelUpgrade Entaplank‰;
	OptionsEinzelUpgrade Abrizzbirn‰;
	OptionsEinzelUpgrade Vast‰rkt‰Ramm‰;
	OptionsEinzelUpgrade Megagreifa;
	OptionsUpgradeGruppe FK2;
	OptionsZaehlerGruppe BeutepanzaFK;

	public ORPluenderaSchrottkommandoKammerBeutepanza() {
		
	}

	public void initButtons(boolean... defaults) {
		
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
		add(rot‰Farb‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rot‰ Farb‰", 5));
		add(Groth‰lfaz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Groth‰lfaz", 5));
		add(Stikkbombschlueda = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbombschleuda", 5));
		add(Panzaplattenz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzaplattenz", 10));
		add(Entaplank‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Entaplank‰", 5));
		add(Abrizzbirn‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Abrizzbirn‰", 10));
		add(Vast‰rkt‰Ramm‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Vast‰rkt‰ Ramm‰", 5));
		add(Megagreifa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Megagreifa", 5));

		sizeSetzen();
	}

	
	@Override
	public void refreshen() {
	}
}
