package oc.wh40k.units.gk;

import oc.BuildaHQ;
import oc.Eintrag;
import oc.OptionsEinzelUpgrade;
import oc.OptionsEinzelZaehler;
import oc.OptionsGruppeEintrag;
import oc.OptionsUpgradeGruppe;
import oc.OptionsZaehlerGruppe;

public class GKInquisitordesOrdoMalleus extends Eintrag {

    OptionsZaehlerGruppe o1;
    OptionsUpgradeGruppe o2;
    OptionsUpgradeGruppe o3;
    OptionsUpgradeGruppe o4;
    OptionsUpgradeGruppe o5;
    OptionsEinzelUpgrade psi;

	public GKInquisitordesOrdoMalleus() {
		name = "Inquisitor des Ordo Malleus";
		grundkosten = 25;

        BuildaHQ.addToInformationVector("GKInquisitor", 1);

		add(ico = new oc.Picture("oc/wh40k/images/GKInquisitordesOrdoMalleus.jpg"));
		
		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Energieschwert", 10));
		ogE.addElement(new OptionsGruppeEintrag("Plasmapistole", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Energiefaust", 15));
		ogE.addElement(new OptionsGruppeEintrag("Erlöser-Flamer", "Erlöser-Flammenwerfer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 15));
		ogE.addElement(new OptionsGruppeEintrag("Dämonenklinge", 15));
		ogE.addElement(new OptionsGruppeEintrag("Höllengewehr", 15));
		ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
		add(o1 = new OptionsZaehlerGruppe(ID, randAbstand, cnt, "", ogE, 2));

		seperator();

		ogE.addElement(new OptionsGruppeEintrag("Servo-Rüstung", 8));
		ogE.addElement(new OptionsGruppeEintrag("Terminatorrüstung", 40));
		add(o2 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Sturmbolter", 0));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Flammenwerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Melter", 10));
		ogE.addElement(new OptionsGruppeEintrag("Kombi-Plasmawerfer", 10));
		ogE.addElement(new OptionsGruppeEintrag("Psibolter", 15));
		ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
		add(o3 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Dämonenhammer", "Nemesis-Dämonenhammer", 0));
		ogE.addElement(new OptionsGruppeEintrag("Psischwert", 0));
        add(o4 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE));

		seperator();

		add(new OptionsEinzelZaehler(ID, randAbstand, cnt, "", "Servo-Schädel", 3, 3));

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Psiaktive Munition", 5));
		ogE.addElement(new OptionsGruppeEintrag("Empyreische Hirnminen", 10));
		add(new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 100));

        seperator();

		add(psi = new OptionsEinzelUpgrade(ID, randAbstand, cnt, "", "Meisterschaftsgrad 1", 30));
//        psi.setToolTipText("Psioniker-Inquisitor muss ein Psischwert erhalten!");

        seperator();

		ogE.addElement(new OptionsGruppeEintrag("Hammerfaust", 0));
		ogE.addElement(new OptionsGruppeEintrag("Psionischer Bund", 0));
		add(o5 = new OptionsUpgradeGruppe(ID, randAbstand, cnt, "", ogE, 1));

		complete();
	}

	@Override
	public void refreshen() {
        o1.setAktiv(!o2.isSelected("Terminatorrüstung"));
        o3.setAktiv(o2.isSelected("Terminatorrüstung"));
        o4.setAktiv(o2.isSelected("Terminatorrüstung"));

        o1.setAktiv("Psischwert", psi.isSelected() && !o2.isSelected("Terminatorrüstung"));
        o3.setAktiv("Psischwert", psi.isSelected() && o2.isSelected("Terminatorrüstung") && !o4.isSelected("Psischwert"));
        o4.setAktiv("Psischwert", psi.isSelected() && o2.isSelected("Terminatorrüstung") && !o3.isSelected("Psischwert"));
        
        o5.setAktiv(psi.isSelected());
        if(psi.isSelected()) o5.alwaysSelected();

        if(o2.isSelected("Terminatorrüstung")) o3.alwaysSelected();
        if(o2.isSelected("Terminatorrüstung")) o4.alwaysSelected();

//        if(psi.isSelected() && !o3.isSelected("Psischwert") && !o4.isSelected("Psischwert")) {
//            o3.setLegal(false);
//            o4.setLegal(false);
//        } else {
//            o3.setLegal(true);
//            o4.setLegal(true);
//        }
//
//        if(psi.isSelected() && !o1.isSelected("Psischwert")) {
//            o1.setLegal(false);
//        } else {
//            o1.setLegal(true);
//        }
	}

	@Override
	public void deleteYourself() {
		super.deleteYourself();
        BuildaHQ.addToInformationVector("GKInquisitor", -1);
	}

}
