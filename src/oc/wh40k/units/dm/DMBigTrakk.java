package oc.wh40k.units.dm;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class DMBigTrakk extends Eintrag {

	OptionsZaehlerGruppe o1;

	public DMBigTrakk() {
		name = "Big Trakk";
		kategorie = 5;
		grundkosten = 50;


		add(ico = new oc.Picture("oc/wh40k/images/BigTrakk.gif"));
		

        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 0));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", 5));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 10));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Kannon", 10));
		ogE.addElement(new OptionsGruppeEintrag("Lobba", 10));
		ogE.addElement(new OptionsGruppeEintrag("Supa-skrocha", 10));
		ogE.addElement(new OptionsGruppeEintrag("Zzap gun", 15));
		ogE.addElement(new OptionsGruppeEintrag("Big lobba", 20));
		ogE.addElement(new OptionsGruppeEintrag("Big-zzappa", 30));
		ogE.addElement(new OptionsGruppeEintrag("Flakka-gunz", 40));
		ogE.addElement(new OptionsGruppeEintrag("Killkannon", 45));
		ogE.addElement(new OptionsGruppeEintrag("Supa-kannon", 70));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", "pintle-mounted Big Shoota", 5));
		ogE.addElement(new OptionsGruppeEintrag("Scorcha", "pintle-mounted Scorcha", 10));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", "pintle-mounted Rokkit Launcha", 15));
		add(new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boarding plank", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Grot riggers", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red Paint Job", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb Chukkas", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "\'Ard Case", 10));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Reinforced Ram", 10));
		ogE.addElement(new OptionsGruppeEintrag("Deff Rolla", 10));
		ogE.addElement(new OptionsGruppeEintrag("Wreckin\' Ball", 10));
		ogE.addElement(new OptionsGruppeEintrag("Grabbin\' Klaw", 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot sponsons", 2, 5));

    	complete();

	}

	public void refreshen() {
		o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
	}
}
