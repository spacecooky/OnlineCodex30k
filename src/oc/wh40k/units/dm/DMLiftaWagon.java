package oc.wh40k.units.dm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class DMLiftaWagon extends Eintrag {

	OptionsEinzelUpgrade rot‰Farb‰;
	OptionsEinzelUpgrade Groth‰lfaz;
	OptionsEinzelUpgrade Stikkbombschlueda;
	OptionsEinzelUpgrade Panzaplattenz;
	OptionsEinzelUpgrade Entaplank‰;
	OptionsEinzelUpgrade Abrizzbirn‰;
	OptionsEinzelUpgrade Megagreifa;
	OptionsUpgradeGruppe RammGruppe;
	OptionsZaehlerGruppe KampfpanzaFK;

	public DMLiftaWagon() {

		name = "Lifta Wagon";
		
		kategorie = 5;

		grundkosten = 225;







		add(ico = new oc.Picture("oc/wh40k/images/Kampfpanza.gif"));

		

		ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 5));

		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 10));



		KampfpanzaFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2);

		add(KampfpanzaFK);





		seperator();





		ogE.addElement(new OptionsGruppeEintrag("Deff Rolla", 20));

		ogE.addElement(new OptionsGruppeEintrag("Reinforced Ram", 5));



		RammGruppe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);

		add(RammGruppe);



		seperator();

		seperator(5);



		
		rot‰Farb‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red Paint Job", 5);

		add(rot‰Farb‰);

		Groth‰lfaz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot Riggas", 5);

		add(Groth‰lfaz);

		Stikkbombschlueda = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb Chukka", 5);

		add(Stikkbombschlueda);

		Panzaplattenz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armour Plates", 10);

		add(Panzaplattenz);

		Entaplank‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boarding Plank", 5);

		add(Entaplank‰);

		Abrizzbirn‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wreckin\' Ball", 10);

		add(Abrizzbirn‰);

		Megagreifa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grabbin\' Klaw", 5);

		add(Megagreifa);





		seperator();











		complete();



	}

	//@OVERRIDE
	public void refreshen() {
	}
}
