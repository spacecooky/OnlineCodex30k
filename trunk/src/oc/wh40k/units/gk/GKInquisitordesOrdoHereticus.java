package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class GKInquisitordesOrdoHereticus extends Eintrag {

    OptionsZaehlerGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsEinzelUpgrade psi;

	public GKInquisitordesOrdoHereticus() {
            name = "Inquisitor des Ordo Hereticus";
            grundkosten = 25;

            BuildaHQ.addToInformationVector("GKInquisitor", 1);

            add(ico = new oc.Picture("oc/wh40k/images/GKInquisitordesOrdoHereticus.jpg"));
            
            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 10));
            ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
            ogE.addElement(new OptionsGruppeEintrag("Infernopistole", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
            ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
            ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
            ogE.addElement(new OptionsGruppeEintrag("Condemnor-Bolter", 15));
//            ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", 15));
            ogE.addElement(new OptionsGruppeEintrag("Energiehammer", 20));
            ogE.addElement(new OptionsGruppeEintrag("Nullstab", 25));
            ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
            add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

            seperator();

            add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Servo-Schädel", 3, 3));

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Servorüstung", 8));
            ogE.addElement(new OptionsGruppeEintrag("Psiokular", 25));
            add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 100));

            seperator();

            add(psi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterschaftsgrad 1", 30));
//            psi.setToolTipText("Psioniker-Inquisitor muss ein Psischwert erhalten!");

            seperator();

            ogE.addElement(new OptionsGruppeEintrag("Hammerfaust", 0));
            ogE.addElement(new OptionsGruppeEintrag("Psionischer Bund", 0));
            add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

            complete();
	}

	@Override
	public void refreshen() {
            o2.setAktiv(psi.isSelected());
            if(psi.isSelected()) o2.alwaysSelected();

            o1.setAktiv("Psischwert", psi.isSelected());

//            if(psi.isSelected() && !o1.isSelected("Psischwert")) {
//                o1.setLegal(false);
//            } else {
//                o1.setLegal(true);
//            }
        }

	@Override
	public void deleteYourself() {
            super.deleteYourself();
            BuildaHQ.addToInformationVector("GKInquisitor", -1);
	}

}
