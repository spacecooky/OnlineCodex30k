package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class ORKampfpanza extends Eintrag {

	OptionsEinzelUpgrade Panzakanon‰;
	OptionsEinzelUpgrade Zugetakkat;
	OptionsEinzelUpgrade rot‰Farb‰;
	OptionsEinzelUpgrade Groth‰lfaz;
	OptionsEinzelUpgrade Stikkbombschlueda;
	OptionsEinzelUpgrade Panzaplattenz;
	OptionsEinzelUpgrade Entaplank‰;
	OptionsEinzelUpgrade Abrizzbirn‰;
	OptionsEinzelUpgrade Megagreifa;
	OptionsUpgradeGruppe RammGruppe;
	OptionsUpgradeGruppe FK2;
	OptionsZaehlerGruppe KampfpanzaFK;
	OptionsEinzelUpgrade Supakannon;

	public ORKampfpanza() {

		name = "Kampfpanza";

		grundkosten = 90;







		add(ico = new oc.Picture("oc/wh40k/images/Kampfpanza.gif"));







		ogE.addElement(new OptionsGruppeEintrag("Kanon‰", 10));

		ogE.addElement(new OptionsGruppeEintrag("Schleuda", 15));

		ogE.addElement(new OptionsGruppeEintrag("Zzapwumme", 15));



		FK2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);

		add(FK2);



		seperator();





		ogE.addElement(new OptionsGruppeEintrag("Fette Wumme", 5));

		ogE.addElement(new OptionsGruppeEintrag("Bazzukka", 10));



		KampfpanzaFK = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 4);

		add(KampfpanzaFK);





		seperator();





		ogE.addElement(new OptionsGruppeEintrag("Todeswalz‰", 20));

		ogE.addElement(new OptionsGruppeEintrag("Vast‰rkt‰ Ramm‰", 5));



		RammGruppe = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);

		add(RammGruppe);



		seperator();





		Panzakanon‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzakanon‰", 60);

		add(Panzakanon‰);

		seperator();

		Supakannon = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Supa-Kannon [IA8]", 70);

		add(Supakannon);

		seperator(5);



		Zugetakkat = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Zugetakkat", 15);

		add(Zugetakkat);

		rot‰Farb‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Rot‰ Farb‰", 5);

		add(rot‰Farb‰);

		Groth‰lfaz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Groth‰lfaz", 5);

		add(Groth‰lfaz);

		Stikkbombschlueda = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbombschlueda", 5);

		add(Stikkbombschlueda);

		Panzaplattenz = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Panzaplattenz", 10);

		add(Panzaplattenz);

		Entaplank‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Entaplank‰", 5);

		add(Entaplank‰);

		Abrizzbirn‰ = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Abrizzbirn‰", 10);

		add(Abrizzbirn‰);

		Megagreifa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Megagreifa", 5);

		add(Megagreifa);

		seperator();

		complete();



	}

	//@OVERRIDE
	public void refreshen() {
		
		FK2.setAktiv(!Supakannon.isSelected());
		Panzakanon‰.setAktiv(!Supakannon.isSelected());
		Supakannon.setAktiv(!FK2.isSelected() && !Panzakanon‰.isSelected());
	}
}
