package oc.wh40k.units.or;

import oc.BuildaHQ;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;
import oc.RuestkammerVater;

public class ORMekboyJunkaKammer extends RuestkammerVater {

	OptionsZaehlerGruppe o1;
    OptionsUpgradeGruppe o4;
    OptionsUpgradeGruppe o5;
    OptionsEinzelZaehler o6;

	public ORMekboyJunkaKammer() {
		grundkosten = 65;
	}

	public void initButtons(boolean... defaults) {
		add(ico = new oc.Picture("oc/wh40k/images/OrkMekboyJunka.gif"));
		

        ogE.addElement(new OptionsGruppeEintrag("Reinforced Ram", 0));
		ogE.addElement(new OptionsGruppeEintrag("Deff Rolla", 0));
		ogE.addElement(new OptionsGruppeEintrag("Wreckin\' Ball", 0));
		ogE.addElement(new OptionsGruppeEintrag("Grabbin\' Klaw", 0));
		add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "\'Ard Case", 10));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Stikkbomb Chukkas", 5));
        add(new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Red Paint Job", 5));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Big Shoota", 0));
		ogE.addElement(new OptionsGruppeEintrag("Skorcha", 0));
		ogE.addElement(new OptionsGruppeEintrag("Rokkit Launcha", 5));
		ogE.addElement(new OptionsGruppeEintrag("twin Big Shoota", "twin-linked Big Shoota", 10));
		ogE.addElement(new OptionsGruppeEintrag("twin Rokkit Launcha", "twin-linked Rokkit Launcha", 15));
		ogE.addElement(new OptionsGruppeEintrag("Kustom Mega-Blasta", 15));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 3));

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Supa-Skorcha", "Turret-mounted Supa-Skorcha", 20));
		ogE.addElement(new OptionsGruppeEintrag("Big-Zzappa", "Turret-mounted Big-Zzappa", 30));
		ogE.addElement(new OptionsGruppeEintrag("Force Field Generator", "Kustom Force Field Generator", 75));
		ogE.addElement(new OptionsGruppeEintrag("Shokk Attack Gun", "Turret-mounted Shokk Attack Gun", 100));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator(5);

        add(o6 = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot Bomm", 2, 15));

		sizeSetzen();
	}

	// @OVERRIDE
	public void refreshen() {
        o4.alwaysSelected();
        o1.setLegal(o1.getAnzahl() == o1.getMaxAnzahl());
        o5.setAktiv(!o6.isSelected());
        o6.setAktiv(!o5.isSelected());
	}

}
