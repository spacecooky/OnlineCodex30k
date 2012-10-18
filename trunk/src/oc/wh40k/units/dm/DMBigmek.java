package oc.wh40k.units.dm;

import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.RuestkammerStarter;

public class DMBigmek extends Eintrag {

    OptionsEinzelUpgrade Munigrot;
    OptionsEinzelUpgrade CyborkKörpa;
    OptionsEinzelUpgrade Panzarüstung;
    OptionsEinzelUpgrade Trophäenstange;
    OptionsEinzelUpgrade Schnappasquik;
    OptionsUpgradeGruppe BigmekCC;
    OptionsUpgradeGruppe BigmekFK;
    OptionsEinzelZaehler Schmiergrot;
    RuestkammerStarter MekboyJunka;

    public DMBigmek() {
        kategorie = 1;
        name = "Bigmek";
        grundkosten = 35;

        add(ico = new oc.Picture("oc/wh40k/images/Bigmek.gif"));
        

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("Burna", 20));
        ogE.addElement(new OptionsGruppeEintrag("Power klaw", 25));

        BigmekCC = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(BigmekCC);

        seperator();

        ogE.addElement(new OptionsGruppeEintrag("twin Shoota", 5));
        ogE.addElement(new OptionsGruppeEintrag("Rokkit-Kombi", 5));
        ogE.addElement(new OptionsGruppeEintrag("Skorcha-Kombi", 5));
        ogE.addElement(new OptionsGruppeEintrag("Mega Blasta", 15));
        ogE.addElement(new OptionsGruppeEintrag("Mega-Armour", 40));
        ogE.addElement(new OptionsGruppeEintrag("Shokk Attack Gun", 60));
        ogE.addElement(new OptionsGruppeEintrag("Kustom Forcefield", 50));

        BigmekFK = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE);
        add(BigmekFK);

        seperator(15);

        Munigrot = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Ammo Runt", 3);
        add(Munigrot);

        CyborkKörpa = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Cybork Body", 10);
        add(CyborkKörpa);

        Panzarüstung = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "\'Eavy Armour", 5);
        add(Panzarüstung);

        Trophäenstange = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Boss Pole", 5);
        add(Trophäenstange);

        Schnappasquik = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Attack Squig", 15);
        add(Schnappasquik);

        seperator();

        Schmiergrot = new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Grot Oiler", 3, 5);
        add(Schmiergrot);

        seperator();

        MekboyJunka = new RuestkammerStarter(ID, randAbstand, cnt, "DMMekboyJunkaKammer", "Mekboy Junka");
        MekboyJunka.initKammer();
        add(MekboyJunka);

        complete();
    }

    @Override
    public void deleteYourself() {
        super.deleteYourself();
    }

    int aktivesBild = 0;

    //@OVERRIDE
    @Override
    public void refreshen() {

        if (BigmekFK.getCurrentName().equals("Schpezialkraftfeld")) {
            if (aktivesBild != 1) {
                String icon = "oc/wh40k/images/BigmekKraftfeld.gif";
                ico.setIcon(icon);

                try {
                    ico.updateSize();
                } catch (Exception e) {
                }

                aktivesBild = 1;
            }
        } else if (BigmekFK.getCurrentName().equals("Snotzogga")) {
            if (aktivesBild != 2) {
                String icon = "oc/wh40k/images/BigmekSnotzogga.gif";
                ico.setIcon(icon);

                try {
                    ico.updateSize();
                } catch (Exception e) {
                }

                aktivesBild = 2;
            }
        } else {
            if (aktivesBild != 0) {
                String icon = "oc/wh40k/images/Bigmek.gif";

                ico.setIcon(icon);

                try {
                    ico.updateSize();
                } catch (Exception e) {
                }

                aktivesBild = 0;
            }
        }
    }

}
