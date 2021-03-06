package oc.wh40k.units.dm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class DMLiftaWagon extends Eintrag {

	OptionsEinzelUpgrade rotäFarbä;
	OptionsEinzelUpgrade Grothälfaz;
	OptionsEinzelUpgrade Stikkbombschlueda;
	OptionsEinzelUpgrade Panzaplattenz;
	OptionsEinzelUpgrade Entaplankä;
	OptionsEinzelUpgrade Abrizzbirnä;
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



		
		rotäFarbä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red Paint Job", 5);

		add(rotäFarbä);

		Grothälfaz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot Riggas", 5);

		add(Grothälfaz);

		Stikkbombschlueda = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb Chukka", 5);

		add(Stikkbombschlueda);

		Panzaplattenz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Armour Plates", 10);

		add(Panzaplattenz);

		Entaplankä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boarding Plank", 5);

		add(Entaplankä);

		Abrizzbirnä = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Wreckin\' Ball", 10);

		add(Abrizzbirnä);

		Megagreifa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grabbin\' Klaw", 5);

		add(Megagreifa);





		seperator();











		complete();



	}

	//@OVERRIDE
	public void refreshen() {
	}
}
