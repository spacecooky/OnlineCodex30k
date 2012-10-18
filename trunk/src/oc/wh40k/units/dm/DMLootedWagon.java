package oc.wh40k.units.dm;


import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class DMLootedWagon extends Eintrag {

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

	public DMLootedWagon() {

		name = "Looted Wagon";
		
		kategorie=5;
		
		grundkosten = 35;

		add(ico = new oc.Picture("oc/wh40k/images/Beutepanza.gif"));
		

		ogE.addElement(new OptionsGruppeEintrag("Boom Gun", 70));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", 15));
		add(FK2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 5));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 10));
		add(BeutepanzaFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		add(Zugetakkat = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "\'Ard Case", 10));
		add(rot‰Farb‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red Paint Job", 5));
		add(Groth‰lfaz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot Riggers", 5));
		add(Stikkbombschlueda = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb Chukka", 5));
		add(Panzaplattenz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armour Plates", 10));
		add(Entaplank‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boarding Planks", 5));
		add(Abrizzbirn‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wreckin\' Ball", 10));
		add(Vast‰rkt‰Ramm‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Reinforced Ram", 5));
		add(Megagreifa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grabbin\' Klaw", 5));

		complete();

	}

	//@OVERRIDE
	public void refreshen() {
	}
}
